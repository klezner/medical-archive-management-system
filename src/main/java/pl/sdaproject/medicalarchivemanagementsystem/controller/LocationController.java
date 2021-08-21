package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.LocationRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.LocationResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.LocationMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Location;
import pl.sdaproject.medicalarchivemanagementsystem.service.LocationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationMapper locationMapper;
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResponse> addLocation(@RequestBody @Valid LocationRequest request) {
        final Location location = locationService.createLocation(
                request.getRoomNumber(),
                request.getFloor());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locationMapper.mapLocationToLocationResponse(location));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LocationResponse> getLocation(@PathVariable Long id) {
        final Location location = locationService.fetchLocation(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationMapper.mapLocationToLocationResponse(location));
    }

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAllLocations() {
        final List<Location> locations = locationService.fetchAllLocations();

        if (locations.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(locations.stream()
                            .map(locationMapper::mapLocationToLocationResponse)
                            .collect(Collectors.toList()));
        }
    }
}
