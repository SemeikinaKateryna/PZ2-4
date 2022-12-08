package pz2;

import java.util.Comparator;

public class SortByWifiFrequency implements Comparator<Router> {
    @Override
    public int compare(Router one, Router two){

        if(one instanceof AdslRouter && two instanceof AdslRouter) {
            return Double.compare(one.wifiFrequency, two.wifiFrequency);
        }
        else{
            return Double.compare(two.wifiFrequency, one.wifiFrequency);
        }

    }
}
