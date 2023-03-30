package ingenious.practical2.task;

import ingenious.practical2.model.StockDTO;
import ingenious.practical2.repository.StockRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StockJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        getGainerLoser();
    }

    @Value("${websiteurls}")
    String url;

    @Autowired
    private StockRepository stockRepository;

    public void getGainerLoser(){
        StockDTO stocks = new StockDTO();

        try {
            Document document = Jsoup.connect(url).get();
            org.jsoup.select.Elements elementGainer = document.getElementsByClass("col-5 up text-end");
            Elements elementLoser = document.getElementsByClass("col-5 down text-end");

            String gainer = "";
            String loser = "";

            for (Element ads: elementGainer) {
                gainer = ads.getElementsByTag("strong").html();
            }

            for (Element ads: elementLoser) {
                loser = ads.getElementsByTag("strong").html();
            }

            stocks.setNum_gainer(Integer.parseInt(gainer));
            stocks.setNum_loser(Integer.parseInt(loser));

            stockRepository.save(stocks);

            System.out.println("Success");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
