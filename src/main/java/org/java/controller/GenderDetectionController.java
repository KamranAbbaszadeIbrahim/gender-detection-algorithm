package org.java.controller;

import org.java.model.RequestDto;
import org.java.model.ResourceDto;
import org.java.model.ResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GenderDetectionController {

    @GetMapping("/resource")
    public ResourceDto getListOfNames(){
        return new ResourceDto();
    }

    @PostMapping("/request")
    public ResponseDto detectGender(@RequestBody RequestDto requestDto){
        return new ResponseDto();
    }
}
