package OOP.Polymorphism_Exercise.E03_WildFarm.Foods;

public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        setQuantity(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
