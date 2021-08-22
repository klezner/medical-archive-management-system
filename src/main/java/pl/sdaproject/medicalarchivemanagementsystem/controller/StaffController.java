package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.StaffRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.StaffResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.StaffMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Staff;
import pl.sdaproject.medicalarchivemanagementsystem.service.StaffService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StaffController
 *
 * @author MKgn
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/staff")
public class StaffController {

    private final StaffMapper staffMapper;
    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<StaffResponse> addStaff(@RequestBody @Valid StaffRequest staffRequest) {
        final Staff staff = staffService.createStaff(staffRequest.getName(), staffRequest.getSurname(), staffRequest.getRole(), staffRequest.getWardId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(staffMapper.mapStaffToStaffResponse(staff));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StaffResponse> getStaff(@PathVariable Long id) {
        final Staff staff = staffService.fetchStaff(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(staffMapper.mapStaffToStaffResponse(staff));
    }

    @GetMapping
    public ResponseEntity<List<StaffResponse>> getAllLocations() {
        final List<Staff> staff = staffService.fetchAllLocations();

        if (staff.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(staff.stream()
                            .map(staffMapper::mapStaffToStaffResponse)
                            .collect(Collectors.toList()));
        }
    }
}
