package seminars.first.hw;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    // 1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
    public static void checkBaskin(Shop shop) {
        assertThat(shop.getProducts())
                .isNotEmpty()
                .hasSize(3)
                .doesNotHaveDuplicates(); // нет дубликатов
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






