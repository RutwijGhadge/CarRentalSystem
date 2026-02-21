public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String licencePlate;
    private boolean available;
    private final double rentalPricePerDay;

    public Car(String model, String make,String licencePlate, int year, double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
        this.licencePlate = licencePlate;
        this.year = year;
        this.model = model;
        this.make = make;
        this.available=true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
