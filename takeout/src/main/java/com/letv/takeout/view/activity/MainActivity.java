package com.letv.takeout.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.letv.takeout.R;
import com.letv.takeout.view.MainAdapter;
import com.letv.takeout.view.utils.MyUtils;


/**
 * Created by 10198 on 2017/6/14.
 */

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] arrayTitles;
    private int IconImg[] = {R.drawable.home, R.drawable.order, R.drawable.me, R.drawable.more,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        arrayTitles = getResources().getStringArray(R.array.tab_title);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), arrayTitles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.getTabAt(0).select(); 默认选中的第一项
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(IconImg[i]);
        }
    }

    private long exitTime = 0l;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                exitTime = System.currentTimeMillis();
                MyUtils.showToast(this,"再按一次退出程序",Toast.LENGTH_SHORT);
                return false;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyUtils.mToast.cancel();
    }
}
