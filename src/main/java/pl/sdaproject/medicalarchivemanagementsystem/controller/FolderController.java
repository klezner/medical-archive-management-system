package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaproject.medicalarchivemanagementsystem.dto.FolderRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.FolderResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.FolderMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Folder;
import pl.sdaproject.medicalarchivemanagementsystem.service.FolderService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/folder")
public class FolderController {

    private final FolderMapper folderMapper;
    private final FolderService folderService;

    @PostMapping
    public ResponseEntity<FolderResponse> addFolder(@RequestBody @Valid FolderRequest request) {
        final Folder folder = folderService.createFolder(
                request.getYear(),
                request.getLedgerId(),
                request.getNumberOfFolders(),
                request.getTypeLabel().toUpperCase(),
                request.getStatusLabel().toUpperCase()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(folderMapper.mapFolderToFolderResponse(folder));
    }
}
