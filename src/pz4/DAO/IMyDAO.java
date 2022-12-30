package pz4.DAO;

import pz2.Protection;
import pz3.MyList;

import java.sql.SQLException;
import java.util.Date;

public interface IMyDAO {
    public final static String NAME_OF_TABLE_ROUTERS = "router";
    public final static String NAME_OF_TABLE_TYPE_OF_ROUTERS = "typeOfRouter";
    public final static String NAME_OF_TABLE_CUSTOMERS = "customer";
    public final static String NAME_OF_TABLE_BUY = "buy";

    // Уровни изоляции транзакций
    void OpenTransaction() throws SQLException;
    void CloseTransaction() throws SQLException;
    void IsolationTransaction(int NameOfIsolation) throws SQLException;

    // Просмотр информации из всех таблиц
    MyList getAllRouters() throws SQLException;
    MyList getAllCustomers() throws SQLException;
    MyList getAllBuy() throws SQLException;
    MyList getAllTypesOfRouters() throws SQLException;

    // Виведення всіх роутерів разом з розшифровкою типу
    public void showAllRouters() throws SQLException;

    // Поиск роутеров по каждой из своих характеристик
    void getRoutersById(int id) throws SQLException;
    void getRoutersByType(int type) throws SQLException;
    void getRoutersByMaxSpeed(int maxSpeed) throws SQLException;
    void getRoutersByWifiFrequency(double wifiFrequency) throws SQLException;
    void getRoutersByNumberOfAntennas(int numberOfAntennas) throws SQLException;
    void getRoutersByColor(String color) throws SQLException;
    void getRoutersByWeight(int weight) throws SQLException;
    void getRoutersByPower(int power) throws SQLException;
    void getRoutersByProtection(Protection protection) throws SQLException;
    void getRoutersByBrand(String brand) throws SQLException;
    void getRoutersByPrice(double price) throws SQLException;

    // Добавление нового роутера, его типа, покупателя, покупки
    void addRouter (int RouterID, int type, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color,
                    int weight, int power, Protection protection, String brand, double price)
            throws SQLException;
    void addCustomer(int customerID, String surname, String name, String patronymic, String phoneNumber,
                     String deliveryAdress, String email) throws SQLException;
    void addBuy (int buyID, Date dateOfBuy, int customerID, int fullPrice, String currency, int RouterID)
            throws SQLException;
    void addTypeOfRouter(int typeOfRouterID, String description) throws SQLException;

    // Изменение стоимости роутера по заданному ID
    void changePriceRouter(int newPrice, int RouterID) throws SQLException;
    // Изменение номера телефона покупателя по фамилии
    void changePhoneNumberCustomer( String newPhoneNumber, String surname) throws SQLException;
    void changeDateOfBuy(Date newDateOfBuy,int buyID) throws SQLException;


        // Удаление роутера/покупателя/покупки по заданному ID
    void deleteRouterById(int RouterID) throws SQLException;
    void deleteCustomerById(int customerID) throws SQLException;
    void deleteBuyById(int buyID) throws SQLException;
    void deleteTypeOfRouterById(int typeOfRouterID) throws SQLException;
}

