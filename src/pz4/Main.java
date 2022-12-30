package pz4;

import pz2.Protection;
import pz4.DAO.DAOFactory;
import pz4.DAO.IMyDAO;
import pz4.DAO.TypeDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IMyDAO database = DAOFactory.getDAOInstance(TypeDAO.MY_SQL);
        database.OpenTransaction();
        database.IsolationTransaction(Connection.TRANSACTION_SERIALIZABLE);
        System.out.println("Додавання 12го роутера:");
        database.addRouter(12,2,20,4.7,3,"white",600,
                200, Protection.WPA3,"Intel",3699.99);
        database.showAllRouters();
        System.out.println("Усі типи роутерів:");
        System.out.println(database.getAllTypesOfRouters());
        System.out.println("Усі покупки: ");
        System.out.println(database.getAllBuy());
        System.out.println("Видалення 2ї покупки:");
        database.deleteBuyById(2);
        System.out.println(database.getAllBuy());
        System.out.println("Усі покупці:");
        System.out.println(database.getAllCustomers());
        System.out.println("Зміна номеру телефона за прізвищем Семейкіна:");
        database.changePhoneNumberCustomer("0996864430","Семейкіна");
        System.out.println(database.getAllCustomers());
        System.out.println("Зміна дати покупки за ID 1:");
        database.changeDateOfBuy(new Date(2022,4,12),1);
        System.out.println(database.getAllBuy());
        System.out.println("Зміна ціни роутера за ID 8:");
        database.changePriceRouter(1900,8);
        System.out.println(database.getAllRouters());
        System.out.println("Усі роутери по ціні 1400:");
        database.getRoutersByPrice(1400);
        System.out.println("Усі роутери з захистом WPA3:");
        database.getRoutersByProtection(Protection.WPA3);
        database.CloseTransaction();
    }
}
