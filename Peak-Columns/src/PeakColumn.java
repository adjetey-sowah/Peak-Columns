import java.util.Arrays;
import java.util.Scanner;


/**
 * @author Julius Adjetey Sowah
 * PEAK COLUMN
 * This program
 */
public class PeakColumn {
    public static void main(String[] args) throws Exception {


        int[][] matrixA = getUserInput();

        System.out.println("Printing Matrix");
        printMatrix(matrixA);

        System.out.println("Finding Peak Column");
        System.out.println();
        System.out.println("Peak Column: ");
        findPeakColumn(matrixA);




    }


    /**
     * The printMatrix function prints the matrix
     * @param matrix The matrix you want to print
     */
    private static void printMatrix(int[][] matrix){
        for (int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }



    /**
     * The getUserInput function first of all asks the user to enter the size of
     * the matrix they want to create. After taking the size / dimension of the
     * matrix they want to create, the function goes further to ask to enter the
     * elements of the matrix and places it at the right position
     * @return The matrix with values the user entered.
     */
    public static int[][] getUserInput() {

        Scanner scanner = new Scanner(System.in);
        int rows = 0;       // To hold the row size of the matrix
        int cols = 0;       // to hold the column size of the matrix

        // Print heading for input
        System.out.println("Peak Column");
        System.out.println("-----------");

        // Get the matrix dimensions with validation
        while (true) {
            try {
                System.out.print("Enter the number of rows: ");
                rows = Integer.parseInt(scanner.nextLine());        // Take the value for the row size

                System.out.print("Enter the number of columns: ");
                cols = Integer.parseInt(scanner.nextLine());        // Store the value of the column size

                // Make sure the user does not enter a negative value for the rows or columns
                if (rows <= 0 || cols <= 0) {
                    System.out.println("Rows and columns must be positive integers. Please try again.");
                    continue;
                }
                break; // Exit loop if input is valid

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers for rows and columns.");
            }
        }

        // Initialize the matrix with given dimensions
        int[][] matrix = new int[rows][cols];

        // Get matrix elements with validation using getMatrixElement function
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getMatrixElement(i, j);
            }
        }

        System.out.println("Matrix input complete.\n");
        return matrix;
    }

    // Function to get a single matrix element with validation
    public static int getMatrixElement(int row, int col) {
        Scanner scanner = new Scanner(System.in);
        int element = 0;

        while (true) {
            try {
                System.out.print("Enter element at (" + (row + 1) + ", " + (col + 1) + "): ");
                element = Integer.parseInt(scanner.nextLine());
                break; // Move to next element if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        return element;
    }

    /**
     * The {@code MatrixPeakFinder} class provides utility methods for identifying
     * peak columns in a matrix. A peak column element is defined as an element
     * that is the smallest in its column and the largest in its row.
     */
    public static void findPeakColumn(int[][] matrix){


        int rowsInMatrix = matrix.length;
        int colsInMatrix = matrix[0].length;

        for (int currentColumn = 0; currentColumn < colsInMatrix; currentColumn++){
            int minValue = matrix[0][currentColumn];
            int minRow = 0;

            //Correct the minRow
            for (int row = 1; row < rowsInMatrix;row++){
                if(matrix[row][currentColumn] < minValue){
                    minValue = matrix[row][currentColumn];
                    minRow = row;
                }
            }

            boolean isPeak = true;
            for(int col = 0; col < colsInMatrix; col++){
                if (matrix[minRow][col] > minValue){
                    isPeak = false;
                    break;
                }
            }

            if (isPeak){
                int peakRow = minRow+1;
                int peakColumn = currentColumn+1;
                System.out.printf("""
                            (%d,%d) = %d
                        """,peakRow,peakColumn,minValue);
            }

        }


    }
}
