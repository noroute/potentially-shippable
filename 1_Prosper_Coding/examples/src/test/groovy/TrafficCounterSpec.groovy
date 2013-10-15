import spock.lang.Specification

class TrafficCounterSpec extends Specification{
    def counter = new SimpleTrafficCounter()
    def mockWebserver = Mock(Webserver)

    def setup() {
        counter.webserver = mockWebserver
    }

    def "counts traffic for a given url"() {
        given:
        mockWebserver.retrieve(_) >> "1234"

        when:
        def traffic = counter.trafficForUrl("someUrl")

        then:
        traffic == 4
    }

    def "counts traffic for a given url + interactions"() {

        when:
        def traffic = counter.trafficForUrl("someUrl")

        then:
        traffic == 4
        1 * mockWebserver.retrieve(_) >> "1234"
    }
}

interface TrafficCounter {
    int trafficForUrl(String url)
}

interface Webserver {
    String retrieve(String url)
}

class SimpleTrafficCounter implements TrafficCounter{
    Webserver webserver

    int trafficForUrl(String url) {
        webserver.retrieve(url).bytes.length
    }
}