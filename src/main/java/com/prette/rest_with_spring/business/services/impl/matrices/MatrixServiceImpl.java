package com.prette.rest_with_spring.business.services.impl.matrices;

import com.prette.rest_with_spring.business.dtos.matrices.MatrixDeterminantRequestDTO;
import com.prette.rest_with_spring.business.dtos.matrices.MatrixResponseDTO;
import com.prette.rest_with_spring.business.services.interfaces.matrices.MatrixService;
import com.prette.rest_with_spring.business.dtos.matrices.MatrixRequestDTO;
import com.prette.rest_with_spring.business.utils.MatrixUtil;
import org.springframework.stereotype.Service;

@Service
public class MatrixServiceImpl implements MatrixService {

    @Override
    public MatrixResponseDTO addMatrices(MatrixRequestDTO dto){
        return new MatrixResponseDTO(MatrixUtil.add(dto.matrixA(), dto.matrixB()));
    }

    @Override
    public MatrixResponseDTO multiplyMatrices(MatrixRequestDTO dto) {
        return new MatrixResponseDTO(MatrixUtil.multiply(dto.matrixA(), dto.matrixB()));
    }

    @Override
    public double calculateDeterminant(MatrixDeterminantRequestDTO dto) {
        return MatrixUtil.determinant(dto.matrix());
    }
}
