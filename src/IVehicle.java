public interface IVehicle {

    int getDistance(IUser user);

    int getId();

    boolean isBusy();
    String getLicensePlate();

    boolean getNotifyed();
}
