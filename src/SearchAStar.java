import java.util.*;

public class SearchAStar {
    private final int EMPTY = -1;

    private final int[][] map;
    private final int[] hValues;
    private final int src;
    private final int dest;

    private Stack<Node> search;

    public SearchAStar(MapGenerator mg) { this(mg.getMap(), mg.gethValues(), mg.getSrc(), mg.getDest()); }

    public SearchAStar(int[][] map, int[] hValues, int src, int dest) {
        this.map = map;
        this.hValues = hValues;
        this.src = src;
        this.dest = dest;
        this.search = search();
    }

    private SortedSet<Node> getSuccessors(Node n) {
        SortedSet<Node> successors = new TreeSet<>();

        for(int i = 0; i < map.length; i++) {
            if(map[n.getValue()][i] != EMPTY) {
                successors.add(new Node(i, map[n.getValue()][i] + n.getG(), hValues[i]));
            }
        }

        return successors;
    }

    public Stack<Node> search() {
        SortedSet<Node> openedNodes = new TreeSet<>();
        List<Node> closedNodes = new LinkedList<>();
        openedNodes.add(new Node(src, 0, hValues[src]));

        while(!openedNodes.isEmpty()) {
            Node n = openedNodes.first();
            openedNodes.remove(n);
            closedNodes.add(n);

            // Devolver el camino
            if(n.getValue() == dest) {
                Stack<Node> result = new Stack<>();

                Node ptr = n;
                while(ptr != null) {
                    result.insertElementAt(ptr, 0);
                    ptr = ptr.getPrevious();
                }

                System.out.println("Closed nodes: " + closedNodes.toString());
                System.out.println("Opened nodes: " + openedNodes.toString());
                return result;
            }

            SortedSet<Node> successors = getSuccessors(n);

            for(Node s : successors) {
                if(!openedNodes.contains(s) && !closedNodes.contains(s)) {
                    s.setPrevious(n);
                    openedNodes.add(s);
                } else {
                    boolean done = false;
                    for(Node open : openedNodes) {
                        if(open.equals(s) && s.compareTo(open) < 0) {
                            open.setG(s.getG());
                            open.setH(s.getH());
                            open.setPrevious(s.getPrevious());
                            done = true;
                        }
                    }

                    if(!done) {
                        for(Node closed : closedNodes) {
                            if(closed.equals(s) && s.compareTo(closed) < 0) {
                                closed.setG(s.getG());
                                closed.setH(s.getH());
                                closed.setPrevious(s.getPrevious());
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        return "Search" + search.toString();
    }
}
