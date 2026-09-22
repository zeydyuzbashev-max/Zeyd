package coursemanagement;

public class Course {

    private String name;
    private double price;
    private int quota;

    public Course(String name, double price, int quota) {
        this.name = name;
        this.price = price;
        this.quota = quota;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuota() {
        return quota;
    }

    public void decreaseQuota() {
        quota--;
    }

    @Override
    public String toString() {
        return name + " | " + price + " AZN | Quota: " + quota;
    }
}