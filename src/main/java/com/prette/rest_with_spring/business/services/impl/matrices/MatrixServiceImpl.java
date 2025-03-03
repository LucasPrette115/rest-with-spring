package com.prette.rest_with_spring.business.services.impl.matrices;

import com.prette.rest_with_spring.business.services.interfaces.matrices.MatrixService;
import com.prette.rest_with_spring.controller.dtos.matrices.MatrixRequestDTO;
import com.prette.rest_with_spring.exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Service;

@Service
public class MatrixServiceImpl implements MatrixService {

    @Override
    public double[][] addMatrices(MatrixRequestDTO dto){
        double[][] matrixA = dto.matrixA();
        double[][] matrixB = dto.matrixB();

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

    @Override
    public double[][] multiplyMatrices(MatrixRequestDTO dto) {
        double[][] matrixA = dto.matrixA();
        double[][] matrixB = dto.matrixB();

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
