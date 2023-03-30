package ingenious.practical2.repository;

import ingenious.practical2.model.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StockRepository extends JpaRepository<StockDTO, Long> {
}
