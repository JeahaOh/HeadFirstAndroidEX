package ex.android.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        /** 배열 어댑터로 리스트 뷰와 배열 연결하기
         *  배열 어댑터를 초기화한 다음 리스트 뷰에 연결할 수 있음.
         *  배열 어댑터를 초기화하려면 리스트 뷰에 연결하려는 배열에 어떤 종류의 데이터가 포함될지 지정해야 함.
         *  배열 어댑터에는 Context(보통 현재 액치비티를 가리킴),
         *  배열의 각 항목을 어떻게 표시할지 지정하는 레이아웃 리소스, 그리고 배열 자신 이렇게 세 개의 인자를 사용할 수 있음.
         *
         *  다음은 Drinks.drinks 배열의 음료 데이터를 표시하는 배열 어댑터를 생성하는 코드임
         */
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                //  현재 액티비티를 가리킴
                this,
                //  내장 레이아웃 리소스. 배열의 각 항목을 한 개의 텍스트 뷰료 표시하라고 배열 어댑터에 지시함.
                android.R.layout.simple_list_item_1,
                //  배열
                Drink.drinks
        );

        //  ListView의 setAdapter메소드로 배열 어댑터를 리스트 뷰에 연결함
        ListView listDrinks = findViewById(R.id.list_drinks);
        listDrinks.setAdapter( listAdapter );

        //  리스너 생성
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener () {
                    public void onItemClick( AdapterView<?> listDrinks,
                                             View itemView,
                                             int position,
                                             long id ) {
                        //  사용자가 클릭한 음료를 DrinkActivity로 전달
                        //  사용자가 음료를 클릭하면 해당 항목의 ID를 DrinkActivity로 넘겨주면서 Activity를 시작
                        Intent intent = new Intent( DrinkCategoryActivity.this,
                                                    DrinkActivity.class );
                        intent.putExtra( DrinkActivity.EXTRA_DRINKID, (int) id );
                        startActivity( intent );
                    }
                };
        //  리스너를 리스트 뷰에 할당
        listDrinks.setOnItemClickListener( itemClickListener );
    }
}




