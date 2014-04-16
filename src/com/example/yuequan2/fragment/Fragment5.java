package com.example.yuequan2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.yuequan2.R;

public class Fragment5 extends Fragment {
	private View layout = null;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        this.layout = inflater.inflate(R.layout.layout_topic, null);
	        
	        //从这里到return之间，你可以为这个Fragment添加其功能。
	        Button b = (Button)this.layout.findViewById(R.id.button1);
	        b.setOnClickListener(new ButtonListener());
	        
	        return this.layout;
	    }
	    
	    public class ButtonListener implements OnClickListener {

	        @Override
	        public void onClick(View v) {
	            
	            Toast.makeText(getActivity(), "button1", Toast.LENGTH_SHORT).show();
	        }
	    }
	
}
