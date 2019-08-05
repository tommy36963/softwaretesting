package fourteen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioTest {

    Portfolio portfolio;
    StockService stockService;

    @Before
    public void setUp() throws Exception {
        portfolio = new Portfolio();
        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    @Test
    public void testPriceWhenQuantity10ThenReturn50(){
        Stock googleStock = new Stock ("1","Google",10);
        portfolio.addStock(googleStock);
        when(stockService.getPrice(googleStock)).thenReturn(1000.00);
        double actual = portfolio.getMarketValue();
        verify(stockService).getPrice(googleStock);
        assertEquals(10000.00,actual,0);
    }

    @Test
    public void testGetPriceWhenQuantity100ThenReturn1000() {
        Stock microsoft = new Stock ("2","Microsoft", 10);
        when(stockService.getPrice(microsoft)).thenReturn(1000.00);
    }

}