package org.java.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.java.model.RequestDto;
import org.java.model.ResponseDto;
import org.java.util.ResourceReaderUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringTokenizer;

@Slf4j
@Component
public class GenderDetectionAlgorithmImpl implements GenderDetectionAlgorithm{
    private static final String MALE = "MALE";
    private static final String FEMALE = "FEMALE";
    private static final String INCONCLUSIVE = "INCONCLUSIVE";

    @Override
    public ResponseDto detectGender(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setFirstAlgorithmResult(detectGenderOneTokenChecked(requestDto));
        responseDto.setSecondAlgorithmResult(detectGenderAllTokensChecked(requestDto));
        return responseDto;
    }

    private String detectGenderOneTokenChecked(RequestDto requestDto) {
        StringTokenizer stringTokenizer = new StringTokenizer(requestDto.getName());
        final String token = stringTokenizer.nextToken();
        List<String> listOfMaleNames = ResourceReaderUtils.bufferedResourceReaderToList("repository/male_tokens.txt");
        List<String> listOfFemaleNames = ResourceReaderUtils.bufferedResourceReaderToList("repository/female_tokens.txt");

        if(listOfMaleNames.stream()
            .anyMatch(name -> name.equalsIgnoreCase(token))){
            log.debug("Class: GenderDetectionAlgorithmImpl, " +
                    "method: detectGenderOneTokenChecked," +
                    "name: [{}], " +
                    "token: [{}]," +
                    "detection result: MALE", requestDto.getName(), token);
            return MALE;
        }

        if(listOfFemaleNames.stream()
            .anyMatch(name -> name.equalsIgnoreCase(token))){
            log.debug("Class: GenderDetectionAlgorithmImpl, " +
                    "method: detectGenderOneTokenChecked," +
                    "name: [{}], " +
                    "token: [{}]," +
                    "detection result: FEMALE", requestDto.getName(), token);
            return FEMALE;
        }
        log.debug("Class: GenderDetectionAlgorithmImpl, " +
                "method: detectGenderOneTokenChecked," +
                "name: [{}], " +
                "token: [{}]," +
                "detection result: INCONCLUSIVE", requestDto.getName(), token);
        return INCONCLUSIVE;
    }

    private String detectGenderAllTokensChecked(RequestDto requestDto) {
        StringTokenizer stringTokenizer = new StringTokenizer(requestDto.getName());
        long countMaleNameMatch = 0;
        long countFemaleNameMatch = 0;
        List<String> listOfMaleNames = ResourceReaderUtils.bufferedResourceReaderToList("repository/male_tokens.txt");
        List<String> listOfFemaleNames = ResourceReaderUtils.bufferedResourceReaderToList("repository/female_tokens.txt");

        while(stringTokenizer.hasMoreTokens()){
            final String token = stringTokenizer.nextToken();
            countMaleNameMatch = countMaleNameMatch + listOfMaleNames.stream()
                    .filter(name->name.equalsIgnoreCase(token))
                    .count();
            countFemaleNameMatch = countFemaleNameMatch + listOfFemaleNames.stream()
                    .filter(name->name.equalsIgnoreCase(token))
                    .count();
        }

        if(countMaleNameMatch>countFemaleNameMatch){
            log.debug("Class: GenderDetectionAlgorithmImpl, " +
                "method: detectGenderOneTokenChecked," +
                "name: [{}]," +
                "male name frequency: [{}]," +
                "female name frequency: [{}]," +
                "detection result: MALE",
                    requestDto.getName(), countMaleNameMatch, countFemaleNameMatch);
            return MALE;
        }
        else if(countMaleNameMatch<countFemaleNameMatch){
            log.debug("Class: GenderDetectionAlgorithmImpl, " +
                "method: detectGenderOneTokenChecked," +
                "name: [{}]," +
                "male name frequency: [{}]," +
                "female name frequency: [{}]," +
                "detection result: FEMALE",
                requestDto.getName(), countMaleNameMatch, countFemaleNameMatch);
            return FEMALE;
        }
        log.debug("Class: GenderDetectionAlgorithmImpl, " +
                "method: detectGenderOneTokenChecked," +
                "name: [{}]," +
                "male name frequency: [{}]," +
                "female name frequency: [{}]," +
                "detection result: INCONCLUSIVE",
                requestDto.getName(), countMaleNameMatch, countFemaleNameMatch);
        return INCONCLUSIVE;
    }
}
