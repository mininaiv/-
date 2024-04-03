import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Vector {
    private int x1, y1, z1, x2, y2, z2;
    public Vector(int x1, int y1, int z1, int x2, int y2, int z2){
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }

    public Vector add(Vector other){
        int newX = (this.x2 - this.x1) + (other.x2 - other.x1);
        int newY = (this.y2 - this.y1) + (other.y2 - other.y1);
        int newZ = (this.z2 - this.z1) + (other.z2 - other.z1);

        return new Vector(0, 0, 0, newX, newY, newZ);
    }

    public Vector subtract(Vector other){
        int newX = this.x2 - other.x2 - this.x1 + other.x1;
        int newY = this.y2 - other.y2 - this.y1 + other.y1;
        int newZ = this.z2 - other.z2 - this.z1 + other.z1;
        return new Vector(0, 0, 0, newX, newY, newZ);
    }

    public double lenght(){
        double X = this.x2 - this.x1;
        double Y = this.y2 - this.y1;
        double Z = this.z2 - this.z1;

        return Math.sqrt(X*X + Y*Y + Z*Z);
    }


}
