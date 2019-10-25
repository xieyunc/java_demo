//奔驰汽车
class Benz implements ICar {
    String color = "黑色"; //颜色

    @Override
    public String getName() {
        return color+"奔驰";
    }

    @Override
    public double getPrice() {
        double price = 300000.00; //车价
        if (color.equals("红色"))
            price += 10000.00; //红色加价1万

        return price;
    }

    Benz(String color) {
        this.color = color;
    }

}
