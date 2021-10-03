public class ParkingLotSystem {

    private final int actualCapacity;
    private int currentCapacity;
    private Object vehicle;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.currentCapacity == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("Parking Lot is FULL");
        }
        this.currentCapacity++;
        this.vehicle = vehicle;
    }

    public boolean isVehicleParked(Object vehicle) {
        return this.vehicle.equals(vehicle);
    }

    public void unpark(Object vehicle) throws ParkingLotException {
        if (vehicle == null)
            throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible");
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
        }
    }

    public boolean isVehicleUnparked(Object vehicle) {
        return this.vehicle == null;
    }

    public boolean isLotFull() {
        return this.vehicle != null;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }
}
