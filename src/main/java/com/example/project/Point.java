package com.example.project;


public class Point {
    private int x;
    private int y;
   
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
   
    // Returns distance between this Point object and another Point object
    public double distanceTo(Point other) {
        int xb = other.x;
        int yb = other.y;
        int xDist = x - xb;
        int yDist = y - yb;
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }
 
    // Returns a string in the format: (x, y)
    public String pointInfo() {
        return "(" + x + ", " + y + ")";
    }


    public void add(Point other) {
        x += other.x;
        y += other.y;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}  
