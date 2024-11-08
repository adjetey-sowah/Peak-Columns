import java.util.Arrays;
import java.util.Scanner;


/**
 * @author Julius Adjetey Sowah
/**
 * The {@code PeakColumn} class provides utility methods for identifying
 * peak columns in a matrix. A peak column element is defined as an element
 * that is the smallest in its column and the largest in its row.
 */

public class PeakColumn {
    public static void main(String[] args) throws Exception {


        // Take user input
        int[][] matrixA = getUserInput();

        System.out.println("Printing Matrix");
        printMatrix(matrixA);

        System.out.println("Finding Peak Column");
        System.out.println();
        System.out.println("Peak Column: ");

        // Perform the peak function
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
     * the findPeakColumn takes the matrix as an argument and then finds the peak column in the
     * matrix.
     * @param matrix The matrix you want to find the peak column in.
     */
    public static void findPeakColumn(int[][] matrix){

        // Initialize the minimum value and its row index for the current column

        int rowsInMatrix = matrix.length;       // To hold the number rows in the matrix
        int colsInMatrix = matrix[0].length;    // to hold the number of columns in the matrix

        // Find the minimum value and its row index in the current column
        for (int currentColumn = 0; currentColumn < colsInMatrix; currentColumn++){
            int minValue = matrix[0][currentColumn];
            int minInColumnIndex = 0;

            //Find the minimum number in the column and it's position
            for (int row = 1; row < rowsInMatrix;row++){
                if(matrix[row][currentColumn] < minValue){
                    minValue = matrix[row][currentColumn];
                    minInColumnIndex = row;
                }
            }

            // Assume the element is a peak column until proven otherwise
            boolean isPeak = true;

            // Check if the found minimum value is the maximum in its row
            for(int col = 0; col < colsInMatrix; col++){
                if (matrix[minInColumnIndex][col] > minValue){
                    isPeak = false;     // Not a peak if any element in the row is greater
                    break;      // Exit the loop early since it's not a peak
                }
            }

            // If the value is on peak column, print the value.
            if (isPeak){
                int peakRow = minInColumnIndex+1;
                int peakColumn = currentColumn+1;
                System.out.printf("""
                            (%d,%d) = %d
                        """,peakRow,peakColumn,minValue);
            }

        }


    }

}
