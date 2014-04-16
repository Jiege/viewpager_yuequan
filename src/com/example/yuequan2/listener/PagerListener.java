package com.example.yuequan2.listener;

import java.util.ArrayList;

import android.graphics.Matrix;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;

public class PagerListener implements OnPageChangeListener {

	private ArrayList<View> tabArray = null;
    private ImageView activeBar = null;
    private int offset;
    private int imageWidth;
    
    private final static String TAG = "PagerListener";
    
    public PagerListener(ArrayList<View> tabArray, ImageView activeBar, int offset, int iw) {
        this.tabArray = tabArray;
        this.activeBar = activeBar;
        this.offset = offset;
        this.imageWidth = iw;
    }
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		  
        //newһ������
        Matrix matrix = new Matrix();
        
        //���ü�����������λ��
        switch (arg0) {
        case 0:
            //ʹ��setֱ�����õ��Ǹ�λ��
            matrix.setTranslate(this.offset, 0);
            break;
        case 1:
            matrix.setTranslate(this.offset * 3 + this.imageWidth, 0);
            break;
        case 2:
            matrix.setTranslate(this.offset * 5 + this.imageWidth * 2, 0);
            break;
        case 3:
            matrix.setTranslate(this.offset * 7 + this.imageWidth * 3, 0);
            break;
        case 4:
            matrix.setTranslate(this.offset * 9 + this.imageWidth * 4, 0);
            break;
            
        }
        //�ڻ����Ĺ����У������������Ӧ��Ҫ�����ľ���
        float t = (this.offset * 2 + this.imageWidth) * arg1;
        
        //ʹ��post׷����ֵ
        matrix.postTranslate(t, 0);
        
        this.activeBar.setImageMatrix(matrix);

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

        for(View item:this.tabArray){
        	item.setSelected(false);
        }
        this.tabArray.get(arg0).setSelected(true);
	}

}
