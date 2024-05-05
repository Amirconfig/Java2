// Square.java
// Amir Hosein Khanmohammadi 
// ID# 991646689
// 2023-02-20

public class Square extends GeometricObject implements Colorable {
    private double side;
    
    public Square() {
        side = 0;
    }
    
    public Square(double side) {
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    public double getArea() {
        return side * side;
    }
    
    public double getPerimeter() {
        return 4 * side;
    }
    
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}