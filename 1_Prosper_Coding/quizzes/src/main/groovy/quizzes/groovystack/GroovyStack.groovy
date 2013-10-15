package quizzes.groovystack
public interface GroovyStack {
    /**
     * Returns the size of the stack. Side-effect free.
     * @return
     */
    int size()

    /**
     * adds elem to the top of the stack.
     * @param elem
     */
    void push(String elem)

    /**
     * removes and returns the top-most element of the stack
     * @return
     */
    String pop()

    /**
     * returns the top-most element of the stack without removing it. Side-effect free.
     * @return
     */
    String peek()
}