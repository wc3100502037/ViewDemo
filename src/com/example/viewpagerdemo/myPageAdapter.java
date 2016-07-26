package com.example.viewpagerdemo;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class myPageAdapter extends PagerAdapter {

    private	List<View> viewList=null;
	
	public myPageAdapter(List<View> list)
	{
		this.viewList=list;
			
	}
	
	//获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
	
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO 自动生成的方法存根
		
		return arg0==arg1;
	}
	
	// PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO 自动生成的方法存根
	       ((ViewPager)container).removeView(viewList.get(position));

	}
	
    //当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可	
	@Override
	public Object instantiateItem(View container, int position) {
		// TODO 自动生成的方法存根
	  
	    ((ViewGroup)container).addView(viewList.get(position),0);
	    
	       return viewList.get(position); 
		
		
	}
	
	
}
