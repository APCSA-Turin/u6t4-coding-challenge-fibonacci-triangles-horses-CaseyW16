package com.example.project;

public class Triangle {
  // array of Point objects
  private Point[] vertices;
 
  // Constructor: initializes the vertices array
  // to contain the three Point objects
  public Triangle(Point p1, Point p2, Point p3) {
      vertices = new Point[3];
      vertices[0] = p1;
      vertices[1] = p2;
      vertices[2] = p3;
  }
 
  // Returns the perimeter of the Triangle
  // HINT: use the distanceTo method that you wrote in the Point class
  public double perimeter() {
      double perimeter = 0;
      for (int i = 0; i < 3; i++) {
          Point a = vertices[i];
          Point b = vertices[(i + 1) % 3];
          perimeter += a.distanceTo(b);
      }
      return perimeter;
  }

  // Returns a String with the three vertices that make up the Triangle;
  // if the vertices are the points (6, 10), (11, 15), and (18, 7),
  // this method should return: "[(6, 10), (11, 15), (18, 7)]"
  public String triangleInfo() {
      String info = "[";
      for (Point p : vertices) {
          info += p.pointInfo() + ", ";
      }
      info = info.substring(0, info.length() - 2);
      return info + "]";
  }


  public Point[] getVertices() {
      return vertices;
  }
}  
