package pz2;

import java.util.Comparator;

public class SortByPriceASC implements Comparator<Router> {
    @Override
    public int compare(Router one, Router two){
        return Double.compare(one.price,two.price);
    }
}
