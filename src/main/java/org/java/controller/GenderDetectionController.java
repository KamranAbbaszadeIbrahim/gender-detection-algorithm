package org.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.java.model.RequestDto;
import org.java.model.ResourceDto;
import org.java.model.ResponseDto;
import org.java.service.GenderDetectionService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class GenderDetectionController {
    private final GenderDetectionService genderDetectionService;

    public GenderDetectionController(GenderDetectionService genderDetectionService) {
        this.genderDetectionService = genderDetectionService;
    }

    @GetMapping("/resource")
    public ResourceDto getListOfNames(){
        log.debug("Class: GenderDetectionController, method: getListOfNames");
        return genderDetectionService.getListOfNames();
    }

    @PostMapping("/request")
    public ResponseDto detectGender(@RequestBody RequestDto requestDto){
        log.debug("Class: GenderDetectionController, method: detectGender");
        return genderDetectionService.detectGender(requestDto);
    }
}
