package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.LocationResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Location;

@Component
public class LocationMapper {
    public LocationResponse mapLocationToLocationResponse(Location location) {

        return LocationResponse.builder()
                .id(location.getId())
                .roomNumber(location.getRoomNumber())
                .floor(location.getFloor())
                .build();
    }
}
