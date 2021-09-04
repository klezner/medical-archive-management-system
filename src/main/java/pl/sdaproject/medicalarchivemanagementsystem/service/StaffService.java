package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdaproject.medicalarchivemanagementsystem.model.Role;
import pl.sdaproject.medicalarchivemanagementsystem.model.Staff;
import pl.sdaproject.medicalarchivemanagementsystem.repository.StaffRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * StaffService
 *
 * @author MKgn
 */
@Service
@RequiredArgsConstructor
public class StaffService {

    private final WardService wardService;
    private final StaffRepository staffRepository;

    public Staff createStaff(String name, String surname, Role role, Long wardId) {
        final Staff staff = Staff.builder()
                .name(name)
                .surname(surname)
                .role(role)
                .ward(wardService.fetchWard(wardId))
                .build();

        return staffRepository.save(staff);
    }

    public Staff fetchStaff(Long id) {

        return staffRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Staff with id: " + id + " not found"));
    }

    public List<Staff> fetchAllLocations() {

        return staffRepository.findAll();
    }

    @Transactional
    public Staff updateStaff(Long id, String name, String surname, Role role, Long wardId) {
        final Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Staff with id: \" + id + \" not found"));

        staff.setName(name);
        staff.setSurname(surname);
        staff.setRole(role);
        staff.setWard(wardService.fetchWard(wardId));

        return staffRepository.save(staff);
    }
}
