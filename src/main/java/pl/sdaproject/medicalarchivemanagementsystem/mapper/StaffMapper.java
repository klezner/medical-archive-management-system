package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.StaffResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Staff;

/**
 * @author MKgn
 */
@Component
public class StaffMapper {

    public StaffResponse mapStaffToStaffResponse(Staff staff) {

        return StaffResponse.builder()
                .id(staff.getId())
                .name(staff.getName())
                .surname(staff.getSurname())
                .role(staff.getRole().toString())
                .wardAbbreviation(staff.getWard().getAbbreviation())
                .build();
    }
}
