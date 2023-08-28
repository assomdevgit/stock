package com.encore.stock.service;

import java.util.List;

import com.encore.stock.data.dto.StockDto;

public interface StockService {
    List<StockDto> getStockByStockCode(String stockCode);
    
}
