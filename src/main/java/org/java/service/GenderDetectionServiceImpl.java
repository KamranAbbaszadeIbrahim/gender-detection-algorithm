package org.java.service;

import lombok.extern.slf4j.Slf4j;
import org.java.algorithm.GenderDetectionAlgorithm;
import org.java.model.RequestDto;
import org.java.model.ResourceDto;
import org.java.model.ResponseDto;
import org.java.util.ResourceReaderUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenderDetectionServiceImpl implements GenderDetectionService{
    private final GenderDetectionAlgorithm genderDetectionAlgorithm;

    public GenderDetectionServiceImpl(GenderDetectionAlgorithm genderDetectionAlgorithm) {
        this.genderDetectionAlgorithm = genderDetectionAlgorithm;
    }

    @Override
    public ResourceDto getListOfNames() {
        ResourceDto resourceDto = new ResourceDto();
        resourceDto.setListOfMaleNames(ResourceReaderUtils.bufferedResourceReaderToList("repository/male_tokens.txt"));
        resourceDto.setListOfFemaleNames(ResourceReaderUtils.bufferedResourceReaderToList("repository/female_tokens.txt"));
        log.debug("Class: GenderDetectionServiceImpl, method: getListOfNames");
        return resourceDto;
    }

    @Override
    public ResponseDto detectGender(RequestDto requestDto) {
        log.debug("Class: GenderDetectionServiceImpl, method: detectGender, name: [{}],", requestDto.getName());
        return genderDetectionAlgorithm.detectGender(requestDto);
    }
}
