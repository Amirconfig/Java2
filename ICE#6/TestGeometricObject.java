public class TestGeometricObject {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(7);
        Circle maxCircle = (Circle) GeometricObject.max(circle1, circle2);
        System.out.println("The larger circle has radius " + maxCircle.getRadius() + " and area " + maxCircle.getArea());

        Rectangle rectangle1 = new Rectangle(3, 4);
        Rectangle rectangle2 = new Rectangle(5, 6);
        Rectangle maxRectangle = (Rectangle) GeometricObject.max(rectangle1, rectangle2);
        System.out.println("The larger rectangle has dimensions of " + maxRectangle.getWidth() + " x " + maxRectangle.getHeight() + " and area " + maxRectangle.getArea());
    }
}

