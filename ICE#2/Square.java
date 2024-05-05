// Khanmohammadi, Amir Hosein, 991646689
// 2023-01-19

public class Square {
    private double side;
    private static int numberOfSquares;
    public Square() {
        // this.side = 1;
        // numberOfSquares++; 
        this(1.0);
    }
    public Square(double side) {
        setSide(side);
        numberOfSquares++;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        side = (side > 0) ? side : 1.0;
        this.side = side;
    }
    public double getArea() {
        return side * side;
    }
    public static int getNumberOfSquares() {
        return numberOfSquares;
    }
}


// Square
// -side: double
// -numberOfSquares: int

// +Square()
// +Square(side: double)
// +getSide(): double
// +setSide(side: double)
// +getArea(): double
// +getNumberOfSquares(): int

