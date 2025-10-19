package problems;

public class Test {

    static void getAreaTest(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        getAreaTest(rc);

        // Violation of Liskov Substitution Principle [Because this design changes the behavior of the program]
        Rectangle sq = new Square();
        sq.setWidth(5);
        getAreaTest(sq);
    }
}
