class Shape {
    public int getArea() {
        return 0;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

public class BasicsOfClasses {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 4);
        Shape square = new Square(3);

        printArea(rectangle);
        printArea(square);
    }

    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }
}