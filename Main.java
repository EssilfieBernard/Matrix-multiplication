import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Getting number of rows and columns for first matrix
        int rows1 = checkDimensionValidity(scanner, "Enter number of rows for first matrix:");
        int columns1 = checkDimensionValidity(scanner, "Enter number of columns for first matrix:");

        int[][] matrix1 = new int[rows1][columns1]; // initializes first matrix

        print(matrixValues(scanner, matrix1, rows1, columns1)); // populating first matrix with user input and printing it

        // Getting number of rows and columns for second matrix
        int rows2 = checkDimensionValidity(scanner, "Enter number of rows for second matrix:");

        // Checks if matrices are compatible for multiplication
        while (columns1 != rows2) {
            System.out.println("Number of columns of first matrix must be equal to number of rows of second matrix.");
            rows2 = getInput(scanner, "Enter number of rows for second matrix:");
        }
        int columns2 = checkDimensionValidity(scanner, "Enter number of columns for second matrix:");


        int[][] matrix2 = new int[rows2][columns2]; // initializes second matrix
        matrixValues(scanner, matrix2, rows2, columns2); // populating second matrix with user inputs

        // Prints first matrix
        System.out.println("Matrix A: " + rows1 + "," + columns1);
        print(matrix1);

        // Prints second matrix
        System.out.println("Matrix B: " + rows2 + "," + columns2);
        print(matrix2);

        // Prints resulting matrix after multiplying first and second matrix
        System.out.println("Matrix C:");
        print(multiply(matrix1, matrix2));
    }

    // Helper function to check if a value is zero or negative
    private static boolean isAPositiveInteger(int value) {
        return value > 0;
    }



    // Helper function to ensure the number of rows and columns are positive.
    private static int checkDimensionValidity(Scanner scanner, String prompt) {
        int value;
        while (true) {
            value = getInput(scanner, prompt);
            if (isAPositiveInteger(value))
                break;
            else
                System.out.println("Value must be positive.");
        }
        return value;
    }

    // Helper function to populate matrix with values a user enters.
    private static int[][] matrixValues(Scanner scanner, int[][] matrix, int rows, int columns) {
        // Iterate through each position in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Keep asking for input until a valid integer is entered
                boolean validInput = false;
                while (!validInput) {
                    // Assign user input to the current matrix position
                    matrix[i][j] = getInput(scanner, "Enter value for position (" + (i + 1) + "," + (j + 1) + "): ");
                    validInput = true;
                }
            }
        }
        return matrix;
    }

    // Function to accept input from user and return it.
    private static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print(prompt);
            scanner.next(); // Discards the invalid input
        }
        return scanner.nextInt();
    }


    // Helper method to print the result in array form
    private static void print(int[][] matrix) {
        for (int[] array : matrix) {
            for (int value : array)
                System.out.print(value + " ");
            System.out.println();
        }
    }

    // Helper function to perform matrix multiplication
    private static int[][] multiply(int[][] firstMatrix, int[][] secondMatrix){
        // Get number of rows and columns for each matrix.
        int numsFirstRows = firstMatrix.length;
        int numsFirstCols = firstMatrix[0].length;
        int numsSecondCols = secondMatrix[0].length;

        // Initializing a new array that will store the result after multiplying the two matrices. Dimension: numFirstRows x numSecondCols
        int[][] result = new int[numsFirstRows][numsSecondCols];

        // Looping over and adding the result of multiplying the two matrices into the result matrix
        // The current values of the result matrix before the loop are zeros
        for (int i = 0; i < numsFirstRows; i++)
            for (int j = 0; j < numsSecondCols; j++)
                for (int k = 0; k < numsFirstCols; k++)
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

        return result;

    }

}
