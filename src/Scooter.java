import java.lang.Math;
import java.util.Scanner;
public class Scooter implements IVehicle{
    Scanner scanner = new Scanner(System.in);
    private int id;
    private int location;
    private int distance;
    private boolean isBusy;
    private int chargeLevel;
    private String licensePlate;

    public Scooter(int id, int location, int chargeLevel, String licensePlate){
        this.id = id;
        this.location = location;
        this.chargeLevel = chargeLevel;
        this.licensePlate = licensePlate;
    }

    @Override
    public int getDistance(IUser user) {
        this.distance = Math.abs(this.location - user.getLocation());
        return Math.abs(this.location - user.getLocation());
    }

    public int getChargeLevel(){
        return this.chargeLevel;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int seeDistance() {
        System.out.println(this.distance);
        return this.distance;
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
        System.out.println("You are now the notified driver of the scooter \"" +this.getLicensePlate()+ "\" do you accept the ride ? \n 1.YES \n 2.NO");
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
