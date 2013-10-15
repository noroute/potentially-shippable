package quizzes.groovystack

import quizzes.groovystack.exceptions.StackEmptyException
import quizzes.groovystack.GroovyStack

class SimpleGroovyStack implements GroovyStack{

    def storage = []

    int size() {
        return storage.size()
    }

    void push(String elem) {
        storage << elem
    }

    String pop() {
        if (storage.isEmpty()) {
            throw new StackEmptyException()
        }
        storage.remove(storage.size()-1)
    }

    String peek() {
        if (storage.isEmpty()) {
            throw new StackEmptyException()
        }
        storage[-1]
    }
}
