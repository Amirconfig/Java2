// TestGeometricObject.java
// Amir Hosein Khanmohammadi 
// ID# 991646689
// 2023-02-20

public class TestGeometricObject {
    public static void main(String[] args) {
        GeometricObject[] shapes = new GeometricObject[5];
        shapes[0] = new Square(3.5);
        shapes[1] = new Circle(4.5);
        shapes[2] = new Square(6);
        shapes[3] = new Rectangle(2, 5);
        shapes[4] = new Square(5.5);
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.print("Area of " + shapes[i].getClass().getSimpleName() + " ");
            if (shapes[i] instanceof Square) {
                System.out.printf("with side: %.1f is: %.2f\n", ((Square)shapes[i]).getSide(), shapes[i].getArea());
                ((Square)shapes[i]).howToColor();
            } else {
                System.out.printf("with ");
                if (shapes[i] instanceof Circle) {
                    System.out.printf("radius: %.1f ", ((Circle)shapes[i]).getRadius());
                } else if (shapes[i] instanceof Rectangle) {
                    System.out.printf("width of : %.1f and height of %.1f ", ((Rectangle)shapes[i]).getWidth(), ((Rectangle)shapes[i]).getHeight());
                }
                System.out.printf("is: %.2f\n", shapes[i].getArea());
            }
        }
    }
}