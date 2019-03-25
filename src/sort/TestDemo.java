package sort;

import org.junit.Test;

import sort.generateSort.ShellSort;
import sort.higherSort.MergeSort1;
import sort.higherSort.MergeSort2;
import sort.higherSort.QuickSort1;
import sort.higherSort.QuickSort2;
import util.Timer;

public class TestDemo {
	
	@Test
	public void testSelect() {
		int n = 100000;
		Integer[] arr1 = SortHelper.autoArr(n, 0, 60000);
		Long time1 = Timer.timeMillisTimer(sort.generateSort.SelectSort.class, "doSort2", arr1,n);
		Integer[] arr2 = SortHelper.autoArr(n, 0, 60000);
		Long time2 = Timer.timeMillisTimer(sort.generateSort.SelectSort.class, "doSort1", arr2,n);
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
		Long time1 = Timer.timeMillisTimer(sort.generateSort.InsertSort.class, "doSort1", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.generateSort.InsertSort.class, "doSort2", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	@Test
	public void testBubble(){
		int n = 10000;
//		Integer[] arr = SortHelper.autoArr(n, 0, n);
//		new BubbleSort().doSort3(arr, n);
		Integer[] arr1 =SortHelper.autoNearlyOrderedArr(n,20);
		Integer[] arr2 = SortHelper.copyArr(arr1, n);
		System.out.println(arr1);
		System.out.println(arr2);
		Long time1 = Timer.timeMillisTimer(sort.generateSort.BubbleSort.class, "doSort1", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.generateSort.BubbleSort.class, "doSort2", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	@Test
	public void  testShell() {
		int n = 20;
		Integer[] arr = SortHelper.autoArr(n, 0, n);
		SortHelper.printResult(arr);
		new ShellSort().doSort(arr);
		SortHelper.printResult(arr);
	}

	@Test
	public void testMerge(){
		int n = 10;
		Integer[] arr = SortHelper.autoArr(n, 0, n);
		SortHelper.printResult(arr);
		new MergeSort1().doSort(arr, n);
		SortHelper.printResult(arr);
	}
	
	@Test
	public void testMerge2(){
		int n = 1000100;
		Integer[] arr1 = SortHelper.autoArr(n, 0, n);
//		SortHelper.printResult(arr);
//		new MergeSort2().doSort(arr, n);
//		SortHelper.printResult(arr);
		
		Integer[] arr2 = SortHelper.copyArr(arr1, n);
		System.out.println(arr1);
		System.out.println(arr2);
		Long time1 = Timer.timeMillisTimer(sort.higherSort.MergeSort1.class, "doSort", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.higherSort.MergeSort2.class, "doSort", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	@Test
	public void testQuick(){
		int n = 1000000;
//		Integer[] arr1 = SortHelper.autoNearlyOrderedArr(n, 10);
		//数列存在很多等值的元素
		Integer[] arr1 = SortHelper.autoArr(n, 0,10);
//		SortHelper.printResult(arr);
//		new QuickSort().doSort(arr, n);
//		SortHelper.printResult(arr);
		
		Integer[] arr2 = SortHelper.copyArr(arr1, n);
		System.out.println(arr1);
		System.out.println(arr2);
		Long time1 = Timer.timeMillisTimer(sort.higherSort.MergeSort1.class, "doSort", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.higherSort.QuickSort1.class, "doSort", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	@Test
	public void testQuick2(){
		int n = 200000;
//		Integer[] arr1 = SortHelper.autoArr(n, 0,3);
//		SortHelper.printResult(arr1);
//		new QuickSort2().doSort(arr1, n);
//		SortHelper.printResult(arr1);
		
		
//		Integer[] arr1 = SortHelper.autoNearlyOrderedArr(n, 10);
		Integer[] arr1 = SortHelper.autoArr(n, 0,10);
		Integer[] arr2 = SortHelper.copyArr(arr1, n);
		System.out.println(arr1);
		System.out.println(arr2);
		Long time1 = Timer.timeMillisTimer(sort.higherSort.MergeSort1.class, "doSort", arr1,n);
		Long time2 = Timer.timeMillisTimer(sort.higherSort.QuickSort2.class, "doSort", arr2,n);
		System.out.println(time1);
		System.out.println(time2);
	}
	
	public static void main(String[] args) {
		int d = 11;
		d = d>>1;
		System.out.println(d);
	}
	
}
