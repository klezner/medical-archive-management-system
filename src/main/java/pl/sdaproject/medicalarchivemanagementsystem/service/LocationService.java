package pl.sdaproject.medicalarchivemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdaproject.medicalarchivemanagementsystem.model.Location;
import pl.sdaproject.medicalarchivemanagementsystem.repository.LocationRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location createLocation(Integer roomNumber, Integer floor) {
        final Location location = Location.builder()
                .roomNumber(roomNumber)
                .floor(floor)
                .build();

        return locationRepository.save(location);
    }

    public Location fetchLocation(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Location with id: " + id + " doesn't exist."));
    }
}
