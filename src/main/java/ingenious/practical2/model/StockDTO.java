package ingenious.practical2.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Component
@Entity
@Table(name = "tbl_stock")
@Data
public class StockDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp record_datetime;

    private Integer num_gainer;

    private Integer num_loser;

}
