package pz2;

import java.util.Comparator;

public class SortByNumberOfAntennasASC implements Comparator<Router> {
    @Override
    public int compare(Router one, Router two){
        return one.numberOfAntennas - two.numberOfAntennas;
    }
}
