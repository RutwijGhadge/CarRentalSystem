package Models;

public class Customer {
    private final String name;
    private final String contactNumber;
    private final String driversLicenseNumber;

    public Customer(String name, String driversLicenseNumber, String contactNumber) {
        this.name = name;
        this.driversLicenseNumber = driversLicenseNumber;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
