package org.flyants.book.view.index;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.flyants.book.R;
import org.flyants.book.custom.NavigationView;
import org.flyants.book.view.experience.ExperienceView;
import org.flyants.book.view.inspiration.InspirationView;
import org.flyants.book.view.my.MyView;
import org.flyants.common.mvp.impl.BaseFragment;
import org.flyants.common.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    List<BaseFragment> fragmentList = new ArrayList<>(5);

//    BottomNavigationView navView;
    NavigationView navView;
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_1:
//                    setTabSelection(0);
//                    return true;
//                case R.id.navigation_2:
//                    setTabSelection(1);
//                    return true;
//                case R.id.navigation_3:
//                    setTabSelection(2);
//                    return true;
//            }
//            return false;
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        navView = findViewById(R.id.nav_view);
        StatusBarUtil.setStatusBarMode(this,true,R.color.white);
//        navView.setLabelVisibilityMode(1);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setOnNavigationViewClickListener(new NavigationView.OnNavigationViewClickListener() {
            @Override
            public void onNavigationViewClickListener(int tab) {
                setTabSelection(tab);
            }
        });
        fragmentManager = getSupportFragmentManager();
        init();
        navView.setSelectedIndex(0);
    }

    private void init() {
        fragmentList.add(new ExperienceView());
        fragmentList.add(new InspirationView());
        fragmentList.add(new MyView());
//        navView.setSelectedItemId(R.id.navigation_1);
    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragmentList.get(index));
        transaction.commit();
    }

}
