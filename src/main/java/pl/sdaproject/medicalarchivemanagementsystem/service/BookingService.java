package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;
import pl.sdaproject.medicalarchivemanagementsystem.repository.BookingRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking createBooking(LocalDate bookingDate) {
        final Booking booking = Booking.builder()
                .bookingDate(bookingDate)
                .build();
        return bookingRepository.save(booking);
    }

    public Booking createLoan(LocalDate loanDate) {
        final Booking booking = Booking.builder()
                .loanDate(loanDate)
                .build();
        return bookingRepository.save(booking);
    }
    public Booking createReturn(LocalDate returnDate) {
        final Booking booking = Booking.builder()
                .returnDate(returnDate)
                .build();
        return bookingRepository.save(booking);
    }
}
