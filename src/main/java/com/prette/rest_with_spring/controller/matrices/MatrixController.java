package com.prette.rest_with_spring.controller.matrices;

import com.prette.rest_with_spring.business.services.interfaces.matrices.MatrixService;
import com.prette.rest_with_spring.controller.dtos.matrices.MatrixRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matrix")
public class MatrixController {

    private final MatrixService matrixService;

    @Autowired
    public MatrixController(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    @PostMapping("/add")
    public double[][] addMatrices(MatrixRequestDTO request){
        return matrixService.addMatrices(request);
    }

    @PostMapping("/multiply")
    public double[][] multiplyMatrices(@RequestBody MatrixRequestDTO request) {
        return matrixService.multiplyMatrices(request);
    }

}
