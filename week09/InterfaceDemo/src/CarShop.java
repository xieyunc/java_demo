//汽车销售店
class CarShop {
    private String shopName; //店名
    private int count = 0; //销售数量
    private double money = 0.00; //销售金额

    public String getShopName() {
        return shopName;
    }

    double getMoney() {
        return money;
    }

    int getCount() {
        return count;
    }

    CarShop(String shopName) {
        this.shopName = shopName;
    }

    //销售汽车
    void sellCar(ICar car) {
        System.out.println(String.format("%s售出%s1台,单价￥%,.2f元",shopName,car.getName(),car.getPrice()));
        count ++;
        money += car.getPrice();
    }
}
