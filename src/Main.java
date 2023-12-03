public class Main {
    public static void main(String[] args) {

        Server server = new Server();
        User user = new User(1, 10, server);
        User user2 = new User(2, 13, server);
        Car VW = new Car(1, 10, "AR95TDA");
        Car Audi = new Car(2, 12, "AR07AUD");
        Scooter Peugeot = new Scooter(3, 15, 96, "BH47PGT");
        Car BMW = new Car(4, 20, "CJ13BMW");
        Car Mercedes = new Car(5, 8, "TM65BUN");

        server.registerUser(user);
        server.registerUser(user2);
        server.registerVehicle(VW);
        server.registerVehicle(Audi);
        server.registerVehicle(Peugeot);
        server.registerVehicle(BMW);
        server.registerVehicle(Mercedes);

        user.requestRide();
        user2.requestRide();
    }
}