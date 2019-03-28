package sort.heapSort;

import java.util.Comparator;

/**
 * heapSOrt-堆排序（O(nlogn)）
 * 即利用堆的特性对数据进行排序
 * 理解了堆的概念之后就是很容易实现的
 * @author asus
 */
public class HeapSort {
	
	//方便起见就不再使用泛型了，直接使用int类型
	public void doSort1(Integer[] arr,Integer n){
		Comparator<Integer> comparator = new Comparator<Integer>() {
			
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
		MaxHeap<Integer> heap = new MaxHeap<>(comparator,n);
		//排序的过程就是先放进堆结构中，再一个个从堆结构中拿出来
		for(int i = 0;i<n;i++){
			heap.insert(arr[i]);
		}
		//由此我们还可以很轻易地实现由小到大的排序，只要倒序的给arr[j]赋值，就可以实现从小到大
		for(int j = 0;j<n;j++){
			arr[j] = heap.extractMax();
		}
	}
	
	//用数组快速实现堆比一个个插入堆中的方法要快很多
	//一个个插入的（O(nlogn)）
	//快速实现的（O(n)）
	public void doSort2(Integer[] arr,Integer n) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
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
		//利用数组快速创建堆
		MaxHeap<Integer> heap = new MaxHeap<>(comparator,arr);
		for(int j = 0;j<n;j++){
			arr[j] = heap.extractMax();
		}
	}

	//直接在数组上进行堆操作，不再开辟新的对空间再操作
	public void doSort3(Integer[] arr,Integer n){
		//参照数组初始化堆的方法，直接把数组变成意义上的堆结构
		//这里变成了一个最大堆
		for(int i = ((n-1)>>1); i>=0; i--){
			__shiftDown(arr, n,i);
		}
		//模仿堆出列的过程
		//即第一个肯定是最大的，把它赋给arr[n-1]
		//剩下部分再做堆整理（即最后节点放到了根节点位置，对它执行下放操作）
		for(int i = n-1; i>0; i--){
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			__shiftDown(arr, i, 0);
		}
		
	}
	
	private void __shiftDown(Integer[] arr,int n,int k){
		int temp = 0;
		while((k<<1)+1 < n){
			//在此轮循环中，data[i]与data[j]，先让j为i的左儿子
			int j = (k<<1)+1;
			//判断如果已经比所在位置的子节点都大了，就跳出循环，完成了排序
			//1.先判断有无右儿子，有就比较左右儿子大小，取大的为j
			if(j+1 < n && arr[j+1] > arr[j]){
				j = j+1;
			}
			//2.比较大的儿子节点与父节点谁大，父节点大即该位置已合适，跳出循环
			if( arr[k] >= arr[j]){
				break;
			}
			//3.交换i与j位置，完成一轮下放的动作
			temp = arr[j];
			arr[j] = arr[k];
			arr[k] = temp;
			k = j;
		}
	}
	
	
}
