package pc;

public class Challenge2 {
    private int width;
    private int height;
    private String[][] solution;

    public static void main(String[] args) {
        Challenge2 c = new Challenge2(4, 4);
        String[][] matrix = new String[][] { { "*", ".", ".", ".", "." }, { ".", ".", ".", ".", "." },
                { ".", "*", ".", ".", "." }, { "*", ".", ".", ".", "." } };
        String[][] solution = c.solve(matrix);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }
        c = new Challenge2(3, 5);
        matrix = new String[][] { { "*", "*", ".", ".", "." }, { ".", ".", ".", ".", "." },
                { ".", "*", ".", ".", "." } };
        solution = c.solve(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }
    }

    public Challenge2(int width, int height) {
        this.width = width;
        this.height = height;
        this.solution = new String[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                solution[i][j] = "0";
            }
        }
    }

    public String[][] solve(String[][] matrix) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == "*") {
                    solution[i][j] = "*";
                    markSolution(i, j, matrix, solution);
                }
            }
        }
        return solution;
    }

    private void markSolutionBruteForce(int i, int j, String[][] matrix, String[][] solution) {
        if (i > 0) {
            if (j > 0) {
                if (matrix[i - 1][j - 1] != "*")
                    solution[i - 1][j - 1] = Integer.toString(Integer.parseInt(solution[i - 1][j - 1]) + 1);
            }
            if (matrix[i - 1][j] != "*")
                solution[i - 1][j] = Integer.toString(Integer.parseInt(solution[i - 1][j]) + 1);
            if (j < height - 1) {
                if (matrix[i - 1][j + 1] != "*")
                    solution[i - 1][j + 1] = Integer.toString(Integer.parseInt(solution[i - 1][j + 1]) + 1);
            }
        }

        if (j > 0) {
            if (matrix[i][j - 1] != "*")
                solution[i][j - 1] = Integer.toString(Integer.parseInt(solution[i][j - 1]) + 1);
        }
        if (matrix[i][j] != "*")
            solution[i][j] = Integer.toString(Integer.parseInt(solution[i][j]) + 1);
        if (j < height - 1) {
            if (matrix[i][j + 1] != "*")
                solution[i][j + 1] = Integer.toString(Integer.parseInt(solution[i][j + 1]) + 1);
        }

        if (i < width - 1) {
            if (j > 0) {
                if (matrix[i + 1][j - 1] != "*")
                    solution[i + 1][j - 1] = Integer.toString(Integer.parseInt(solution[i + 1][j - 1]) + 1);
            }
            if (matrix[i + 1][j] != "*")
                solution[i + 1][j] = Integer.toString(Integer.parseInt(solution[i + 1][j]) + 1);
            if (j < height - 1) {
                if (matrix[i + 1][j + 1] != "*")
                    solution[i + 1][j + 1] = Integer.toString(Integer.parseInt(solution[i + 1][j + 1]) + 1);
            }
        }
    }

    private void markSolution(int i, int j, String[][] matrix, String[][] solution) {
        incrementField(i - 1, j - 1, matrix, solution);
        incrementField(i - 1, j, matrix, solution);
        incrementField(i - 1, j + 1, matrix, solution);
        incrementField(i, j - 1, matrix, solution);
        incrementField(i, j, matrix, solution);
        incrementField(i, j + 1, matrix, solution);
        incrementField(i + 1, j - 1, matrix, solution);
        incrementField(i + 1, j, matrix, solution);
        incrementField(i + 1, j + 1, matrix, solution);
    }

    private void incrementField(int i, int j, String[][] matrix, String[][] solution) {
        if (i >= 0 && i < width && j >= 0 && j < height && matrix[i][j] != "*")
            solution[i][j] = Integer.toString(Integer.parseInt(solution[i][j]) + 1);
    }
}
