package pz4;

import pz2.Protection;
import pz4.DAO.DAOFactory;
import pz4.DAO.IMyDAO;
import pz4.DAO.TypeDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IMyDAO database = DAOFactory.getDAOInstance(TypeDAO.MY_SQL);
        database.OpenTransaction();
        database.IsolationTransaction(Connection.TRANSACTION_SERIALIZABLE);
        database.addRouter(12,2,20,4.7,3,"white",600,
                200, Protection.WPA3,"Intel",3699.99);
        database.showAllRouters();
        System.out.println(database.getAllTypesOfRouters());
        System.out.println(database.getAllBuy());
        database.deleteBuyById(2);
        System.out.println(database.getAllBuy());
        System.out.println(database.getAllCustomers());
        database.changePhoneNumberCustomer("0996660066","Семейкіна");
        System.out.println(database.getAllCustomers());
        database.changePriceRouter(1000,1);
        System.out.println("Get Routers By Price = 1400:");
        database.getRoutersByPrice(1400);
        System.out.println("\nGet Routers By Protection = WPA3:");
        database.getRoutersByProtection(Protection.WPA3);
        System.out.println("\n" + database.getAllRouters());
        database.CloseTransaction();
    }
}
