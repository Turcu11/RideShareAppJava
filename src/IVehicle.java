public interface IVehicle {

    int getDistance(IUser user);

    int getId();

    int seeDistance();

    boolean isBusy();
    String getLicensePlate();

    boolean getNotifyed();
}
