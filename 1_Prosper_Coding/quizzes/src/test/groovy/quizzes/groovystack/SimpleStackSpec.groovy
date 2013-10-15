package quizzes.groovystack

import spock.lang.Specification
import quizzes.groovystack.exceptions.StackEmptyException

class SimpleStackSpec extends Specification {
    GroovyStack stack = new SimpleGroovyStack()

    def "size returns 0 for empty stack"() {
        expect: false
    }

    def "throws StackEmptyException when peeking empty stack"() {
        when:
        stack.peek()

        then:
        thrown(StackEmptyException)
    }

    def "throws StackEmptyException when popping empty stack"() {
        expect: false
    }

    def "pop returns element pushed onto the stack, stack is empty then"() {
        expect: false
    }

    def "peek returns element pushed onto the stack, stack still contains element"() {
        expect: false
    }

    def "pop returns top-most element from a three-piece stack, retains two"() {
        expect: false
    }

}
