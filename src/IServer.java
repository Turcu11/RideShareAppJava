public interface IServer {
    void registerVehicle(IVehicle vehicle);
    void registerUser(IUser user);
    void requestRide(IUser user);

    void acceptRide();

    void notifyDriver(IVehicle vehicle);
}
