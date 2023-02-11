package seminars.first.hw;

import java.util.Arrays;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        int beginArray = 0;
        int endArray;
        endArray = this.products.size();
        Product[] tempArr = new Product[endArray];
        this.products.toArray(tempArr);
        Product temp = null;

        while (endArray > beginArray) {
            for (int i = beginArray; i < endArray - 1; i++) {
                if (tempArr[i].getCost() > tempArr[i + 1].getCost()) {
                    temp = tempArr[i + 1];
                    tempArr[i + 1] = tempArr[i];
                    tempArr[i] = temp;
                }
            }
            endArray--;
            for (int i = endArray - 1; i > beginArray; i--) {
                if (tempArr[i].getCost() < tempArr[i - 1].getCost()) {
                    temp = tempArr[i - 1];
                    tempArr[i - 1] = tempArr[i];
                    tempArr[i] = temp;
                }
            }
            beginArray++;
        }
        return this.products = Arrays.stream(tempArr).toList();

    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product currentProduct = null;
        int currentPrice = 0;
        for (Product item : this.products) {
            if (item.getCost() > currentPrice) {
                currentProduct = item;
                currentPrice = item.getCost();
            }
        }
        return currentProduct;
    }
}