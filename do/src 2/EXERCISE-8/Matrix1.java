import java.util.Scanner;

class Matrix {
    private int[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        int[][] resultData = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultData[i][j] = matrix1.getData()[i][j] + matrix2.getData()[i][j];
            }
        }

        Matrix resultMatrix = new Matrix(rows, columns);
        resultMatrix.setData(resultData);
        return resultMatrix;
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        int[][] resultData = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultData[i][j] = matrix1.getData()[i][j] - matrix2.getData()[i][j];
            }
        }

        Matrix resultMatrix = new Matrix(rows, columns);
        resultMatrix.setData(resultData);
        return resultMatrix;
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        int rows = matrix1.getRows();
        int columns = matrix2.getColumns();
        int[][] resultData = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < matrix1.getColumns(); k++) {
                    resultData[i][j] += matrix1.getData()[i][k] * matrix2.getData()[k][j];
                }
            }
        }

        Matrix resultMatrix = new Matrix(rows, columns);
        resultMatrix.setData(resultData);
        return resultMatrix;
    }
}

class MatrixAdditionThread extends Thread {
    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix resultMatrix;

    public MatrixAdditionThread(Matrix matrix1, Matrix matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.resultMatrix = new Matrix(matrix1.getRows(), matrix1.getColumns());
    }

    public Matrix getResultMatrix() {
        return resultMatrix;
    }

    @Override
    public void run() {
        resultMatrix = Matrix.add(matrix1, matrix2);
    }
}

class MatrixSubtractionThread extends Thread {
    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix resultMatrix;

    public MatrixSubtractionThread(Matrix matrix1, Matrix matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.resultMatrix = new Matrix(matrix1.getRows(), matrix1.getColumns());
    }

    public Matrix getResultMatrix() {
        return resultMatrix;
    }

    @Override
    public void run() {
        resultMatrix = Matrix.subtract(matrix1, matrix2);
    }
}

class MatrixMultiplicationThread extends Thread {
    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix resultMatrix;

    public MatrixMultiplicationThread(Matrix matrix1, Matrix matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.resultMatrix = new Matrix(matrix1.getRows(), matrix2.getColumns());
    }

    public Matrix getResultMatrix() {
        return resultMatrix;
    }

    @Override
    public void run() {
        resultMatrix = Matrix.multiply(matrix1, matrix2);
    }
}

public class Matrix1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the matrices: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns for the matrices: ");
        int columns = scanner.nextInt();

        Matrix matrix1 = new Matrix(rows, columns);
        Matrix matrix2 = new Matrix(rows, columns);

        System.out.println("Enter the elements of matrix 1:");
        readMatrixElements(matrix1, scanner);

        System.out.println("Enter the elements ofmatrix 2:");
        readMatrixElements(matrix2, scanner);

        MatrixAdditionThread additionThread = new MatrixAdditionThread(matrix1, matrix2);
        MatrixSubtractionThread subtractionThread = new MatrixSubtractionThread(matrix1, matrix2);
        MatrixMultiplicationThread multiplicationThread = new MatrixMultiplicationThread(matrix1, matrix2);

        additionThread.start();
        subtractionThread.start();
        multiplicationThread.start();

        try {
            additionThread.join();
            subtractionThread.join();
            multiplicationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Matrix additionResult = additionThread.getResultMatrix();
        Matrix subtractionResult = subtractionThread.getResultMatrix();
        Matrix multiplicationResult = multiplicationThread.getResultMatrix();

        System.out.println("Matrix Addition:");
        displayMatrix(additionResult);

        System.out.println("Matrix Subtraction:");
        displayMatrix(subtractionResult);

        System.out.println("Matrix Multiplication:");
        displayMatrix(multiplicationResult);
    }

    private static void readMatrixElements(Matrix matrix, Scanner scanner) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();
        int[][] data = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                data[i][j] = scanner.nextInt();
            }
        }

        matrix.setData(data);
    }

    private static void displayMatrix(Matrix matrix) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();
        int[][] data = matrix.getData();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}