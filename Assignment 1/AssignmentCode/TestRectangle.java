// Khanmohammadi, Amir Hosein, 991646689
/** the program is a driver class named "TestRectangle" that creates three "Rectangle" objects.
 *  The first rectangle object is created with width 4 and height 40, the second one with width 
 * 3.5 and height 35.9 and the third one request to creat with width -2 and height 20, but raised exception due to negative width.
 * For each rectangle object, it uses the getter methods to get the width, height, area, and perimeter 
 * of each rectangle and display them on the console.
 * It also uses the static method "getNumberOfRectangles" to get the number of rectangles created and display it on the console.
 * It also has try-catch blocks for each rectangle object, if the width or height passed in the 
 * constructor is negative or zero, an exception will be thrown, and it will be caught by the corresponding 
 * catch block and it will print the error message.
 * This way, the program can continue creating and displaying the next rectangle even if an exception occurred 
 * with the previous one. */
// 2023-01-17

public class TestRectangle {
    // Main method
    public static void main(String[] args) {

    // create rectangle 1 with width 4 and height 40
    try {
        Rectangle rectangle1 = new Rectangle(4, 40);
        System.out.println("Rectangle 1:");
        System.out.println("The Width is " + rectangle1.getWidth() 
            + " and The Height is " + rectangle1.getHeight() + " .");
        System.out.println("The Area is " + rectangle1.getArea()
            + " and The Perimeter is " + rectangle1.getPerimeter() + " .");
        System.out.println("-------------------------------------------");
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    // create rectangle 2 with width 3.5 and height 35.9
    try {
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);
        System.out.println("Rectangle 2:");
        System.out.println("The Width is " + rectangle2.getWidth() 
            + " and The Height is " + rectangle2.getHeight() + " .");
        System.out.println("The Area is " + rectangle2.getArea()
            + " and The Perimeter is " + rectangle2.getPerimeter() + " .");
        System.out.println("-------------------------------------------");
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    // create rectangle 3 with width -2 and height 20
    try {
        Rectangle rectangle3 = new Rectangle(-2, 20);
        System.out.println("Rectangle 3:");
        System.out.println("The Width is " + rectangle3.getWidth() 
            + " and The Height is " + rectangle3.getHeight() + " .");
        System.out.println("The Area is " + rectangle3.getArea()
            + " and The Perimeter is " + rectangle3.getPerimeter() + " .");
        System.out.println("-------------------------------------------");
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
    
    // number of rectangles that program used
    System.out.println("Number of rectangles: " + Rectangle.getNumberOfRectangles());

    }
}
