import org.java.algorithm.GenderDetectionAlgorithm
import org.java.algorithm.GenderDetectionAlgorithmImpl
import org.java.model.RequestDto
import org.java.model.ResponseDto
import spock.lang.Specification

class GenderDetectionAlgorithmImplTest extends Specification{
    GenderDetectionAlgorithm algorithm = new GenderDetectionAlgorithmImpl()
    def expected = new ResponseDto("INCONCLUSIVE", "INCONCLUSIVE")

    def "check detectGenderOneTokenChecked method for positive result"(){
        given:
        def request = new RequestDto("empty")
        when:
        def result = algorithm.detectGender(request)

        then:
        result == expected
    }

    def "check detectGenderOneTokenChecked method for negative result"(){
        given:
        def request = new RequestDto("OLIVER")
        when:
        def result = algorithm.detectGender(request)

        then:
        result != expected
    }
}
