package com.prette.rest_with_spring.controller.matrices;

import com.prette.rest_with_spring.business.dtos.matrices.MatrixDeterminantRequestDTO;
import com.prette.rest_with_spring.business.dtos.matrices.MatrixResponseDTO;
import com.prette.rest_with_spring.business.services.interfaces.matrices.MatrixService;
import com.prette.rest_with_spring.business.dtos.matrices.MatrixRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/matrix")
public class MatrixController {

    private final MatrixService matrixService;
    //private Logger logger = LoggerFactory.getLogger(MatrixController.class.getName());

    @Autowired
    public MatrixController(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    @PostMapping("/add")
    @Operation(description = "Endpoint responsible for adding 2 matrices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Client error"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<MatrixResponseDTO> addMatrices(@RequestBody MatrixRequestDTO request) {
        MatrixResponseDTO result = matrixService.addMatrices(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/multiply")
    @Operation(description = "Endpoint responsible for multiplying 2 matrices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Client error"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<MatrixResponseDTO> multiplyMatrices(@RequestBody MatrixRequestDTO request) {

        MatrixResponseDTO result =  matrixService.multiplyMatrices(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/determinant")
    @Operation(description = "Endpoint responsible for calculating the determinant of a given matrix")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Client error"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Double> calculateDeterminant(@RequestBody MatrixDeterminantRequestDTO request) {

        double result =  matrixService.calculateDeterminant(request);
        return ResponseEntity.ok(result);
    }

}
