package sort;

import org.junit.Test;

import util.Timer;

public class TestDemo {
	
	@Test
	public void testSelect() {
		int n = 100000;
		Integer[] arr1 = SortHelper.autoArr(n, 0, 60000);
		Long time1 = Timer.timeMillisTimer(sort.SelectSort.class, "doSort2", arr1,n);
		Integer[] arr2 = SortHelper.autoArr(n, 0, 60000);
		Long time2 = Timer.timeMillisTimer(sort.SelectSort.class, "doSort1", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	@Test
	public void testInsert(){
		int n = 100000;
		Integer[] arr1 = SortHelper.autoArr(n, 0, n);
		Integer[] arr2 = arr1;
//		new InsertSort().doSort2(arr1, n);
//		for (Integer integer : arr1) {
//			System.out.println(integer);
//		}
		Long time1 = Timer.timeMillisTimer(sort.InsertSort.class, "doSort1", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.InsertSort.class, "doSort2", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	
	@Test
	public void testBubble(){
		int n = 10000;
		Integer[] arr1 =SortHelper.autoArr(n, 0, n);
		Integer[] arr2 = SortHelper.copyArr(arr1, n);
		System.out.println(arr1);
		System.out.println(arr2);
		Long time1 = Timer.timeMillisTimer(sort.BubbleSort.class, "doSort1", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.BubbleSort.class, "doSort2", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
}
