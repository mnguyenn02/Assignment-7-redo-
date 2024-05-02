import java.util.*;
public class DirectedOrIndirected {

    private static boolean isDirected(int[][] matrix) {

        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != matrix[j][i]) {

                    return true;

                }
            }
        }

        return false;

    }

    public static void main(String[] args) {

        int[][] matrix = {
/**
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}

        };
 **/
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };


        if(isDirected(matrix)) {

            System.out.println("It is a directed graph");

        }
        else {

            System.out.println("It is an undirected graph");

        }
    }
}
