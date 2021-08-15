package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;

/**
 * Maps Ward from HttpRequest to HttpResponse
 *
 * @author MKgn
 */
@Component
public class WardMapper {
    public WardResponse mapWardToWardResponse(Ward ward) {

        return WardResponse.builder()
                .id(ward.getId())
                .wardName(ward.getWardName())
                .build();
    }
}
