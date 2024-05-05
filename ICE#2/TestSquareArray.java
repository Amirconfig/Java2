// Khanmohammadi, Amir Hosein, 991646689
// 2023-01-19

import java.util.Random;

class TestSquareArray {
    public static void main(String[] args) {
        Random rand = new Random();
        Square[] squareArray = createSquareArray(rand);
        printSquareArray(squareArray);
        System.out.println("------------------------------------");
        System.out.println("Total area of the squares: " + sum(squareArray));
        System.out.println("Total number of squares: " + Square.getNumberOfSquares());
    }
    public static Square[] createSquareArray(Random rand) {
        Square[] squareArray = new Square[5];
        for (int i = 0; i < squareArray.length; i++) {
            double side = rand.nextInt(100) + 1;
            squareArray[i] = new Square(side);
        }
        return squareArray;
    }
    public static void printSquareArray(Square[] squareArray) {
        System.out.println("Side\tArea");
        for (Square s : squareArray) {
            System.out.println(s.getSide() + "\t" + s.getArea());
        }
    }
    public static double sum(Square[] squareArray) {
        double total = 0;
        for (Square s : squareArray) {
            total += s.getArea();
        }
        return total;
    }
}

