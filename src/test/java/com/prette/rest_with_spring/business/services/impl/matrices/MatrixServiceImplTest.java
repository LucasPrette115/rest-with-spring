package com.prette.rest_with_spring.business.services.impl.matrices;

import com.prette.rest_with_spring.business.dtos.matrices.MatrixRequestDTO;
import com.prette.rest_with_spring.exceptions.UnprocessableEntityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class MatrixServiceImplTest {

    private MatrixServiceImpl matrixService;

    @BeforeEach
    void setUp() {
        matrixService = new MatrixServiceImpl();
    }

    @Test
    void shouldAddMatricesCorrectly() {
        MatrixRequestDTO mockDto = mock(MatrixRequestDTO.class);
        double[][] matrixA = {{1, 2}, {3, 4}};
        double[][] matrixB = {{5, 6}, {7, 8}};
        double[][] expected = {{6, 8}, {10, 12}};

        when(mockDto.matrixA()).thenReturn(matrixA);
        when(mockDto.matrixB()).thenReturn(matrixB);

        double[][] result = matrixService.addMatrices(mockDto);

        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWhenAddingMatricesOfDifferentSizes() {
        MatrixRequestDTO mockDto = mock(MatrixRequestDTO.class);
        double[][] matrixA = {{1, 2}};
        double[][] matrixB = {{3, 4}, {5, 6}};

        when(mockDto.matrixA()).thenReturn(matrixA);
        when(mockDto.matrixB()).thenReturn(matrixB);

        assertThatThrownBy(() -> matrixService.addMatrices(mockDto))
                .isInstanceOf(UnprocessableEntityException.class)
                .hasMessage("Matrices must have the same size!");
    }

    @Test
    void shouldMultiplyMatricesCorrectly() {
        MatrixRequestDTO mockDto = mock(MatrixRequestDTO.class);
        double[][] matrixA = {{1, 2}, {3, 4}};
        double[][] matrixB = {{2, 0}, {1, 2}};
        double[][] expected = {{4, 4}, {10, 8}};

        when(mockDto.matrixA()).thenReturn(matrixA);
        when(mockDto.matrixB()).thenReturn(matrixB);

        double[][] result = matrixService.multiplyMatrices(mockDto);

        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWhenMultiplyingInvalidMatrices() {
        MatrixRequestDTO mockDto = mock(MatrixRequestDTO.class);
        double[][] matrixA = {{1, 2, 3}};
        double[][] matrixB = {{4, 5}, {6, 7}};

        when(mockDto.matrixA()).thenReturn(matrixA);
        when(mockDto.matrixB()).thenReturn(matrixB);

        assertThatThrownBy(() -> matrixService.multiplyMatrices(mockDto))
                .isInstanceOf(UnprocessableEntityException.class)
                .hasMessage("Number of columns of A must be equal to the number of rows of B");
    }
}
