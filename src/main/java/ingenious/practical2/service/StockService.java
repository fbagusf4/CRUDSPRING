package ingenious.practical2.service;

import ingenious.practical2.model.StockDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface StockService {

    StockDTO saveStock(StockDTO stock);

    List<StockDTO> fetchStockList();

    StockDTO updateStock(StockDTO stock, Long Id);

    String deleteStock(Long Id);
}
