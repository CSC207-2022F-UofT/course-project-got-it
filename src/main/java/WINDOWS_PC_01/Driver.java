package WINDOWS_PC_01;

public class Driver {
    // Test commit. 00001.
    private String name;
    private int x;
    private int y;
    private int Speed;
    public Driver(String name, int x, int y, int S){
        this.name = name;
        this.x = x;
        this. y = y;
        this.Speed = S;
    }
    public String getName(){
        return this.name;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getSpeed(){
        return this.Speed;
    }
}
