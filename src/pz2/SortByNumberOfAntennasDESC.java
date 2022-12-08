package pz2;

import java.util.Comparator;

public class SortByNumberOfAntennasDESC implements Comparator<Router> {
    @Override
    public int compare(Router one, Router two){
        return two.numberOfAntennas - one.numberOfAntennas;
    }
}
