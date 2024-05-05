// Khanmohammadi, Amir Hosein, ID 991646689
// object oriented Java with speared class and drive class
// 2023-01-12

// Define the circle class with two constructors
class SimpleCircle {
    private double radius;
  
    /** Construct a circle with radius 1 */
    SimpleCircle() {
      setRadius(1);
    }
  
    public double getRadius() {
        return radius;
    }

    /** Construct a circle with a specified radius */
    SimpleCircle(double newRadius) {
      setRadius(newRadius);
    }
  
    /** Return the area of this circle */
    public double getArea() {
      return getRadius() * getRadius() * Math.PI;
    }
  
    /** Return the perimeter of this circle */
    public double getPerimeter() {
      return 2 * getRadius() * Math.PI;
    }
  
    /** Set a new radius for this circle */
    public void setRadius(double newRadius) {
      radius = newRadius;
    }
  }