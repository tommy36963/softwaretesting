package twelve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingBasket {

    private List<product> items;

    public ShoppingBasket() {
        items = new ArrayList();
    }

    public double getBalance() {
        double balance = 0.00;
      /**  for(Iterator<product> i = items.iterator(); i.hasNext(); ){
            product item = i.next();
            balance += item.getPrice();
       */

        for(product Product:items){
            balance += Product.getPrice();
        }
        return balance;
    }
    public void addItem(product item) {
        items.add(item);
    }
    public void removeItem(product item)
        throws ProductNotFoundException {
        if(!items.remove(item)) {
            throw new ProductNotFoundException();
        }
    }
    public int getItemCount() {
        return items.size();
    }

    public void empty() {
        items.clear();
    }

}
