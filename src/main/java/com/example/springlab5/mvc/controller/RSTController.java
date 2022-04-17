package com.example.springlab5.mvc.controller;

import com.example.springlab5.mvc.model.RateForRequest;
import com.example.springlab5.mvc.service.MainService;
import com.example.springlab5.utils.UpdateRateContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("api/rate-management")
@RestController
public class RSTController {
    private final MainService mainService;

    public RSTController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(value = "/currency",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addRate(@RequestBody RateForRequest rate) {
            return ResponseEntity.status(HttpStatus.OK).body(mainService.createRate(rate));
    }

    @PostMapping("/currencies")
    public ResponseEntity<Object> addRates(@RequestBody RateForRequest... rates){
        mainService.createRates(rates);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/currencies",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllRates() {
        return ResponseEntity.status(HttpStatus.OK).body(mainService.getAllRates());
    }

    @PutMapping("/currency")
    public ResponseEntity<Object> editCurrency(@RequestBody UpdateRateContainer container) {
        mainService.updateRate(container.getToUpdate(), container.getUpdated());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/currency")
    public ResponseEntity<?> deleteRate(@RequestBody RateForRequest rate) {
            if(mainService.deleteRate(rate)) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

    }

    @DeleteMapping("/currencies")
    public ResponseEntity<Object> deleteRates(@RequestBody RateForRequest... rates){
        mainService.deleteRates(rates);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
