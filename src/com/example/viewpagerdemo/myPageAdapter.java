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
	
	//��ȡҪ�����Ŀؼ��������������������Ի����Ĺ����Ϊ������ô�����Ӧ����չʾ�Ĺ��ͼƬ��ImageView����
	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
	
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO �Զ����ɵķ������
		
		return arg0==arg1;
	}
	
	// PagerAdapterֻ��������Ҫ��ʾ��ͼƬ�����������ͼƬ�����˻���ķ�Χ���ͻ���������������ͼƬ����
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO �Զ����ɵķ������
	       ((ViewPager)container).removeView(viewList.get(position));

	}
	
    //��Ҫ��ʾ��ͼƬ���Խ��л����ʱ�򣬻�����������������ʾͼƬ�ĳ�ʼ�������ǽ�Ҫ��ʾ��ImageView���뵽ViewGroup�У�Ȼ����Ϊ����ֵ���ؼ���	
	@Override
	public Object instantiateItem(View container, int position) {
		// TODO �Զ����ɵķ������
	  
	    ((ViewGroup)container).addView(viewList.get(position),0);
	    
	       return viewList.get(position); 
		
		
	}
	
	
}
