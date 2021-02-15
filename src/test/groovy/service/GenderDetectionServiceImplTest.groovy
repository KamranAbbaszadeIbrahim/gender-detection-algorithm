package service

import org.java.algorithm.GenderDetectionAlgorithm
import org.java.model.RequestDto
import org.java.model.ResponseDto
import org.java.service.GenderDetectionService
import org.java.service.GenderDetectionServiceImpl
import spock.lang.Specification

class GenderDetectionServiceImplTest extends Specification{
    def expected = new ResponseDto("INCONCLUSIVE", "INCONCLUSIVE")
    GenderDetectionAlgorithm algorithm = Mock(GenderDetectionAlgorithm)
    GenderDetectionService service  = new GenderDetectionServiceImpl(algorithm)

    def "name list`s size not equal to zero"(){
        when:
        def result =  service.getListOfNames()

        then:
        result.listOfMaleNames.size() != 0
        result.listOfFemaleNames.size() != 0
    }


    def "detect gender invoke algorithm"(){
        given:
        def request = new RequestDto("OLIVER")
        when:
        def result = service.detectGender(request)

        then:
        1 * algorithm.detectGender(request)
    }
}
