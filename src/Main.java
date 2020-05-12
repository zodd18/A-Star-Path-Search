public class Main {
    public static void main(String[] args) {
        MapGenerator mg = new MapGenerator(9, 30);

        int[][] map = {
                {-1, -1, -1, 8, 3, -1, -1, 10, -1},
                {-1, -1, -1, -1, 22, -1, -1, 25, -1},
                {-1, -1, -1, 22, -1, 29, -1, -1, 13},
                {8, -1, 22, -1, -1, 12, -1, -1, -1},
                {3, 22, -1, -1, -1, -1, 13, -1, -1},
                {-1, -1, 29, 12, -1, -1, 16, -1, -1},
                {-1, -1, -1, -1, 13, 16, -1, -1, 7},
                {10, 25, -1, -1, -1, -1, -1, -1, 16},
                {-1, -1, 13, -1, -1, -1, 7, 16, -1}
        };

        int[] hValues = {11, 15, 0, 15, 9, 23, 13, 18, 8};

        int src = 0;
        int dest = 2;

        System.out.println(mg);

        mg.setMap(map);
        mg.sethValues(hValues);
        mg.setSrc(src);
        mg.setDest(dest);

        System.out.println();
        SearchAStar search = new SearchAStar(mg);
        System.out.println(search);
    }
}
