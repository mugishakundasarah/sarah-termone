package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1")
public class MathController {
    @Autowired
    private MathOperatorImpl calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<?> doMath(@RequestBody DoMathRequest doMathRequest) throws InvalidOperationException {
        double result = calculatorService.doMath(doMathRequest.getOperand1(), doMathRequest.getOperand2(), doMathRequest.getOperation());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse(true,"Done", result));
    }
}
