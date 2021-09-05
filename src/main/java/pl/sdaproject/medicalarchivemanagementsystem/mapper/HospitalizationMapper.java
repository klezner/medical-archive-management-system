package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.HospitalizationResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Hospitalization;

@Component
public class HospitalizationMapper {

    public HospitalizationResponse mapHospitalizationToHospitalizationResponse(Hospitalization hospitalization) {

        return HospitalizationResponse.builder()
                .dateFrom(hospitalization.getHospitalizationFrom())
                .dateTo(hospitalization.getHospitalizationTo())
                .wardAbbreviation(hospitalization.getWard().getAbbreviation())
                .build();
    }
}
