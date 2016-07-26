package com.example.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	 private ViewPager adviewpager;
	 private LinearLayout pageLayout;
	 private List<View> pageViews;
	 private ImageView[] imageViews;
	 private ImageView imageView;
	 private boolean isContinue=true;
	 private AtomicInteger atomicInteger=new AtomicInteger(0);	 
	 private myPageAdapter mypageadapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPageView();
       
    }
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void initPageView()
    {
     pageLayout=(LinearLayout) findViewById(R.id.view_pager_content);
     adviewpager=new ViewPager(this);
     
     DisplayMetrics dm=new DisplayMetrics();
     getWindowManager().getDefaultDisplay().getMetrics(dm);
     
     adviewpager.setLayoutParams(new LayoutParams(dm.widthPixels,dm.heightPixels*2/5));
     
     pageLayout.addView(adviewpager);
     
     initPageAdapter();
     initCirclePoint();
     mypageadapter=new myPageAdapter(pageViews);
     adviewpager.setAdapter(mypageadapter);
     adviewpager.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO 自动生成的方法存根
			
		   atomicInteger.getAndSet(arg0);//将AtomicInteger设置为给定值
	       for(int i=0;i<imageViews.length-1;i++)
	       {
	    	  imageViews[arg0].setBackgroundResource(R.drawable.point_focused);
	    	  if(arg0!=i)
	    		  imageViews[i].setBackgroundResource(R.drawable.point_unfocused); 
	       }
  		
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO 自动生成的方法存根
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO 自动生成的方法存根
			
		}
	});
     
     new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO 自动生成的方法存根
		  	while(true)
		  	{
		  		if(isContinue)
		  		{
		  		  myViewHandler.sendEmptyMessage(atomicInteger.get());
		  		  atomicOption();
		  			
		  		}

		  	}
	
		}
	}).start();
	
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final Handler myViewHandler=new Handler(){
      @Override
      	public void handleMessage(Message msg) {
      		// TODO 自动生成的方法存根
      	  adviewpager.setCurrentItem(msg.what);
    	  
    	  super.handleMessage(msg);
      	}	
 
    };

//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   private void atomicOption()
   {
      atomicInteger.incrementAndGet();
      if(atomicInteger.get()>imageViews.length-1)
      {
    	  atomicInteger.getAndAdd(-5);    	  
      }
	   
	   try{
		  
		   Thread.sleep(3000); 
		   
	   }catch(InterruptedException e)
	   {
		   
	   }
  
   }
  
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void initPageAdapter()
    {
      pageViews=new ArrayList<View>();
      
      ImageView im1=new ImageView(this);
      im1.setBackgroundResource(R.drawable.view_add_1);
      pageViews.add(im1);
      
      ImageView im2=new ImageView(this);
      im2.setBackgroundResource(R.drawable.view_add_2);
      pageViews.add(im2);
      
      ImageView im3=new ImageView(this);
      im3.setBackgroundResource(R.drawable.view_add_3);
      pageViews.add(im3);
      
      ImageView im4=new ImageView(this);
      im4.setBackgroundResource(R.drawable.view_add_4);
      pageViews.add(im4);
      
      ImageView im5=new ImageView(this);
      im5.setBackgroundResource(R.drawable.view_add_5);
      pageViews.add(im5);
      
      ImageView im6=new ImageView(this);
      im6.setBackgroundResource(R.drawable.view_add_6);
      pageViews.add(im6);
    	
    }
    
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   private void initCirclePoint()
   {
	  ViewGroup viewgroup=(ViewGroup) findViewById(R.id.ViewGroup);
	  imageViews=new ImageView[pageViews.size()];
	  
	  for(int i=0;i<pageViews.size();i++)
	  {
		 imageView=new ImageView(this);
		 imageView.setLayoutParams(new LayoutParams(10,10));
		 imageViews[i]=imageView;
		 
		 if(i==0)
		 {
			 imageViews[i].setBackgroundResource(R.drawable.point_focused);
			 
		 }else{
			 imageViews[i].setBackgroundResource(R.drawable.point_unfocused);
			 
		 }
		  
		viewgroup.addView(imageViews[i]);  
	  }
	 
   }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
         
        return true;
    }
    
}
