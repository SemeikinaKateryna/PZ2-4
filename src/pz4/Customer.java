package pz4;

public class Customer {
    int customerID;
    String surname;
    String name;
    String patronymic;
    String phoneNumber;
    String deliveryAdress;
    String email;
    public Customer(int customerID, String surname, String name, String patronymic, String phoneNumber,
                    String deliveryAdress, String email) {
        this.customerID = customerID;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.deliveryAdress = deliveryAdress;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deliveryAdress='" + deliveryAdress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
