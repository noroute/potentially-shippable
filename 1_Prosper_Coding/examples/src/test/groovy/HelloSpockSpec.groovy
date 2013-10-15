import spock.lang.Unroll
import spock.lang.Specification

@Unroll
class HelloSpockSpec extends Specification {
  def "length of Spock's and his friends' names: #name"() {
    expect:
    name.size() == length

    where:
    name     | length
    "Spock"  | 5
    "Kirk"   | 4
    "Scotty" | 6
  }
}
