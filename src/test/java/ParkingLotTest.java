import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    void setUp() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        vehicle = new Object();
    }

    @Test
    void givenAVehicle_WhenParked_ShouldReturnTrue() {
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertTrue(isParked);
    }

    @Test
    void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        parkingLotSystem.park(vehicle);
        boolean isUnparked = parkingLotSystem.unpark( vehicle);
        Assertions.assertTrue(isUnparked);
    }

    @Test
    void givenAVehicle_WhenAlreadyParked_ShouldReturnTrue() {
       parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertFalse(isParked);
    }

}
