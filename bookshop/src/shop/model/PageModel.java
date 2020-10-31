package shop.model;

import java.util.ArrayList;
import java.util.List;

public class PageModel {

	public List<Object> getDataList(List<?> objects, int pageSize, int pageIndex) {
		int size = objects.size();
		int pageCount = size % pageSize == 0 ? size / pageSize : (size / pageSize) + 1;
		if (pageIndex <= 0) {
			pageIndex = 1;
		} else if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		int startIndex = (pageIndex - 1) * pageSize;
		if (startIndex < size) {
			List<Object> dataList = new ArrayList<Object>();
			List<Object> dataList2 = new ArrayList<Object>();
			for (int i = 0; i < pageSize; i++) {
				if (startIndex + i == size)
					break;
				dataList2.add(objects.get(startIndex + i));
			}
			dataList.add(dataList2);
			dataList.add(pageSize);
			dataList.add(pageIndex);
			dataList.add(pageCount);
			return dataList;
		} else {
			return null;
		}
	}

}
