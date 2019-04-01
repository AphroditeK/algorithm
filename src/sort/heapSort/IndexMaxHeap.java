package sort.heapSort;

import java.util.Comparator;

/**
 * 索引堆，将数据与索引分开处理，解决普通堆的几个问题
 * 1.堆中数据类型很复杂，不利于移动的问题（交换位置十分消耗性能）
 * 2.数据与原先的索引经过堆化（heapify）之后就丧失了原先的关联性
 * 3.由于索引对应的数据堆化后变动了，那么想要通过索引来取出元素就不可能了
 * 即要定位一个数据元素会变得非常复杂
 * @author asus
 */
public class IndexMaxHeap<T> {
	
	private T[] data;
	private int count; 
	private int[] indexes;
	private Comparator<T> comparator;
	private int capacity = 10;
	
	@SuppressWarnings("unchecked")
	public IndexMaxHeap(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
		this.data = (T[]) new Object[this.capacity+1];
		this.indexes = new int[this.capacity+1];
		this.count = 0;
	}
	
	@SuppressWarnings("unchecked")
	public IndexMaxHeap(Comparator<T> comparator,int capacity) {
		super();
		this.comparator = comparator;
		this.capacity = capacity;
		this.data = (T[]) new Object[this.capacity+1];
		this.indexes = new int[this.capacity+1];
		this.count = 0;
	}
	
	//未完善
	@SuppressWarnings("unchecked")
	public IndexMaxHeap(Comparator<T> comparator,T[] arr) {
		super();
		this.comparator = comparator;
		this.capacity = arr.length;
		this.data = (T[]) new Object[this.capacity+1];
		this.indexes = new int[this.capacity+1];
		this.count = arr.length;
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean isEmpty() {
		if(this.count == 0){
			return true;
		}
		return false;
	}
	
	public void insert(T t){
		this.count += 1;
		int i = count;
		if(i > this.capacity){
			//扩容data
			//扩容index
		}
		this.data[i] = t;
		this.indexes[i] = i;
		__shiftUp(i);
	}

	private void __shiftUp(int i) {
		
		while(i > 1){
			int r1 = comparator.compare( data[indexes[(i>>1)]] , data[indexes[i]] );
			if( r1 >= 0){
				break;
			}else{
				int temp = indexes[i];
				indexes[i] = indexes[i>>1];
				indexes[i>>1] = temp;
				i = (i>>1);
			}
		}
		
	}
	
	public T extractMax(){
		T max = data[indexes[1]];
		data[indexes[1]] = data[indexes[count]];
		indexes[1] = indexes[count];
		count -=1;
		shiftDown(1);
		return max;
	}
	
	private void shiftDown(int i) {
		
		while((i<<1) <= count){
			int k = i<<1;
			if(k+1 <= count){
				int r1 = comparator.compare(data[indexes[k]], data[indexes[k+1]]);
				if(r1 < 0){
					k += 1;
				}
			}
			if( comparator.compare(data[indexes[i]], data[indexes[k]]) >= 0){
				break;
			}
			int temp = indexes[i];
			indexes[i] = indexes[k];
			indexes[k] = temp;	
			i = k;
		}
		
	}

	public int[] getIndexes() {
		return indexes;
	}
	
}
