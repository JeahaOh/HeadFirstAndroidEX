package ex.android.starbuzz;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    //  drinks는 세 음료읠 배열
    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino),
            new Drink("Filter", "Highest qaulity beans roasted and brewed fresh", R.drawable.filter)
    };

    //  각각의 Drinks는 이름, 설명, 이미지 리소스를가지고 있음
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
