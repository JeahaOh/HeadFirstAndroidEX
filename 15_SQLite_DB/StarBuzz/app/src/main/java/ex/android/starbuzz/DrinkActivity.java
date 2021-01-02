package ex.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {

    public static String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //  인텐트에서 음료 정보 얻기
        int drinkId = (Integer) getIntent().getExtras().get( EXTRA_DRINKID );
        //  drinkId로 사용자가 선택한 음료의 상세 정보를 가져옴
        Drink drink = Drink.drinks[drinkId];

        //  음료 이름 가져오기
        TextView name = findViewById(R.id.name);
        name.setText( drink.getName() );

        //  음료 설명 가져오기
        TextView description = findViewById(R.id.description);
        description.setText( drink.getDescription() );

        //  음료 이미지 가져오기
        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId() );
        photo.setContentDescription( drink.getName() );
    }
}
