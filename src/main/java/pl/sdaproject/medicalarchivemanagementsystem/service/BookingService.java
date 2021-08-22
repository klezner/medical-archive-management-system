package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;
import pl.sdaproject.medicalarchivemanagementsystem.model.FolderStatus;
import pl.sdaproject.medicalarchivemanagementsystem.repository.BookingRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FolderService folderService;
    private final StaffService staffService;

    @Transactional
    public Booking createBooking(Long folderId, Long staffId, LocalDate bookingDate) {
        if (folderService.fetchFolder(folderId).getStatus().equals(FolderStatus.IN_ARCHIVE)) {
            final Booking booking = Booking.builder()
                    .folder(folderService.fetchFolder(folderId))
                    .staff(staffService.fetchStaff(staffId))
                    .bookingDate(bookingDate)
                    .build();

            booking.getFolder().setStatus(FolderStatus.BORROWED);

            return bookingRepository.save(booking);

        } else throw new NoSuchElementException("Folder with id: " + folderId + " is not in archive");
    }

    @Transactional
    public Booking createReturn(LocalDate returnDate, Long id) {

        final Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking with id: " + id + " not found"));

        booking.setReturnDate(returnDate);
        booking.getFolder().setStatus(FolderStatus.IN_ARCHIVE);

        return bookingRepository.save(booking);
    }
}
