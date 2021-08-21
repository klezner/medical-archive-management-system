package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;
import pl.sdaproject.medicalarchivemanagementsystem.repository.BookingRepository;
import pl.sdaproject.medicalarchivemanagementsystem.repository.FolderRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    @Transactional
    public Booking createBooking(LocalDate bookingDate) {
        final Booking booking = Booking.builder()
                .bookingDate(bookingDate)
                .build();

        return bookingRepository.save(booking);
    }

    @Transactional
    public Booking createReturn(LocalDate returnDate, Long id) {

        final Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking with id: " + id + "not found"));

        booking.setReturnDate(returnDate);

        return bookingRepository.save(booking);
    }
}
