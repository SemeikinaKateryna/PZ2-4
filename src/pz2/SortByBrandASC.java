package pz2;

import java.util.Comparator;

public class SortByBrandASC implements Comparator<Router> {
    @Override
    public int compare(Router one, Router two){
        return one.brand.compareTo(two.brand);
    }
}
