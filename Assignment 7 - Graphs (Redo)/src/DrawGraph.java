import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrawGraph {

    private static class Vertex {
        char name;
        int position;

        Vertex(char name, int position) {

            this.name = name;
            this.position = position;

        }
    }

    private static void printAdjMatrix(int[][] matrix, List<Vertex> vertices) {

        System.out.print("    ");

        for (Vertex vertex : vertices) {

            System.out.print(vertex.name + " ");

        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {

            System.out.print(vertices.get(i).name + " : ");

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();

        }
    }

    private static int[][] createAdjMatrix(List<Vertex> vertices) {

        int n = vertices.size();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {

            int position = vertices.get(i).position;
            int leftIndex = (i - position + n) % n;
            int rightIndex = (i + position) % n;

            matrix[i][leftIndex] = 1;
            matrix[i][rightIndex] = 1;
        }

        return matrix;

    }

    private static List<Vertex> parseInput(String input) {

        List<Vertex> vertices = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\((\\w), (\\d+)\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            char name = matcher.group(1).charAt(0);
            int position = Integer.parseInt(matcher.group(2));
            vertices.add(new Vertex(name, position));

        }

        return vertices;

    }

    public static void main(String[] args) {

        String input = "[(I, 2), (A, 5), (E, 4), (F, 1), (T, 2), (S, 3)]";
        List<Vertex> vertices = parseInput(input);
        int[][] adjMatrix = createAdjMatrix(vertices);
        printAdjMatrix(adjMatrix, vertices);

    }
}




