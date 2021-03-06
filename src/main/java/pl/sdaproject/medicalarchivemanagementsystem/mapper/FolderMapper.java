package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.FolderResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.Folder;

@Component
public class FolderMapper {

    public FolderResponse mapFolderToFolderResponse(Folder folder) {

        return FolderResponse.builder()
                .id(folder.getId())
                .year(folder.getYear())
                .ledgerId(folder.getLedgerId())
                .numberOfFolders(folder.getNumberOfFolders())
                .typeLabel(folder.getType().getLabel())
                .statusLabel(folder.getStatus().getLabel())
                .categoryName(folder.getArchiveCategory().getCategoryName())
                .storagePeriodYears(folder.getArchiveCategory().getStorageYears())
                .roomNumber(folder.getLocation().getRoomNumber())
                .floor(folder.getLocation().getFloor())
                .hospitalizationFrom(folder.getHospitalization().getHospitalizationFrom())
                .hospitalizationTo(folder.getHospitalization().getHospitalizationTo())
                .wardAbbreviation(folder.getHospitalization().getWard().getAbbreviation())
                .firstName(folder.getPatient().getFirstName())
                .lastName(folder.getPatient().getLastName())
                .pesel(folder.getPatient().getPesel())
                .build();
    }
}
