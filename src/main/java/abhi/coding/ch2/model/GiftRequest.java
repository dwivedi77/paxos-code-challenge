package abhi.coding.ch2.model;

/**
 * Created by Abhishek on 4/7/2019.
 */
public class GiftRequest {
    public GiftRequest() {
    }

    String[] items;
    Integer[] prices;
    int giftCard;

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public Integer[] getPrices() {
        return prices;
    }

    public void setPrices(Integer[] prices) {
        this.prices = prices;
    }

    public int getGiftCard() {
        return giftCard;
    }

    public void setGiftCard(int giftCard) {
        this.giftCard = giftCard;
    }
}
