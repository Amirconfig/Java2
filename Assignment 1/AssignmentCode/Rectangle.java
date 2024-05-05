// Khanmohammadi, Amir Hosein, 991646689
/** This program is a Java class named "Rectangle" that has private attributes for width 
 * and height, and a static variable to keep track of the number of rectangles created. The class 
 * has a default constructor and a constructor that takes in width and height and assigns them to 
 * the instance variables, after validating that the values passed in are greater than 0. It also 
 * has setter and getter methods for width and height, and methods to calculate the area and perimeter 
 * of the rectangle. If the width or height is set to a negative value, it throws an exception with an 
 * error message. It also has a static method to return the number of rectangles created. This class can 
 * be used to create rectangle objects with specified width and height, get their width and height, get 
 * their area and perimeter, and get the number of rectangles created so far. */
// 2023-01-17

public class Rectangle {

    private double width;
    private double height;
    private static int numberOfRectangles;

    // default constructor of Rectangle
    public Rectangle() {
        /*
        width = 1;
        height = 1;
        numberOfRectangles++;*/
        this(1.0,1.0);
    }

    // constructor of Rectangle with specified width and height
    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
        numberOfRectangles++;
    }

    // setter for width
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be negative or zero!");
        }else{
        this.width = width;
        }
    }

    // getter for width
    public double getWidth() {
        return width;
    }

    // setter for height
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be negative or zero!");
        }else{
        this.height = height;
        }
    }

    // getter for height
    public double getHeight() {
        return height;
    }

    // method to calculate area
    public double getArea() {
        return width * height;
    }

    // method to calculate perimeter
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public static int getNumberOfRectangles(){
        return numberOfRectangles;
    }

}