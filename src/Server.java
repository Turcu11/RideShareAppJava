import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server implements IServer{

    Scanner scanner = new Scanner(System.in);

    private Map<Integer, IUser> users = new HashMap<>();
    private Map<Integer, IVehicle> vehicles = new HashMap<>();
    private ArrayList<IVehicle> viableOptions = new ArrayList<>();

    @Override
    public void registerVehicle(IVehicle vehicle) {
        if(vehicles.containsKey(vehicle.getId())){
            System.out.println("There is already a car with the ID of: "+ vehicle.getId());
            return;
        }
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void getRegisteredVehiles(){
      for(Map.Entry<Integer, IVehicle> entry : vehicles.entrySet()){
          System.out.println("Key " + entry.getValue().getLicensePlate());
          System.out.println("And the size of the Map is: "+vehicles.size());
      }
    }

    @Override
    public void registerUser(IUser user) {
        if(users.containsKey(user.getId())) return;
        users.put(user.getId(), user);
    }

    @Override
    public void requestRide(IUser user) {
        getNearestVehicle(user);
        showTheUserViableOptions(user);
        acceptRide();
    }

    @Override
    public void acceptRide() {
        int option = 0;
        System.out.println("Would you like to get the nearest vehicle ? \n 1.YES \n 2.NO");
        option = scanner.nextInt();
        if(option == 1){
            System.out.println("great just waiting for the driver to confirm :D");
            if(viableOptions.size() > 0){
                IVehicle chosenVehicle = viableOptions.get(0);
                notifyDriver(chosenVehicle);
            }
        } else if (option == 2) {
            System.out.println("too bad :(");

        }
    }

    @Override
    public void notifyDriver(IVehicle vehicle) {
        boolean diverAnswer = vehicle.getNotifyed();
        if(diverAnswer){
            System.out.println("Vehicle with the license plate: "+ vehicle.getLicensePlate() + " is on it's way to you");
        }
        else{
            System.out.println("The driver did not accepted it :( \n redirecting your request to another driver...");
            viableOptions.remove(vehicle);
            if(viableOptions.size() != 0){
                acceptRide();
            }
            else {
                System.out.println("thre are no more options... \n SORRY !");
            }
        }
    }

    private ArrayList getNearestVehicle(IUser user){
        viableOptions.clear();
        int tempDistance = Integer.MAX_VALUE;
        for(Map.Entry<Integer, IVehicle> entry : vehicles.entrySet()){
            IVehicle vehicle = entry.getValue();
            if(!vehicle.isBusy()){
                int distance = vehicle.getDistance(user);
                if(tempDistance > distance){
                    tempDistance = distance;
                }
                if(viableOptions.size() < 3){
                    viableOptions.add(vehicle);
                }
            }
//            System.out.println(tempDistance);
        }
        return viableOptions;
    }

    private void showTheUserViableOptions(IUser user){
        System.out.println("You have the following options: ");
        for (IVehicle vehicle: viableOptions) {
            System.out.print(vehicle.getLicensePlate() + " beeing ");
            System.out.print(vehicle.getDistance(user) + " km away");
            System.out.println();
        }
        if(viableOptions.size() > 0){
            System.out.println("And the nearest vehicle is just " + viableOptions.get(0).getDistance(user) + " km away");
        }
    }
}
