import java.util.*;

public class EveryPath {

    static int[][] graph;

    private static void Paths(int current, int target, int length, List<Integer> path) {

        path.add(current);

        if(current == target && path.size() == length) {

            System.out.println(path);

        }
        else if (path.size() < length) {

            for(int next = 0; next < graph[current].length; next++) {

                if(graph[current][next] != 0) {

                    Paths(next, target, length, new ArrayList<>(path));

                }
            }
        }
    }

    public static void main(String[] args) {

        int u = 0;
        int w = 4;
        int length = 5;

        graph = new int[][] {

                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,1},
                {1,0,0,0,0}

        };

        Paths(u,w,length, new ArrayList<>());

    }
}
