package com.example.project;

public class TriangleCollection {


  // array of Triangles
  private Triangle[] collection;

  // Constructor: initialize collection array with the number of
  // Triangle objects specified by numTriangles, with the first
  // Triangle in the collection having vertices at Points:
  // (-startx, 0), (0, startY), (startX, 0)
  //
  // Then, each subsequent Triangle object in the collection (up to
  // numTriangles) should be created with same first and second vertices,
  // (-startX, 0) and (0, startY), but with a different third vertex located
  // at (startX - i, 0), where i is the index in the collections array where
  // the Triangle object is located
  //
  // For example, creating a TriangleCollection with numTriangles = 6,
  // startX = 4, and startY = 7 would yield a collections array containing
  // 6 Triangles with the following vertices:
  // Triangle 0: (-4, 0), (0, 7), (4, 0)
  // Triangle 1: (-4, 0), (0, 7), (3, 0)
  // Triangle 2: (-4, 0), (0, 7), (2, 0)
  // Triangle 3: (-4, 0), (0, 7), (1, 0)
  // Triangle 3: (-4, 0), (0, 7), (0, 0)
  // Triangle 3: (-4, 0), (0, 7), (-1, 0)

  // PRECONDITION: numTriangles >= 2
  public TriangleCollection(int numTriangles, int startX, int startY) {
      collection = new Triangle[numTriangles];
      for (int i = 0; i < numTriangles; i++) {
          Point a = new Point(-startX, 0);
          Point b = new Point(0, startY);
          Point c = new Point(startX - i, 0);
          Triangle t = new Triangle(a, b, c);
          collection[i] = t;
      }
  }

  // Calculate and return the sum of the perimeters of
  // all Triangles in the collection
  public double totalPerimeter() {
      double totalPerimeter = 0;
      for (Triangle t : collection) {
          totalPerimeter += t.perimeter();
      }
      return totalPerimeter;
  }

  // adds increment to both the x and y coordinates of each of the
  // three Points in every Triangle in the collections array
  // ADD GETTER AND SETTER METHODS TO OTHER CLASSES AS NECESSARY
  public void shiftTriangles(int increment) {
      Point incPoint = new Point(increment, increment);
      for (Triangle t : collection) {
          Point[] vertices = t.getVertices();
          for (Point p : vertices) {
              p.add(incPoint);
          }
      }
  }

  // returns a String that contains each Triangle in the
  // collection on a new line; for example, the string
  // representing a collection containing three
  // Triangles should look like this when printed:
  //
  // "[(1, 5), (5, 12), (9, 5)]
  //  [(1, 5), (5, 12), (8, 5)]
  //  [(1, 5), (5, 12), (7, 5)]"
  public String triangleCollectionInfo() {
      String info = "";
      for (Triangle t : collection) {
          info += t.triangleInfo() + "\n";
      }
      return info.substring(0, info.length());
  }
}