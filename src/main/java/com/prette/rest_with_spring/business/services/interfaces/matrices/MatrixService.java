package com.prette.rest_with_spring.business.services.interfaces.matrices;

import com.prette.rest_with_spring.business.dtos.matrices.MatrixDeterminantRequestDTO;
import com.prette.rest_with_spring.business.dtos.matrices.MatrixRequestDTO;
import com.prette.rest_with_spring.business.dtos.matrices.MatrixResponseDTO;

public interface MatrixService {
    MatrixResponseDTO addMatrices(MatrixRequestDTO dto);
    MatrixResponseDTO multiplyMatrices(MatrixRequestDTO dto);
    double calculateDeterminant(MatrixDeterminantRequestDTO dto);
}
