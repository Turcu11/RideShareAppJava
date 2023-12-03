import java.lang.Math;
import java.util.Scanner;
public class Car implements IVehicle{

    Scanner scanner = new Scanner(System.in);

    private int id;
    private int location;

    private int distance;
    private boolean isBusy;
    private String licensePlate;

    public Car(int id, int location, String licensePlate){
        this.id = id;
        this.location = location;
        this.licensePlate = licensePlate;
        this.isBusy = false;
    }


    @Override
    public int getDistance(IUser user) {
        this.distance = Math.abs(this.location - user.getLocation());
        return Math.abs(this.location - user.getLocation());
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isBusy() {
        return this.isBusy;
    }

    private void setBusy(boolean busy){
        this.isBusy = busy;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public boolean getNotifyed() {
        int option = 0;
        System.out.println("You are now the notified driver of the car \""+this.getLicensePlate()+"\" do you accept the ride ? \n 1.YES \n 2.NO");
        option = scanner.nextInt();
        if(option == 1){
            setBusy(true);
            return true;
        }
        else {
            return false;
        }
    }
}
