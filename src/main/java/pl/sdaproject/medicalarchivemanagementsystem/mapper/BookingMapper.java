package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.BookingResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;

@Component
public class BookingMapper {
    public BookingResponse mapBookingToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .bookingDate(booking.getBookingDate())
                .loanDate(booking.getLoanDate())
                .returnDate(booking.getReturnDate())
                .build();
    }
}
