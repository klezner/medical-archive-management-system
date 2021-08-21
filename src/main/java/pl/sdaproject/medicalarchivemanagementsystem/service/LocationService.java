package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Location;
import pl.sdaproject.medicalarchivemanagementsystem.repository.LocationRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location createLocation(String roomNumber, Integer floor) {

        return locationRepository.findByRoomNumber(roomNumber)
                .orElseGet(() -> locationRepository.save(
                        Location.builder().roomNumber(roomNumber).floor(floor).build()
                ));
    }

    public Location fetchLocation(Long id) {

        return locationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Location with id: " + id + " doesn't exist."));
    }

    public List<Location> fetchAllLocations() {

        return locationRepository.findAll();
    }
}
