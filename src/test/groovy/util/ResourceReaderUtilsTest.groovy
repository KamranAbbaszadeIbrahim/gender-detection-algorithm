import org.java.util.ResourceReaderUtils
import spock.lang.Specification

class ResourceReaderUtilsTest extends Specification{

    def "get empty when converting file into list"(){
        when:
        def result = ResourceReaderUtils.bufferedResourceReaderToList("empty")

        then:
        def expected = new LinkedList()
        expected == result
    }

    def "get list from resources"(){
        when:
        ResourceReaderUtils.bufferedResourceReaderToList("repository/male_tokens.txt")

        then:
        noExceptionThrown()
    }

}
