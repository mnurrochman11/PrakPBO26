package id.ac.polinema;

public class Rectangle {
    // langkah 2
    int width;
    int height;

    // langkah 3
    int area() {
        return width * height;
    }

    int perimeter() {
        return 2 * (width + height);
    }

    // langkah 4
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
