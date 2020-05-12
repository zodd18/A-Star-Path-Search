import java.util.Objects;

public class Node implements Comparable<Node> {

    private int value;
    private int g;
    private int h;
    private Node previous;

    public Node(int value, int g, int h) {
        this.value = value;
        this.g = g;
        this.h = h;
        this.previous = null;
    }

    @Override
    public String toString() {
        return "(" +
                value +
                ", g:" + g +
                ", h:" + h +
                ')';
    }

    // Getters and setters

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return  g + h;
    }

    public int getValue() {
        return value;
    }


    public void setPrevious(Node n) {
        this.previous = n;
    }

    public Node getPrevious() {
        return previous;
    }

    // Comparations

    @Override
    public int compareTo(Node node) {
        return getF() - node.getF();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
