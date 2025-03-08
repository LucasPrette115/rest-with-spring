package com.prette.rest_with_spring.business.services.interfaces.matrices;

import com.prette.rest_with_spring.business.dtos.matrices.MatrixRequestDTO;

public interface MatrixService {
    double[][] addMatrices(MatrixRequestDTO dto);
    double[][] multiplyMatrices(MatrixRequestDTO dto);
}
