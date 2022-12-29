package pz4.DAO;

import pz2.Protection;
import pz2.Router;
import pz3.MyList;
import pz4.Buy;
import pz4.Customer;
import pz4.TypesOfRouters;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Date;

public class MySQLDAO implements IMyDAO {
    //посилання на БД, що знаходиться на локальному сервері, логін та пароль від MySQL WorkBench
    private static final String URL = "jdbc:mysql://localhost/ROUTERS?";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Katya";
    private static Connection conn = null;

    //конструктор MySQLDAO, що створює зв'язок з БД
    public MySQLDAO() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException |
                 NoSuchMethodException | InvocationTargetException ex) {
            // Перехоплення усіх помилок
            System.out.println("SQLException: " + ex);
            System.out.println("SQLState: " + ex);
            System.out.println("VendorError: " + ex);
        }
    }
    //усі необхідні для програми SQL-запити

    //щоб отримати всі об'єкти
    public static String GET_ALL_ROUTERS = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS;
    public static String SHOW_ALL_ROUTERS= "SELECT * FROM " + NAME_OF_TABLE_TYPE_OF_ROUTERS +
    " INNER JOIN " + NAME_OF_TABLE_ROUTERS +  " USING(typeOfRouterID)";
    public static String GET_ALL_CUSTOMERS = "SELECT * FROM " + NAME_OF_TABLE_CUSTOMERS;
    public static String GET_ALL_BUY = "SELECT * FROM " + NAME_OF_TABLE_BUY;
    public static String GET_ALL_TYPES_OF_ROUTERS = "SELECT * FROM " + NAME_OF_TABLE_TYPE_OF_ROUTERS;


    // Для отримання всіх об'єктів, що задовільняють параметрам
    public static String SELECT_ROUTERS_BY_ID = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE RouterID = ?";
    public static String SELECT_ROUTERS_BY_MAX_SPEED = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE maxSpeed = ?";
    public static String SELECT_ROUTERS_BY_WIFI_FREQUENCY = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE wifiFrequency = ?";
    public static String SELECT_ROUTERS_BY_NUMBER_OF_ANTENNAS = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE numberOfAntennas = ?";
    public static String SELECT_ROUTERS_BY_COLOR = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE color = ?";
    public static String SELECT_ROUTERS_BY_WEIGHT = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE weight = ?";
    public static String SELECT_ROUTERS_BY_POWER = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE power = ?";
    public static String SELECT_ROUTERS_BY_PROTECTION = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE protection = ?";
    public static String SELECT_ROUTERS_BY_BRAND = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE brand = ?";
    public static String SELECT_ROUTERS_BY_PRICE = "SELECT * FROM " + NAME_OF_TABLE_ROUTERS + " WHERE price = ?";

    // Для додавання об'єкту
    public static String INSERT_DATA_INTO_ROUTER = "INSERT INTO " + NAME_OF_TABLE_ROUTERS +
            " (RouterID, typeOfRouterID, maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static String INSERT_DATA_INTO_CUSTOMER = "INSERT INTO " + NAME_OF_TABLE_CUSTOMERS +
            " (customerID, surname, name, patronymic, phoneNumber, deliveryAdress, email) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static String INSERT_DATA_INTO_BUY = "INSERT INTO " + NAME_OF_TABLE_BUY +
            " (buyID, dateOfBuy, customerID, fullPrice, currency, RouterID) VALUES (?, ?, ?, ?, ?, ?)";

    public static String INSERT_DATA_INTO_TYPES_OF_ROUTER = "INSERT INTO " + NAME_OF_TABLE_TYPE_OF_ROUTERS +
            " (typeOfRouterID, description) VALUES (?, ?)";

    // Для видалення об'єкту
    public static String DELETE_DATA_FROM_ROUTER_BY_ID = "DELETE FROM " + NAME_OF_TABLE_ROUTERS +
            " WHERE RouterID = ?";
    public static String DELETE_DATA_FROM_CUSTOMER_BY_ID = "DELETE FROM " + NAME_OF_TABLE_CUSTOMERS +
            " WHERE customerID = ?";
    public static String DELETE_DATA_FROM_BUY_BY_ID = "DELETE FROM " + NAME_OF_TABLE_BUY
            + " WHERE buyID = ?";
    public static String DELETE_DATA_FROM_TYPE_OF_ROUTER_BY_ID = "DELETE FROM " + NAME_OF_TABLE_TYPE_OF_ROUTERS
            + " WHERE typeOfRouterID = ?";

    // Оновлення даних по ID об'єкта
    public static String UPDATE_PRICE_ROUTER = "UPDATE " + NAME_OF_TABLE_ROUTERS +
            " SET price = ? WHERE RouterID LIKE ?";
    public static String UPDATE_PHONE_NUMBER_CUSTOMER = "UPDATE " + NAME_OF_TABLE_CUSTOMERS +
            " SET phoneNumber = ? WHERE surname = ?";

    // Рівні ізоляцій транзакцій
    @Override
    public void OpenTransaction() throws SQLException {
        conn.setAutoCommit(false);
    }
    @Override
    public void CloseTransaction() throws SQLException {
        conn.commit();
    }
    @Override
    public void IsolationTransaction(int NameOfIsolation)
            throws SQLException {
        conn.setTransactionIsolation(NameOfIsolation);
    }
    // Отримання даних з таблиць Router, Customer, Buy, TypeOfRouter
    @Override
    public MyList getAllRouters() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(GET_ALL_ROUTERS);
        MyList<Router> routers = new MyList<>();
        while (rs.next()) {
            routers.addLast(new Router(rs.getInt("RouterID"), rs.getInt("typeOfRouterID"),
                    rs.getInt("maxSpeed"), rs.getDouble("wifiFrequency"), rs.getInt("numberOfAntennas"),
                    rs.getString("color"), rs.getInt("weight"), rs.getInt("power"),
                    getEnum(rs.getString("protection")), rs.getString("brand"),
                    rs.getDouble("price")));
        }
        rs.close();
        st.close();
        return routers;
    }
    @Override
    public MyList getAllCustomers() throws SQLException{
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(GET_ALL_CUSTOMERS);
        MyList<Customer> customers = new MyList<>();
        while (rs.next()) {
            System.out.print(rs.getInt("customerID") + " " + rs.getString("surname") + " " +
                    rs.getString("name") + " " + rs.getString("patronymic") + " " +
                    rs.getString("phoneNumber") + " " + rs.getString("deliveryAdress")
                    + " " + rs.getString("email"));
            System.out.println();
        }
        rs.close();
        st.close();
        return customers;
    }
    @Override
    public MyList getAllBuy() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(GET_ALL_BUY);
        MyList<Buy> buy = new MyList<>();
        while (rs.next()) {
            System.out.print(rs.getInt("buyID") + " " + rs.getDate("dateOfBuy") + " " +
                    rs.getInt("customerID") + " " + rs.getInt("fullPrice") + " " +
                    rs.getString("currency") + " " + rs.getInt("RouterID"));
            System.out.println();
        }
        rs.close();
        st.close();
        return buy;
    }
    @Override
    public MyList getAllTypesOfRouters() throws SQLException{
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(GET_ALL_TYPES_OF_ROUTERS);
        MyList<TypesOfRouters> types = new MyList<>();
        while (rs.next()) {
            System.out.print(rs.getInt("typeOfRouterID") + " " +
                    rs.getString("description"));
            System.out.println();
        }
        rs.close();
        st.close();
        return types;
    }

    // Виведення всіх роутерів разом з розшифровкою типу
    @Override
    public void showAllRouters() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(SHOW_ALL_ROUTERS);
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getString("description")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency")
                    + " " + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                            + " "+ rs.getDouble("price"));
        }
        System.out.println();
        rs.close();
        st.close();
    }

    // Отримання даних з таблиць Router за його будь-якою характеристикою
    @Override
    public void getRoutersById(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_ID);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByType(int type) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_ID);
        ps.setInt(1, type);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByMaxSpeed(int maxSpeed) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_MAX_SPEED);
        ps.setInt(1, maxSpeed);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByWifiFrequency(double wifiFrequency) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_WIFI_FREQUENCY);
        ps.setDouble(1, wifiFrequency);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByNumberOfAntennas(int numberOfAntennas) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_NUMBER_OF_ANTENNAS);
        ps.setInt(1, numberOfAntennas);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByColor(String color) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_COLOR);
        ps.setString(1, color);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByWeight(int weight) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_WEIGHT);
        ps.setInt(1, weight);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByPower(int power) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_POWER);
        ps.setInt(1, power);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByProtection(Protection protection) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_PROTECTION);
        ps.setString(1, String.valueOf(protection));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByBrand(String brand) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_BRAND);
        ps.setString(1, brand);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }
    @Override
    public void getRoutersByPrice(double price) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(SELECT_ROUTERS_BY_PRICE);
        ps.setDouble(1, price);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("RouterID") + " " + rs.getInt("typeOfRouterID")
                    + " " + rs.getInt("maxSpeed") + " " + rs.getDouble("wifiFrequency") + " "
                    + rs.getInt("numberOfAntennas") + " " + rs.getString("color")
                    + " " + rs.getInt("weight") + " " + rs.getInt("power") + " " +
                    rs.getString("protection") + " " + rs.getString("brand")
                    + " "+ rs.getDouble("price"));
        }
        rs.close();
        ps.close();
    }

    // Додавання нового роутера, його типу, покупця, покупки
    @Override
    public void addRouter(int RouterID, int typeOfRouterID, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color,
                    int weight, int power, Protection protection, String brand, double price)
            throws SQLException{
        PreparedStatement ps = conn.prepareStatement(INSERT_DATA_INTO_ROUTER);
        ps.setInt(1, RouterID);
        ps.setInt(2, typeOfRouterID);
        ps.setInt(3,maxSpeed);
        ps.setDouble(4, wifiFrequency);
        ps.setInt(5, numberOfAntennas);
        ps.setString(6, color);
        ps.setInt(7, weight);
        ps.setInt(8, power);
        ps.setString(9, protection.toString());
        ps.setString(10, brand);
        ps.setDouble(11, price);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void addCustomer(int customerID, String surname, String name, String patronymic,
                            String phoneNumber, String deliveryAdress, String email) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(INSERT_DATA_INTO_CUSTOMER);
        ps.setInt(1, customerID);
        ps.setString(2, surname);
        ps.setString(3, name);
        ps.setString(4, patronymic);
        ps.setString(5, phoneNumber);
        ps.setString(6, deliveryAdress);
        ps.setString(7, email);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void addBuy(int buyID, Date dateOfBuy, int customerID, int fullPrice, String currency,
                        int RouterID) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(INSERT_DATA_INTO_BUY);
        ps.setInt(1, buyID);
        ps.setDate(2, (java.sql.Date) dateOfBuy);
        ps.setInt(3, customerID);
        ps.setInt(4, fullPrice);
        ps.setString(5, currency);
        ps.setInt(6, RouterID);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void addTypeOfRouter(int typeOfRouterID, String description) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(INSERT_DATA_INTO_TYPES_OF_ROUTER);
        ps.setInt(1, typeOfRouterID);
        ps.setString(2, description);
        ps.executeUpdate();
        ps.close();
    }

    //Зміна записів
    @Override
    public void changePriceRouter(int newPrice, int RouterID) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(UPDATE_PRICE_ROUTER);
        ps.setInt(1,newPrice );
        ps.setInt(2,RouterID);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void changePhoneNumberCustomer(String surname, String newPhoneNumber) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(UPDATE_PHONE_NUMBER_CUSTOMER);
        ps.setString(1, surname);
        ps.setString(2, newPhoneNumber);
        ps.executeUpdate();
        ps.close();
    }

    // Видалення роутера, покупця, покупку по ID
    @Override
    public void deleteRouterById(int RouterID) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(DELETE_DATA_FROM_ROUTER_BY_ID);
        ps.setInt(1, RouterID);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void deleteCustomerById(int customerID) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(DELETE_DATA_FROM_CUSTOMER_BY_ID);
        ps.setInt(1, customerID);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void deleteBuyById(int buyID) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(DELETE_DATA_FROM_BUY_BY_ID);
        ps.setInt(1, buyID);
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void deleteTypeOfRouterById(int typeOfRouterID) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(DELETE_DATA_FROM_TYPE_OF_ROUTER_BY_ID);
        ps.setInt(1, typeOfRouterID);
        ps.executeUpdate();
        ps.close();
    }
    //перевторення рядку, який зчитує поле 'protection' з БД на об'єкт enum типу Protection
    public static Protection getEnum(String str) {
        Protection protection = null;
        switch (str) {
            case "WEP":
                protection = Protection.WEP;
                break;
            case "WPA":
                protection = Protection.WPA;
                break;
            case "WPA2":
                protection = Protection.WPA2;
                break;
            case "WPA3":
                protection = Protection.WPA3;
                break;
            default:
                break;

        }
        return protection;
    }
}