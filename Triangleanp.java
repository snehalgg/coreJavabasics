class Triangle {
    double s1;
    double s2;
    double s3;
    Triangle(double s1, double s2, double s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    double getArea() {
        double s = (s1 + s2 + s3) / 2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }
    double getPerimeter() {
        return s1 + s2 + s3;
    }
}

 class Triangleanp {
    public static void main(String[] args) {
        double s1 = 3;
        double s2 = 4;
        double s3 = 5;
        Triangle triangle = new Triangle(s1, s2, s3);
        System.out.println("Area of the triangle: " + triangle.getArea());
        System.out.println("Perimeter of the triangle: " + triangle.getPerimeter());
    }
}
