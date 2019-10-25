//吉利汽车
class Geely implements ICar {
    String color = "黑色"; //颜色

    @Override
    public String getName() {
        return color+"吉利";
    }

    @Override
    public double getPrice() {
        double price = 100000.00; //车价
        return price;
    }

    Geely(String color) {
        this.color = color;
    }

}
