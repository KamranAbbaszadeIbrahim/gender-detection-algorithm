package org.java.service;

import org.java.model.RequestDto;
import org.java.model.ResourceDto;
import org.java.model.ResponseDto;

public interface GenderDetectionService {

    ResourceDto getListOfNames();

    ResponseDto detectGender(RequestDto requestDto);
}
