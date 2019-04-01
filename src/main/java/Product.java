public class Product {

    String type;
    Integer discount;

    public Product() {
        this.type = type;
        this.discount = discount;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", discount=" + discount +
                '}';
    }
}
