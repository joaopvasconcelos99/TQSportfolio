package stocks;

import java.util.ArrayList;

public class StocksPortfolio {

    private String name;
    private IStockMarket marketService;
    private ArrayList<Stock> stocks;

    public StocksPortfolio(IStockMarket marketService) {
        this.marketService = marketService;
        stocks = new ArrayList<>();
    }

    public IStockMarket getMarketService() {
        return this.marketService;
    }

    public void setMarketService(IStockMarket marketService){
        this.marketService = marketService;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue(){
        double total = 0;

        for (Stock stock : this.stocks) {
            total += stock.getQuantity() * (marketService.getPrice(stock.getName()));
        }

        return total;
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }
}
