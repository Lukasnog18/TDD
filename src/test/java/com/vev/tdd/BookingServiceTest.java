package com.vev.tdd;




import com.vev.tdd.model.BookingModel;
import com.vev.tdd.repository.BookingRepository;
import com.vev.tdd.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator() {

        Assertions.assertEquals(bookingService.daysCalculator("Lucas"), 10);
        Assertions.assertEquals(bookingService.daysCalculator("Anny"), 15);
        Assertions.assertEquals(bookingService.daysCalculator("Aurora"), 5);


//        String name = "Lucas";
//        int days = bookingService.daysCalculator(name);
//
//        Assertions.assertEquals(days, 10);
//
//        String name2 = "Anny";
//        int days2 = bookingService.daysCalculator(name2);
//        Assertions.assertEquals(days2, 15);
    }

    @Test
    public void bookingTestServiceSearchNameById() {

        Assertions.assertEquals(bookingService.SearchNameById("1"), "Lucas");
        Assertions.assertEquals(bookingService.SearchNameById("2"), "Anny");
        Assertions.assertEquals(bookingService.SearchNameById("3"), "Aurora");


//        String id = "1";
//        String name = bookingService.SearchNameById(id);
//
//        Assertions.assertEquals(name, "Lucas");
//
//        String id2 = "2";
//        String name2 = bookingService.SearchNameById(id2);
//
//        Assertions.assertEquals(name2, "Anny");
    }

    @Before
    public void setup() {
        ArrayList<BookingModel> models = new ArrayList<>();

        models.add(new BookingModel("1", "Lucas", LocalDate.parse("2022-05-10"),
                LocalDate.parse("2022-05-20"), 2));

        models.add(new BookingModel("2", "Anny", LocalDate.parse("2022-05-10"),
                LocalDate.parse("2022-05-25"), 2));

        models.add(new BookingModel("3", "Aurora", LocalDate.parse("2022-05-05"),
                LocalDate.parse("2022-05-10"), 5));

        for (BookingModel model : models) {
            Mockito.when(bookingRepository.findByReserveName(model.getReserveName()))
                        .thenReturn(Optional.of(model));

            Mockito.when(bookingRepository.findById(model.getId()))
                        .thenReturn(Optional.of(model));
        }


//        BookingModel bookingModel = new BookingModel("1", "Lucas", LocalDate.parse("2022-05-10"),
//                LocalDate.parse("2022-05-20"), 2);
//
//        BookingModel bookingModel2 = new BookingModel("2", "Anny", LocalDate.parse("2022-05-10"),
//                LocalDate.parse("2022-05-25"), 2);
//
//
//        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
//                    .thenReturn(Optional.of(bookingModel));
//
//        Mockito.when(bookingRepository.findByReserveName(bookingModel2.getReserveName()))
//                .thenReturn(Optional.of(bookingModel2));
//
//        Mockito.when(bookingRepository.findById(bookingModel.getId()))
//                .thenReturn(Optional.of(bookingModel));

    }

}
