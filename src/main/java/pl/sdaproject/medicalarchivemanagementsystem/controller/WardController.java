package pl.sdaproject.medicalarchivemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.WardResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.WardMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Ward;
import pl.sdaproject.medicalarchivemanagementsystem.service.WardService;

import javax.validation.Valid;

/**
 * WardController
 *
 * @author MKgn
 */
@RestController
public class WardController {

    @Autowired
    private WardService wardService;

    @Autowired
    private WardMapper wardMapper;

    @GetMapping(path = "/ward/{id}")
    public ResponseEntity<WardResponse> getWard(@PathVariable Long id) {
        final Ward ward = wardService.fetchWard(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wardMapper.mapWardToWardResponse(ward));
    }

    @PostMapping("/ward")
    ResponseEntity<WardResponse> postWard(@RequestBody @Valid WardRequest request) {

        Ward ward = wardService.createWard(request.getWardName());
        WardResponse responseBody = wardMapper.mapWardToWardResponse(ward);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }
}
