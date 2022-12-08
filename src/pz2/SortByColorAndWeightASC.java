package pz2;

import java.util.Comparator;

public class SortByColorAndWeightASC implements Comparator <Router> {
    @Override
    public int compare(Router one, Router two){
        if(one.color.equals(two.color))
        {
            return one.weight - two.weight;
        }
        return one.color.compareTo(two.color);
    }
}