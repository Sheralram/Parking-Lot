import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem;
    Object vehicle;

    @BeforeEach
    void setUp() {
        parkingLotSystem = new ParkingLotSystem();
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
    void givenAVehicle_WhenUnParked_ShouldReturnTrue()  {
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
    void givenAQuery_WhenParkingLotIsFull_ShouldInformOwner() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean informOwner = parkingLotSystem.isLotFull();
        Assertions.assertTrue(informOwner);
    }
}
