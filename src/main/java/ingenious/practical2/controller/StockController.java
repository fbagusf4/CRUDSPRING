package ingenious.practical2.controller;

import ingenious.practical2.model.StockDTO;
import ingenious.practical2.repository.StockRepository;
import ingenious.practical2.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/stock")
    public StockDTO saveStock(@RequestBody StockDTO stockDTO){
        return stockService.saveStock(stockDTO);
    }

    @GetMapping("/stock")
    public List<StockDTO> fetchStockList(){
        return stockService.fetchStockList();
    }
}
