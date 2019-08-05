package twelve;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;
    private product Product;

    @Before
    public void setUp() throws Exception {
        shoppingBasket = new ShoppingBasket();
        Product = new product("Jacket",10.0,"0001XYQ200103");
        shoppingBasket.addItem(Product);
    }

    @Test
    public void testWhenEmptyShoppingBasketThenNoItem() {
        shoppingBasket.empty();
        assertEquals(0,shoppingBasket.getItemCount());
    }
    @Test
    public void testWhenAddItemThenRightBalance() {
        product tshirt = new product("Tshirt", 29.95,"0004QPD300102");
        shoppingBasket.addItem(tshirt);

        assertEquals(2,shoppingBasket.getItemCount());

        double expectedBalance = Product.getPrice() + tshirt.getPrice();
        assertEquals(expectedBalance,shoppingBasket.getBalance(),0.0);
    }

    @Test
    public void testWhenRemoveItemThenNoItem() {
        shoppingBasket.removeItem(Product);
        assertEquals(0,shoppingBasket.getItemCount());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testWhenRemoveItemNotInCartThenThrow() {
        product skirt = new product("Skirt", 39.95,"0006YUH00332");
        shoppingBasket.removeItem(skirt);
    }



}