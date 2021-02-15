package org.java.controller;

import org.java.model.RequestDto;
import org.java.model.ResourceDto;
import org.java.model.ResponseDto;
import org.java.service.GenderDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GenderDetectionController {
    private final GenderDetectionService genderDetectionService;

    public GenderDetectionController(GenderDetectionService genderDetectionService) {
        this.genderDetectionService = genderDetectionService;
    }

    @GetMapping("/resource")
    public ResourceDto getListOfNames(){
        return genderDetectionService.getListOfNames();
    }

    @PostMapping("/request")
    public ResponseDto detectGender(@RequestBody RequestDto requestDto){
        return genderDetectionService.detectGender(requestDto);
    }
}
