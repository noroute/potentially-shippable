import spock.lang.Specification

class CharSpec extends Specification {

    def "all characters have length of one"() {
        expect:
        charToTest.length() == 1

        where:
        charToTest << ["a", "b", "c"]
    }
}
