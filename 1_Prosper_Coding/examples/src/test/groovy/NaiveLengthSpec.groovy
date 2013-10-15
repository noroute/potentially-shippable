import spock.lang.Specification
import spock.lang.Unroll

class NaiveLengthSpec extends Specification {
   def "name should have even length"(){

    given:
    def name = "Spock!"

    when:
    def length = name.size()

    then:
    length % 2 == 0
   }
}

