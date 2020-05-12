import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class MapGenerator {
    private final int EMPTY = -1;
    private final String SPACING = "  ";

    private final int size;
    private final int maxH;

    private int[][] map;
    private int[] hValues;
    private int src, dest;

    private long seed = 25;
    private Random rand;

    public MapGenerator(int size, int maxH) {
        this.size = size;
        this.maxH = maxH;

        rand = new Random(seed);

        // src
        src = rand.nextInt(size);

        // dest
        do { dest = rand.nextInt(size); } while(dest == src);

        // hValues
        hValues = new int[size];
        for(int i = 0; i < size; i++) hValues[i] = rand.nextInt(maxH) + 1;
        hValues[dest] = 0;

        // map
        map = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++) {
                if(rand.nextInt() % 3 == 0) {
                    map[i][j] = rand.nextInt(maxH) + 1;
                    map[j][i] =  map[i][j];
                } else {
                    map[i][j] = EMPTY;
                    map[j][i] = EMPTY;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            map[i][i] = EMPTY;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n", "", "");


        sj.add("src=" + src);
        sj.add("dest=" + dest);

        sj.add("size=" + size);

        sj.add("map (g values)=");
        String mapStr = "";
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == EMPTY) {
                    mapStr += "[]";
                } else mapStr += map[i][j] / 10 == 0 ? " " + map[i][j] : map[i][j];

                if(j != size - 1) mapStr += SPACING;
            }
            mapStr += "\n\n";
        }
        sj.add(mapStr);

        String hValuesStr = "hValues[";
        for(int i = 0; i < size; i++) {
            hValuesStr += hValues[i];
            hValuesStr += i < size - 1 ? ", " : "";
        }
        hValuesStr += "]";
        sj.add(hValuesStr);


        return sj.toString();
    }

    // Getters

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int[] gethValues() {
        return hValues;
    }

    public void sethValues(int[] hValues) {
        this.hValues = hValues;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
}
