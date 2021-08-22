package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.BookingRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.BookingResponse;
import pl.sdaproject.medicalarchivemanagementsystem.dto.PatientResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.BookingMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Booking;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;
import pl.sdaproject.medicalarchivemanagementsystem.service.BookingService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/booking")
public class BookingController {

    private final BookingMapper bookingMapper;
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> addBooking(@RequestBody @Valid BookingRequest request) {
        final Booking booking = bookingService.createBooking(
                request.getFolderId(),
                request.getStaffId(),
                request.getBookingDate());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookingMapper.mapBookingToBookingResponse(booking));
    }

    @PatchMapping
    public ResponseEntity<BookingResponse> addReturnDateToBooking(@RequestBody @Valid BookingRequest request) {
        final Booking booking = bookingService.createReturn(
                request.getReturnDate(),
                request.getId());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookingMapper.mapBookingToBookingResponse(booking));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookingResponse> getBooking(@PathVariable Long id) {
        final Booking booking = bookingService.fetchBooking(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookingMapper.mapBookingToBookingResponse(booking));
    }

    @GetMapping()
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        final List<Booking> bookings = bookingService.fetchAllBookings();

        if (bookings.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookings.stream()
                            .map(bookingMapper::mapBookingToBookingResponse)
                            .collect(Collectors.toList()));
        }
    }
}
