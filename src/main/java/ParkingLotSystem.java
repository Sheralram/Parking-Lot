public class ParkingLotSystem {

    private Object vehicle;

    public ParkingLotSystem(){
    }


    public void park(Object vehicle) throws ParkingLotException {
       if(this.vehicle != null)
           throw new ParkingLotException("Parking Lot is FULL");
        this.vehicle = vehicle;
    }

    public boolean isVehicleParked(Object vehicle) {
        if(this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public void unpark(Object vehicle) throws ParkingLotException {
        if(vehicle == null)
            throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible");
        if(this.vehicle.equals(vehicle)) {
            this.vehicle = null;
        }
    }

    public boolean isVehicleUnparked(Object vehicle){
        if(this.vehicle == null)
            return true;
        return false;
    }

}
