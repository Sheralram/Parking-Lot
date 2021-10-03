import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem;
    Object vehicle;

    @BeforeEach
    void setUp() {
        parkingLotSystem = new ParkingLotSystem(1);
        vehicle = new Object();
    }

    @Test
    void givenAVehicle_WhenParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            boolean park = parkingLotSystem.isVehicleParked(vehicle);
            parkingLotSystem.unpark(vehicle);
            boolean unpark = parkingLotSystem.isVehicleUnparked(vehicle);
            Assertions.assertEquals(park, unpark);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVehicle_WhenAlreadyParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.isVehicleParked(vehicle);
            parkingLotSystem.park(vehicle);
            parkingLotSystem.isVehicleParked(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot is FULL", e.getMessage());
            e.printStackTrace();
        }

    }
    @Test
    void givenAVehicle_WhenParkingLotIsFull_ShouldInformOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerOwner(owner);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
        }
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertTrue(capacityFull);
    }

    @Test
    void givenCapacityIs2_ShouldBeAbleToPark2Vehicles() {
        Object vehicle2 = new Object();
        parkingLotSystem.setCapacity(2);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(vehicle2);
            boolean isParked1 = parkingLotSystem.isVehicleParked(vehicle);
            boolean isParked2 = parkingLotSystem.isVehicleParked(vehicle2);
            Assertions.assertTrue(isParked1 && isParked2);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    void givenAVehicle_WhenParkingLotIsFull_ShouldAirportSecurity() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerOwner(owner);
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotSystem.registerSecurity(airportSecurity);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
        }
        boolean capacityFull = airportSecurity.isCapacityFull();
        Assertions.assertTrue(capacityFull);
    }

}




