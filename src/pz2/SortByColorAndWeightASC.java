package pz2;

import java.util.Comparator;

public class SortByColorAndWeightASC implements Comparator <Router> {
    @Override
    public int compare(Router one, Router two){
        if(one.color.equals(two.color))     // if colors equals each others
        {
            return one.weight - two.weight; //then sort by weight ASC
        }
        return one.color.compareTo(two.color);  //sorting routers by color ASC
    }
}