package Models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private final String reservationId;
    private final Car car;
    private final Customer customer;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final double totalRent;

    public Reservation(LocalDateTime endDate, LocalDateTime startDate, Customer customer, Car car, String reservationId) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.customer = customer;
        this.car = car;
        this.reservationId = reservationId;
        this.totalRent = getTotalRent();
    }

    public String getReservationId() {
        return reservationId;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public double getTotalRent() {
        long totalDaysRented = ChronoUnit.DAYS.between(startDate,endDate)+1;
        return car.getRentalPricePerDay()*totalDaysRented;
    }
}
