package org.java.algorithm;

import org.java.model.RequestDto;
import org.java.model.ResponseDto;

public interface GenderDetectionAlgorithm {
    ResponseDto detectGender(RequestDto requestDto);
}
