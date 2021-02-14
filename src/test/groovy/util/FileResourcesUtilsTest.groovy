import org.java.util.FileResourcesUtils
import spock.lang.Specification

class FileResourcesUtilsTest extends Specification{
    def fileResourcesUtils = new FileResourcesUtils()

    def "get exception when file not found"(){
        when:
        fileResourcesUtils.getFileFromResourceAsStream("empty")

        then:
        def error = thrown(expectedException)
        error.message == expectedMessage

        where:
        expectedException | expectedMessage
        IllegalArgumentException | "file not found empty"
    }

    def "get flat text file from resources"(){
        when:
        fileResourcesUtils.getFileFromResourceAsStream("repository/male_tokens.txt")
        then:
        noExceptionThrown()
    }
}
