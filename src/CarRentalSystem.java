import Models.Car;
import Models.Customer;
import Models.Reservation;
import Payment.CreditCardPaymentProcessor;
import Payment.PaymentProcessor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalSystem {
    private static CarRentalSystem instance = new CarRentalSystem();
    private final Map<String,Car>cars;
    private final Map<String, Reservation>reservationMap;
    private final PaymentProcessor paymentProcessor;

    private CarRentalSystem() {
        cars= new ConcurrentHashMap<>();
        reservationMap= new ConcurrentHashMap<>();
        paymentProcessor= new CreditCardPaymentProcessor();
    }

    public static CarRentalSystem getInstance(){
        return instance;
    }

    public void addCar(Car car){
        cars.put(car.getLicencePlate(),car);
    }

    public void removeCar(String licensePlate){
        cars.remove(licensePlate);
    }

    //If make & model matches and car is Available
    public List<Car>searchCars(String make , String model , LocalDateTime startDate, LocalDateTime endDate){
        List<Car>availableCars= new ArrayList<>();
        for(Car car:cars.values()){
            if(make.equalsIgnoreCase(car.getMake()) && model.equalsIgnoreCase(car.getModel()) && car.isAvailable()){
                if(isCarAvailable(car,startDate,endDate)){
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car,LocalDateTime startDate , LocalDateTime endDate) {
        for (Reservation reservation : reservationMap.values()) {
            if (reservation.getCar().equals(car)) {
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate()))
                    return false;
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDateTime startDate, LocalDateTime endDate){
        if(isCarAvailable(car,startDate,endDate)){
            String reservationId = generateReservationId();
            Reservation reservation=new Reservation(endDate,startDate,customer,car,reservationId);
            car.setAvailable(false);
            reservationMap.put(reservationId,reservation);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId){
        Reservation reservation= reservationMap.remove(reservationId);
        if(reservation!=null){
            reservation.getCar().setAvailable(true);
        }
    }

    public boolean processPayment(Reservation reservation){
        return paymentProcessor.processPayment(reservation.getTotalRent());
    }

    public String generateReservationId(){
        return "RES" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}
