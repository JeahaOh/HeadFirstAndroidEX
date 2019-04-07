package ex.android.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //  onClickFindBeer 버튼을 누르면 실행됨.
    public void onClickFindBeer( View view ) {
        //  텍스트 뷰의 레퍼런스를 얻음
        TextView brands = (TextView) findViewById(R.id.brands);

        //  스피너의 레퍼런스를 얻음
        Spinner color = (Spinner) findViewById(R.id.color);

        //  스피너에서 선택한 항목을 얻음
        String beerType = String.valueOf( color.getSelectedItem() );


        //  BeerExpert 클래스를 이용해서 추천 목록을 얻음.
        List<String> brandsList = expert.getBrands( beerType );

        //  리스트의 값으로 문자열을 만듦.
        StringBuilder brandsFormatted = new StringBuilder();

        for( String brand : brandsList ) {
            //  문자열로 만들어 한 행에 한 브랜드씩 출력함
            brandsFormatted.append(brand).append("\n");
        }

        //  맥주 목록 표시
        brands.setText( brandsFormatted );

    }
}
