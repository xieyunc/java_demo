public class CarTest {
    public static void main(String[] args) {

        CarShop aShop = new CarShop("九江汽车商行");

        aShop.sellCar(new Benz("红色"));
        aShop.sellCar(new Benz("银色"));
        aShop.sellCar(new Geely("白色"));

        System.out.printf("%s总销量：%d台，销售额：￥%,.2f元\n",aShop.getShopName(),aShop.getCount(),aShop.getMoney());
        System.out.println("----------------------------------------------");

        CarShop bShop = new CarShop("南昌奔驰4S店");
        bShop.sellCar(new Benz("红色"));
        bShop.sellCar(new Benz("红色"));
        bShop.sellCar(new Benz("白色"));
        bShop.sellCar(new Benz("黑色"));

        System.out.printf("%s总销量：%d台，销售额：￥%,.2f元\n",bShop.getShopName(),bShop.getCount(),bShop.getMoney());
        System.out.println("----------------------------------------------");

        CarShop cShop = new CarShop("赣州吉利4S店");
        cShop.sellCar(new Geely("红色"));
        cShop.sellCar(new Geely("黑色"));
        System.out.printf("%s总销量：%d台，销售额：￥%,.2f元\n",cShop.getShopName(),cShop.getCount(),cShop.getMoney());

    }
}
