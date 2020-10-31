package shop.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> list=new ArrayList<Object>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		List<Object> list2=new PageModel().getDataList(list, 10, 2);
		System.out.println(list2);
	}

}
