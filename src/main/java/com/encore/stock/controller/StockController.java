package com.encore.stock.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.encore.stock.data.dto.StockDto;
import com.encore.stock.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StockController {
    
    private final StockService stockService;

    
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/stock/{code}")
    public ResponseEntity<List<StockDto>> show(@PathVariable String code){
        List<StockDto> stockDtos = stockService.getStockByStockCode(code);

        if(stockDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(stockDtos);
        }
        
    }

    @PostMapping(value="/stock")
    public ResponseEntity<List<StockDto>> showPost(@RequestBody StockDto stockDto) {
        List<StockDto> stockDtos = stockService.getStockByStockCode(stockDto.getStockCode());

        if(stockDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stockDtos);
    }
    
}
