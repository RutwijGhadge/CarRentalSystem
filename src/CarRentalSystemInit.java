import Models.Car;
import Models.Customer;
import Models.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public class CarRentalSystemInit {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem=CarRentalSystem.getInstance();

        //Adding Cars
        carRentalSystem.addCar(new Car("Camry", "Toyota", "ABC123",2022, 50.0));
        carRentalSystem.addCar(new Car("Civic", "Honda", "XYZ789",2021, 45.0));
        carRentalSystem.addCar(new Car("Mustang", "Ford", "DEF456",2023, 80.0));

        Customer customer=new Customer("John Doe", "john@example.com", "DL1234");

        LocalDateTime startDate= LocalDateTime.now();
        LocalDateTime endDate= startDate.plusDays(4);

        List<Car> availableCars = carRentalSystem.searchCars("Ford","Mustangs",startDate,endDate);
        if(!availableCars.isEmpty()){
            Car selectedCar = availableCars.get(0);
            Reservation reservation= carRentalSystem.makeReservation(customer,selectedCar,startDate,endDate);
            if(reservation!=null){
                boolean paymentSuccess= carRentalSystem.processPayment(reservation);
                if(paymentSuccess){
                    System.out.println("Payment for Models.Reservation is Successful with id:"+reservation.getReservationId());
                }else{
                    System.out.println("Payment Failed, Cancelling Models.Reservation");
                    carRentalSystem.cancelReservation(reservation.getReservationId());
                }
            }else{
                System.out.println("Selected Models.Car is Not Available for the Given Dates");
            }
        }else{
            System.out.println("No Cars Available of this type at the moment.");
        }
    }

}
