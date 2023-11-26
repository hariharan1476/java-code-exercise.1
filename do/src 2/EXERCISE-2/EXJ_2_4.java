
public class EXJ_2_4 {
    public static void main(String[] args) {
        int[][] originalMatrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};

        int[][] transposeMatrix = new int[3][3];


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposeMatrix[j][i] = originalMatrix[i][j];
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
