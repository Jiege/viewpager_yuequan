package com.example.yuequan2;

import java.util.ArrayList;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.yuequan2.adapter.FragmentAdapter;
import com.example.yuequan2.fragment.Fragment1;
import com.example.yuequan2.fragment.Fragment2;
import com.example.yuequan2.fragment.Fragment3;
import com.example.yuequan2.fragment.Fragment4;
import com.example.yuequan2.fragment.Fragment5;
import com.example.yuequan2.listener.PagerListener;
import com.example.yuequan2.listener.TabListener;

public class MainActivity extends ActionBarActivity {

    private ViewPager viewPager = null;
    
    private View tab1 = null;
    private View tab2 = null;
    private View tab3 = null;
    private View tab4 = null;
    private View tab5 = null;
    private ArrayList<View> tabArray = null;
    
    //激活条
    private ImageView activeBar = null;
    private int offset;
    private int imageWidth;
    
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.activeBar = (ImageView)this.findViewById(R.id.active_bar);
        
        this.imageWidth = BitmapFactory.decodeResource(getResources(), R.drawable.bar).getWidth();
        
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        
        this.offset = (screenWidth / 5 - imageWidth) / 2;
        
        this.initViewPager();
        this.initTab();
        this.setListener();
        this.tabArray.get(0).setSelected(true);
    }


    private void setListener() {
		// TODO Auto-generated method stub
     TabListener tabl = new TabListener(this.viewPager);
     
     this.tab1.setOnClickListener(tabl);
     this.tab2.setOnClickListener(tabl);
     this.tab3.setOnClickListener(tabl);
     this.tab4.setOnClickListener(tabl);
     this.tab5.setOnClickListener(tabl);

     this.viewPager.setOnPageChangeListener(new PagerListener(this.tabArray, this.activeBar, this.offset, this.imageWidth));
	}


	private void initTab() {
		// TODO Auto-generated method stub
		this.tab1 = this.findViewById(R.id.tab1);
		this.tab2 = this.findViewById(R.id.tab2);
		this.tab3 = this.findViewById(R.id.tab3);
		this.tab4 = this.findViewById(R.id.tab4);
		this.tab5 = this.findViewById(R.id.tab5);
		
		this.tabArray = new ArrayList<View>();
		this.tabArray.add(tab1);
		this.tabArray.add(tab2);
		this.tabArray.add(tab3);
		this.tabArray.add(tab4);
		this.tabArray.add(tab5);
	}


	private void initViewPager() {
    	//获取到ViewPager的实例
        this.viewPager  = (ViewPager)findViewById(R.id.viewpager);
        
        //构造好存放Fragment的数组
        ArrayList<Fragment> fragmentArray = new ArrayList<Fragment>();
        fragmentArray.add(new Fragment1());
        fragmentArray.add(new Fragment2());
        fragmentArray.add(new Fragment3());
        fragmentArray.add(new Fragment4());
        fragmentArray.add(new Fragment5());
        
        //为ViewPager设置适配器
        this.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentArray));
        
        //设置当前显示的页面
        this.viewPager.setCurrentItem(0);
        
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    

}
