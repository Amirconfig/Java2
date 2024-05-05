import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        // System.out.print("Enter side1: ");
        // double side1 = input.nextDouble();
        // System.out.print("Enter side2: ");
        // double side2 = input.nextDouble();
        // System.out.print("Enter side3: ");
        // double side3 = in234put.nextDouble();

        System.out.print("Enter the color: ");
        String color = input.next();
        System.out.print("Is the triangle filled (true / false)? ");
        boolean filled = input.nextBoolean();
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        System.out.println("The sides of the triangle are: " + triangle.getSide1() + " " +
                           triangle.getSide2() + " " + triangle.getSide3());
        System.out.println("The area of the triangle is: " + triangle.getArea());
        System.out.println("The perimeter of the triangle is: " + triangle.getPerimeter());
        System.out.println("The color of the triangle is: " + triangle.getColor());
        System.out.println("The triangle is filled: " + triangle.isFilled());
        System.out.println("The date the triangle was created is: " + triangle.getDateCreated());
    }
}
