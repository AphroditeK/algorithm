package sort.heapSort;

import java.util.Comparator;

import org.junit.Test;

import util.SortHelper;
import util.Timer;

public class TestDemo {
	
	@Test
	public void testHeap(){
		Comparator<Integer> compatator = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2){
					return 1;
				}else if(o1 < o2){
					return -1;
				}
				return 0;
			}
		};
		MaxHeap<Integer> heap = new MaxHeap<Integer>(compatator);
		heap.insert(10);
		heap.insert(8);
		heap.insert(9);
		heap.insert(3);
		heap.insert(6);
		heap.insert(96);
		heap.insert(53);
		heap.extractMax();
		
		while(!heap.isEmpty()){
			System.out.println(heap.extractMax());
		}
		
	}
	
	@Test
	public void testHeapSort(){
		int n = 100000;
		Integer[] arr = SortHelper.autoArr(n, 0, n);
//		SortHelper.printResult(arr);
//		new HeapSort().doSort(arr, n);
		Long time = Timer.timeMillisTimer(sort.heapSort.HeapSort.class, "doSort1", arr,n);
		System.out.println(time);
//		SortHelper.printResult(arr);
	}
	
	@Test
	public void testHeapSort2(){
		int n = 100000;
		Integer[] arr = SortHelper.autoArr(n, 0, n);
//		SortHelper.printResult(arr);
//		new HeapSort().doSort2(arr, n);
		Long time = Timer.timeMillisTimer(sort.heapSort.HeapSort.class, "doSort2", arr,n);
		System.out.println(time);
//		SortHelper.printResult(arr);
	}
	
	@Test
	public void testHeapSort3(){
		int n = 10;
		Integer[] arr = SortHelper.autoArr(n, 0, n);
		SortHelper.printResult(arr);
		new HeapSort().doSort3(arr, n);
		Long time = Timer.timeMillisTimer(sort.heapSort.HeapSort.class, "doSort3", arr,n);
		System.out.println(time);
		SortHelper.printResult(arr);
	}
	
	@Test
	public void testIndexHeap(){
		Comparator<Integer> compatator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2){
					return 1;
				}else if(o1 < o2){
					return -1;
				}
				return 0;
			}
		};
		IndexMaxHeap<Integer> heap = new IndexMaxHeap<Integer>(compatator);
		heap.insert(10);
		heap.insert(8);
		heap.insert(9);
		heap.insert(3);
		heap.insert(6);
		heap.insert(96);
		System.out.println(heap);
		for (int i : heap.getIndexes()) {
			System.out.print(i+" ");
		}
	}
	
}
