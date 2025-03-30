package com.prette.rest_with_spring.business.utils;

import com.prette.rest_with_spring.exceptions.UnprocessableEntityException;

public class MatrixUtil {

    public static double determinant(double[][] matrix) {
        int n = matrix.length;

        for (double[] row : matrix) {
            if (row.length != n) {
                throw new UnprocessableEntityException("The matrix must be square.");
            }
        }

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0.0;

        for (int col = 0; col < n; col++) {

            double[][] subMatrix = new double[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int subCol = 0;
                for (int j = 0; j < n; j++) {
                    if (j == col) {
                        continue;
                    }
                    subMatrix[i - 1][subCol] = matrix[i][j];
                    subCol++;
                }
            }
            det += Math.pow(-1, col) * matrix[0][col] * determinant(subMatrix);
        }

        return det;
    }

    public static double[][] add(double[][] matrixA, double[][] matrixB){

        if((matrixA.length != matrixB.length) || (matrixA[0].length != matrixB[0].length)){
            throw new UnprocessableEntityException("Matrices must have the same size!");
        }

        int rows = matrixA.length;
        int cols = matrixA.length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }

        }

        return result;
    }

    public static double[][] multiply(double[][] matrixA, double[][] matrixB){

        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;


        if(colsA != rowsB){
            throw new UnprocessableEntityException("Number of columns of A must be equal to the number of rows of B");
        }

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }

            }
        }
        return result;
    }
}
