package by.academy.Deal;

public class Shop {

    private static int count = 15;
    private final static Product[] products = new Product[15];
    public final static String [] menu = new String[3];

    static {
        products[0] = new Bread(7, "BaguetteBread", "white", "Baguette", false, 5, 0);
        products[1] = new Bread(8, "BriocheBread", "white", "Brioche", false, 5,0);
        products[2] = new Bread(9, "CiabattaBread", "white", "Ciabatta", false, 5,0);
        products[3] = new Bread(10, "FocacciaBread", "white","Focaccia" ,false , 5,0);
        products[4] = new Bread(11, "MultigrainBread", "dark", "Multigrain",true ,5,0 );
        products[5] = new Vine(25, "La Rogue", "France", 0.75,"red" ,5,0 );
        products[6] = new Vine(26, "Rully Blanc", "France", 0.75,"white" ,5,0 );
        products[7] = new Vine(27, "Jaume Serra", "Spain", 0.75, "champagne", 5,0);
        products[8] = new Vine(28, "Dornfelder", "Germany",0.5 ,"red" ,5,0 );
        products[9] = new Vine(29, "The spitz", "Italy",0.75 ,"aperitif" , 5,0);
        products[10] = new Cheese(9.5, "My mascarpone", 0.2, "Italy", "mascarpone", 5,0);
        products[11] = new Cheese(7.8, "Gouda", 0.25, "Germany", "gouda", 5,0);
        products[12] = new Cheese(3.7, "FetaFresh", 0.3, "Belarus", "feta", 5,0);
        products[13] = new Cheese(10, "Parmezan", 0.2, "Italy", "parmezan", 5,0);
        products[14] = new Cheese(11, "Dor Blue", 0.3, "France", "blue",5,0 );
    }
    static {
        menu[0] = "Вас преветствует интернет магазин DEAL." +
                "\n\nДля перехода в меню продуктов нажмите 1 \nДля выхода из программы нажмите 2" +
                "\n------------------------------------------------------";
        menu[1] = "Выберите действие: " +
                "\n0 - Перечень продуктов реализуемых в магазине" +
                "\n1 - Добавить продукт в козину" +
                "\n2 - Удалить продукт из корзины" +
                "\n3 - Просмотр корзины" +
                "\n4 - Подсчет корзины" +
                "\n5 - Выйти из приложения";
        menu[2] = "Спасибо что выбрали наш магазин. До новых покупок!";
    }

    public static void getMenu(int index){
        System.out.println(menu[index]);
    }

    public static void reduceQuantity(int productID, int quantity) {
        if (products[productID].shopQuantity != 0){
            if (products[productID].shopQuantity >= quantity){
                products[productID].shopQuantity -= quantity;
            } else {
                System.out.println("К сожалению нет такого количества" +
                        "\n------------------------------------------------------");
            }
        }
        if (products[productID].shopQuantity == 0){
            System.arraycopy(products, productID+1, products, productID, (products.length-productID) - 1);
            products[products.length-1] = null;
            count--;
        }
    }

    public static void increaseQuantity(Product product, int quantity) {

        if (count < 15){
            products[count] = product;
            products[count].shopQuantity += quantity;
            count++;
        } else {
            for(Product n: products){
                if (n.equals(product)) {
                    n.shopQuantity += quantity;
                    break;
                }
            }
        }
    }

    public static Product getProduct(int productID) {
        return products[productID];
    }

    public static void showProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                break;
            } else {
                System.out.println(i + ". " + products[i].toString() + ", quantity = " + products[i].shopQuantity);
            }
        }
    }
}