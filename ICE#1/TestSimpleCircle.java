// Khanmohammadi, Amir Hosein, ID 991646689
// object oriented Java with speared class and drive class
// 2023-01-12

public class TestSimpleCircle {
    
    /** Main method */
    public static void main(String[] args) {
      // Create a circle with radius 1
      SimpleCircle circle1 = new SimpleCircle();
      System.out.println("The area of the circle1 of radius "
        + circle1.getRadius() + " is " + circle1.getArea());

      System.out.println("The perimeter of the circle1 of radius "
        + circle1.getRadius() + " is " + circle1.getPerimeter() + "\n");
  
      // Create a circle with radius 25
      SimpleCircle circle2 = new SimpleCircle(25);
      System.out.println("The area of the circle2 of radius "
        + circle2.getRadius() + " is " + circle2.getArea());
    
      System.out.println("The perimeter of the circle2 of radius "
        + circle2.getRadius() + " is " + circle2.getPerimeter() + "\n");
  
      // Create a circle with radius 125
      SimpleCircle circle3 = new SimpleCircle(125);
      System.out.println("The area of the circle3 of radius "
        + circle3.getRadius() + " is " + circle3.getArea());

      System.out.println("The perimeter of the circle3 of radius "
        + circle3.getRadius() + " is " + circle3.getPerimeter() + "\n");
  

      // Modify circle2 radius
      circle2.setRadius(100); // or circle2.setRadius(100)
      System.out.println("The area of the circle2 of radius "
        + circle2.getRadius() + " is " + circle2.getArea());
    
      System.out.println("The perimeter of the circle2 of radius "
        + circle2.getRadius() + " is " + circle2.getPerimeter() + "\n");
        

      // Modify circle3 radius
      circle3.setRadius(200); // or circle3.setRadius(200)
      System.out.println("The area of the circle3 of radius "
        + circle3.getRadius() + " is " + circle3.getArea());

      System.out.println("The perimeter of the circle3 of radius "
        + circle3.getRadius() + " is " + circle3.getPerimeter() + "\n");
        
    }
  }
  
  