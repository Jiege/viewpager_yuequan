package com.example.yuequan2.listener;

import com.example.yuequan2.R;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

public class TabListener implements OnClickListener {
	private ViewPager viewPager = null;
	
	public TabListener(ViewPager v){
		this.viewPager = v;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.tab1:
			this.viewPager.setCurrentItem(0);
			break;
		case R.id.tab2:
			this.viewPager.setCurrentItem(1);
			break;
		case R.id.tab3:
			this.viewPager.setCurrentItem(2);
			break;
		case R.id.tab4:
			this.viewPager.setCurrentItem(3);
			break;
		case R.id.tab5:
			this.viewPager.setCurrentItem(4);
			break;
		}
	}

}
