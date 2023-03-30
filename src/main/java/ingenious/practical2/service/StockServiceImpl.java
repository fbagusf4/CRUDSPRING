package ingenious.practical2.service;

import ingenious.practical2.model.StockDTO;
import ingenious.practical2.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public StockDTO saveStock(StockDTO stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<StockDTO> fetchStockList() {
        return (List<StockDTO>) stockRepository.findAll();
    }

    @Override
    public StockDTO updateStock(StockDTO stock, Long Id) {
        StockDTO stockDB = stockRepository.findById(Id).get();

        return stockRepository.save(stockDB);
    }

    @Override
    public String deleteStock(Long Id) {
        stockRepository.deleteById(Id);
        return null;
    }
}
