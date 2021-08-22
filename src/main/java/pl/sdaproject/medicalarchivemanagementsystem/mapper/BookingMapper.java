package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.BookingResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;

@Component
public class BookingMapper {
    public BookingResponse mapBookingToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .year(booking.getFolder().getYear())
                .ledgerId(booking.getFolder().getLedgerId())
                .folderStatus(booking.getFolder().getStatus().getLabel())
                .staffName(booking.getStaff().getName())
                .staffSurname(booking.getStaff().getSurname())
                .bookingDate(booking.getBookingDate())
                .returnDate(booking.getReturnDate())
                .build();
    }
}
