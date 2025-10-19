package interviewAsked;

import java.util.*;

class Zoolatech {

    public static void main(String[] args) {
        // data set up
        Promotion promo1 = new Promotion(17.0, "Promo -15%");
        Promotion promo2 = new Promotion(15.0, "Promo -25%");
        Item item1 = new Item("101", 20.0, true, List.of(promo1, promo2));

        Item item2noPromo = new Item("102", 25.5, true, List.of());

        Promotion promo3 = new Promotion(70.0, "Promo -30%");
        Promotion promo4 = new Promotion(50.0, "Promo 50% Off");
        Item item3 = new Item("103", 100.0, false, List.of(promo3, promo4));

        List<Item> itemsList = List.of(item1, item2noPromo, item3);

        // call the method
        List<Item> availableItems = getAvailableItemsWithPromotions(itemsList);
        // print the result
        for (Item item : availableItems) {
            System.out.println("Item ID: " + item.getId() + ", Initial Price: " + item.getInitialPrice() +
                    ", Promotions: " + item.getPromotions().stream().map(Promotion::getPrice).toList());
        }
    }

    private static List<Item> getAvailableItemsWithPromotions(List<Item> itemsList) {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : itemsList) {
            if (item.isAvailable() && !item.getPromotions().isEmpty()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }


    public static class Item {
        private String id;
        private Double initialPrice;
        private boolean available;
        private List<Promotion> promotions;

        public Item(String id, Double initialPrice, boolean available, List<Promotion> promotions) {
            this.id = id;
            this.initialPrice = initialPrice;
            this.available = available;
            this.promotions = promotions;
        }

        public String getId() {
            return id;
        }

        public boolean isAvailable() {
            return available;
        }

        public Double getInitialPrice() {
            return initialPrice;
        }

        public List<Promotion> getPromotions() {
            return promotions;
        }

    }

    public static class Promotion {
        private Double price;
        private String promotionName;

        public Promotion(Double price, String promotionName) {
            this.price = price;
            this.promotionName = promotionName;
        }

        public Double getPrice() {
            return price;
        }

    }

}