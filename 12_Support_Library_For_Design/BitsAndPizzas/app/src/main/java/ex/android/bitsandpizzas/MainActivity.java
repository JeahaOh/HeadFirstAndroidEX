package ex.android.bitsandpizzas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  툴바 레퍼런스를 가져와서 액티비티의 앱 바로 설정함
        Toolbar toolbar = ( Toolbar )findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );

        //  SectionPagerAdapter를 ViewPager에 연결
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager() );
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter( pagerAdapter );

        //  ViewPager를 TabLayout애 연결
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager( pager );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        //  메뉴 인플레이트, 아이템을 앱 바에 추가함
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider( menuItem );
        //  공유 액션으로 공유하려는 기본 텍스트
        setShareActionIntent("Want to join me for Pizza?");

        return super.onCreateOptionsMenu( menu );
    }

    private void setShareActionIntent( String text ) {
        Intent intent = new Intent( Intent.ACTION_SEND );
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        //  공유 액션 프로바이더에 기본 텍스트를 설정함.
        shareActionProvider.setShareIntent( intent );
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        switch( item.getItemId() ) {
            case R.id.action_create_order:
                //  Create Order 항목을 클릭하면 실행하는 코드
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity( intent );
                return true;
            default :
                return super.onOptionsItemSelected( item );
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter( FragmentManager fm ) {
            super( fm );
        }

        @Override
        public int getCount() {
            //  ViewPager의 페이지 수
            return 4;
        }

        @Override
        public Fragment getItem(int position ) {
            //  각 페이지에 표시할 프래그먼트
            switch( position ) {
                case 0 :
                    return new TopFragment();
                case 1 :
                    return new PizzaFragment();
                case 2 :
                    return new PastaFragment();
                case 3 :
                    return new StoresFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle( int position ) {
            switch( position ) {
                case 0 :
                    return getResources().getText(R.string.home_tab);
                case 1 :
                    return getResources().getText(R.string.pizza_tab);
                case 2 :
                    return getResources().getText(R.string.pasta_tab);
                case 3 :
                    return getResources().getText(R.string.store_tab);
            }
            return null;
        }
    }
}
