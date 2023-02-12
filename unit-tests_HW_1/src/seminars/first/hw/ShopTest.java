package seminars.first.hw;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    public static void main(String[] args) {

        List<Product> foodBasket = new ArrayList<>();
        fillFoodBasket(foodBasket); // заполнение корзины

        Shop myShop = new Shop();
        myShop.setProducts(foodBasket); // добавление корзины в магазин

        checkExpensiveProduct(myShop.getMostExpensiveProduct()); // проверка что магазин возвращает верный самый дорогой продукт
        checkBaskin(myShop); // проверка корзины

        myShop.getSortedListProducts(); //сортировка
        checkSortBaskin(myShop); // проверка работы сортировки

    }

    public static void fillFoodBasket(List<Product> basket) { // наполнение корзины
        Product milk32 = new Product();
        milk32.setCost(50);
        milk32.setTitle("milk 3,2");
        basket.add(milk32);
        Product coffee = new Product();
        coffee.setCost(150);
        coffee.setTitle("ground coffee");
        basket.add(coffee);
        Product sugar = new Product();
        sugar.setCost(15);
        sugar.setTitle("cane sugar");
        basket.add(sugar);
    }

    // 1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
    public static void checkBaskin(Shop shop) {
        assertThat(shop.getProducts())
                .isNotEmpty()
                .hasSize(3)
                .doesNotHaveDuplicates();
        int sizeShop = shop.getProducts().size();
        for (int item = 0; item < sizeShop; item++) {
            assertThat(shop.getProducts().get(item).getTitle()).containsAnyOf("ground coffee", "milk 3,2", "cane sugar");
        }
    }

    // 2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
    public static void checkExpensiveProduct(Product product) {
        assertThat(product.getCost()).isEqualTo(150);
    }

    // 3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    public static void checkSortBaskin(Shop shop) {
        int sizeShop = shop.getProducts().size();
        for (int item = 0; item < sizeShop - 1; item++) {
            assertThat(shop.getProducts().get(item + 1).getCost() >= shop.getProducts().get(item).getCost())
                    .as("цена позиции " + (item + 1) + " больше цены позиции " + (item + 2))
                    .isTrue();
        }
    }
}






