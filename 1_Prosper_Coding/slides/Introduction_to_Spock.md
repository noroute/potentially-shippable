% Render with landslide, see https://github.com/adamzap/landslide
# Meet Spock

---
# Basic Structure

    !groovy
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

---
# Spock is helpful!

    !groovy
    Condition not satisfied:
    
    length % 2 == 0
    |      |   |
    5      1   false
     <Click to see difference>
    
   at NameLengthSpec.name should have even length(NameLengthSpec.groovy:13)

---
# Reusing fixtures

    !groovy
    class StackWithOneElement extends Specification {
      def stack = new Stack()
    
      def setup() {
        stack.push("elem")
      }
    
      def "pop"() {
        when:
        def x = stack.pop()
    
        then:
        x == "elem"
        stack.size() == 0
      }
      ...
    }
    
---
# Expect and data driven specs

    !groovy
    class CharSpec extends Specification {
    
       def "all characters have length of one"() {
           expect:
           charToTest.length() == 1
           
           where:
           charToTest << ["a", "b", "c"]
       }
    }
---
# Data tables and Unroll

    !groovy
    @Unroll
    class HelloSpock extends Specification {
      
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
---
# Interactions

    !groovy
    class APublisher extends Specification {
      def pub = new Publisher()
      def sub1 = Mock(Subscriber)
      def sub2 = Mock(Subscriber)
    
      def setup() {
        pub.subscribers << sub1 << sub2 
      }
    
      def "delivers events to all subscribers"() {
        when:
        pub.send("event")
    
        then:
        1 * sub1.receive("event")
        1 * sub2.receive("event")
      }
    }

---
# Mocking

    !groovy
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
    }
   
    interface TrafficCounter {
       int trafficForUrl(String url)
    }
   
    interface Webserver {
       String retrieve(String url)
    }
--- 
# Caveat Mocking + Interactions

    !groovy
    def "counts traffic for a given url"() {

      when:
      def traffic = counter.trafficForUrl("someUrl")
   
      then:
      traffic == 4

      and:
      1 * mockWebserver.retrieve(_) >> "1234"
    }

---

# Resources

 - Documentation: https://code.google.com/p/spock/wiki
 - More Documentation: http://docs.spockframework.org/en/latest/
 - Try it in a webbrowser: http://meetspock.appspot.com/
 - Groovy Web testing: Geb! http://www.gebish.org/