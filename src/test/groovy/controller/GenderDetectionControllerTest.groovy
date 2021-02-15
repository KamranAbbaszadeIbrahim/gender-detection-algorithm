package controller

import org.java.controller.GenderDetectionController
import org.java.model.RequestDto
import org.java.service.GenderDetectionService
import spock.lang.Specification

class GenderDetectionControllerTest extends Specification{
    GenderDetectionService service = Mock(GenderDetectionService)
    GenderDetectionController controller = new GenderDetectionController(service)

    def "get list of names invoke service"(){
        when:
        controller.getListOfNames()

        then:
        1 * service.getListOfNames()
    }


    def "detect gender invoke service"(){
        given:
        def request = new RequestDto("OLIVER")
        when:
        def result = controller.detectGender(request)

        then:
        1 * service.detectGender(request)
    }
}
