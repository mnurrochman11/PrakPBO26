package id.ac.polinema;

public class Main {
    public static void main(String[] args) {
        // langkah 2
        /*
         * Rectangle r = new Rectangle();
         * r.width = 6;
         * r.height = 4;
         * System.out.println("Rectangle " + r.width + "x" + r.height);
         */

        // langkanh 3
        /*
         * Rectangle r = new Rectangle();
         * r.width = 6;
         * r.height = 4;
         * System.out.println("Area: " + r.area());
         * System.out.println("Perimeter: " + r.perimeter());
         */

        // langkah 4
        /*
         * Rectangle r = new Rectangle(6, 4);
         * 
         * System.out.println("Area: " + r.area());
         * System.out.println("Perimeter: " + r.perimeter());
         */

        // langkah 5
        /* 
        Rectangle original = new Rectangle(6, 4);

        System.out.println("Area: " + original.area());

        Rectangle copy = original;
        copy.width= 10;
        System.out.println("Via original: " + original.area());
        System.out.println("Via copy: " + copy.area());
        // Rectangle empty = null;
        // System.out.println(empty.area());
        */

        // langkah 7
        /*
        Rectangle[] shapes = new Rectangle[3];
        shapes[0] = new Rectangle(6, 4);
        shapes[1] = new Rectangle(3, 3);
        shapes[2] = new Rectangle(8, 2);

        for (Rectangle r : shapes) {
            System.out.println("Area: " + r.area() + ", Perimeter: " + r.perimeter());
        }
        */

        // langkah 6
        /*
        Student s = new Student("Nadia", "S001", 3.8);
        System.out.println(s.describe());
        */
       
        // Tugas
        Circle c = new Circle(5.0);
        System.out.println("Area: " + c.area());
        System.out.println("Circumference: " + c.circumference());

    }
}