import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    private int actualCapacity;
    private List vehicles;
    private ParkingLotOwner owner;
    private AirportSecurity security;

    public ParkingLotSystem(int capacity) {
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }

    public void registerSecurity(AirportSecurity airportSecurity) {
        this.security = airportSecurity;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            owner.capacityIsFull();
            security.capacityIsFull();
            throw new ParkingLotException("Parking Lot is FULL");
        }
        if (isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle Already Parked");
        this.vehicles.add(vehicle);
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }

    public void unpark(Object vehicle) throws ParkingLotException {
        if (vehicle == null)
            throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible");
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
        }
    }

    public boolean isVehicleUnparked(Object vehicle) {
        return this.vehicles == null;
    }

    public boolean isLotFull() {
        return this.vehicles != null;
    }


}