package id.ac.polinema;

public class Circle {
    // Tugas
    double radius;

    double area() {
        return Math.PI * radius * radius;
    }

    double circumference() {
        return 2 * Math.PI * radius;
    }

    Circle(double radius) {
        this.radius = radius;
    }
}
