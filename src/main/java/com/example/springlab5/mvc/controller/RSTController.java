package com.example.springlab5.mvc.controller;

import com.example.springlab5.mvc.DAO.RateDAO;
import com.example.springlab5.mvc.model.RateForRequest;
import com.example.springlab5.mvc.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("api/currencies")
@RestController
public class RSTController {
    private final MainService mainService;

    public RSTController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addRateByDate(@RequestBody RateForRequest rate) {
            return ResponseEntity.status(HttpStatus.OK).body(mainService.createRate(rate));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllRates() {
        return ResponseEntity.status(HttpStatus.OK).body(mainService.getAllRates());
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteRate(@RequestBody RateForRequest rate) {
            if(mainService.deleteRate(rate)) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

    }
}
