package stocks;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matcher.*;

public class StocksPortfolioTest {

    @Mock
    IStockMarket marketService2 = mock(IStockMarket.class);

    @InjectMocks
    StocksPortfolio portfolio2 = new StocksPortfolio(marketService2);

    @Test
    void getTotalValueWithMocks() {

        // 1.Prepare a mock to substitute the remote service (@Mock annotation)
        IStockMarket marketService = mock(IStockMarket.class);
        
        // 2.Create an instance of the subject under test (SuT) and use the mock to set the (remote) service instance.
        StocksPortfolio portfolio = new StocksPortfolio(marketService);

        // 3.Load the mock with the proper expectations (when...thenReturn)
        when (marketService.getPrice("EDP")).thenReturn(10.0);
        when (marketService.getPrice("StarBucks")).thenReturn(55.0);

        // 4.Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock("EDP", 5));
        portfolio.addStock(new Stock("StarBucks", 15));

        // 5.Verify the result (assert) and the use of the mock (verify)
        double result = (10 * 5) + (55 * 15);

        assertEquals(portfolio.getTotalValue(),result);

        verify(marketService, times(2)).getPrice( anyString()); //Verify the Mock's function was called twice


    }


    //outra forma de fazer: instanciar fora
    @Test
    void getTotalValueWithMocks2() {

        // 1.Prepare a mock to substitute the remote service (@Mock annotation)

        // 2.Create an instance of the subject under test (SuT) and use the mock to set the (remote) service instance.

        // 3.Load the mock with the proper expectations (when...thenReturn)
        when (marketService2.getPrice("EDP")).thenReturn(10.0);
        when (marketService2.getPrice("StarBucks")).thenReturn(55.0);

        // 4.Execute the test (use the service in the SuT)
        portfolio2.addStock(new Stock("EDP", 5));
        portfolio2.addStock(new Stock("StarBucks", 15));

        // 5.Verify the result (assert) and the use of the mock (verify)
        double result = (10 * 5.0) + (55 * 15);

        assertEquals(portfolio2.getTotalValue(),result);

        verify(marketService2, times(2)).getPrice( anyString()); //Verify the Mock's function was called twice

        assertThat(portfolio2.getTotalValue(),is(result));

        // 2x em asserEquals & 2x em assertThat
        verify(marketService2, times(4)).getPrice( anyString()); //Verify the Mock's function was called 4 times
    }


}
