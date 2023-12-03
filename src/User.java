public class User implements IUser {

    private int id;
    private int location;
    private IServer server;

    public User(int id, int location, IServer server){
        this.id = id;
        this.location = location;
        this.server = server;
    }

    public void acceptRide(){
        server.acceptRide();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getLocation() {
        return this.location;
    }

    @Override
    public void requestRide() {
        server.requestRide(this);
    }
}
