package pz4;
import java.util.Date;
public class Buy {
    int buyID;
    Date dateOfBuy;
    int customerID;
    double fullPrice;
    String currency;
    int RouterID;

    public Buy(int buyID, Date dateOfBuy, int customerID, double fullPrice, String currency, int routerID) {
        this.buyID = buyID;
        this.dateOfBuy = dateOfBuy;
        this.customerID = customerID;
        this.fullPrice = fullPrice;
        this.currency = currency;
        RouterID = routerID;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "buyID=" + buyID +
                ", dateOfBuy=" + dateOfBuy +
                ", customerID=" + customerID +
                ", fullPrice=" + fullPrice +
                ", currency='" + currency + '\'' +
                ", RouterID=" + RouterID +
                '}';
    }
}
