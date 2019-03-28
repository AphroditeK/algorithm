package sort.heapSort;

import java.util.Comparator;

public class MaxHeap<T> {
	
	private T[] data;
	private int count;
	private Comparator<T> comparator;
	private int capacity = 11;
	
	/**
	 * 创建堆
	 * @param comparator 堆中相应元素类型的比较器
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(Comparator<T> comparator) {
		super();
		/**
		 * 注意：Java不支持泛型数组的创建
		 * T[] data = new T[capacity]--错误
		 * 所以使用强转的办法实现
		 */
		//这里使用下标为1开始存储数据，方便后续的结点定位
		this.data = (T[]) new Object[this.capacity];
		this.comparator = comparator;
		count = 0;
	}
	
	/**
	 * 创建堆，并初始化堆容量，这个容量不是一定的，实际需求超出改大小也是可以的
	 * @param comparator 比较器
	 * @param capacity 堆容量，给出大概的大小，有利于初始化，避免堆扩展的时间损耗，加快算法速度
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(Comparator<T> comparator,int capacity) {
		super();
		this.capacity = capacity;
		this.data = (T[]) new Object[this.capacity+1];
		this.comparator = comparator;
		count = 0;
	}
	
	/**
	 * 用已知数组创建堆，可以快速创建一个堆的方法
	 * @param comparator 比较器
	 * @param arr 对象数组
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(Comparator<T> comparator,T[] arr) {
		super();
		this.comparator = comparator;
		this.data = (T[]) new Object[arr.length+1];
		this.count = arr.length;
		for(int i = 0;i < count;i++){
			data[i+1] = arr[i];
		}
		for(int i = (count>>1); i >= 1; i--){
			shiftDown(i);
		}
	}
	
	//返回堆的大小
	public int size(){
		return this.count;
	}
	
	//判断堆是否为空
	public boolean isEmpty(){
		if(this.count == 0){
			return true;
		}
		return false;
	}
	
	//为堆添加元素,insert代表插入堆，这是一个优先队列，用插入这种说法比较合适
	public void insert(T t){
		/**
		 * 这是一个最大堆，虽然使用的是顺序存储结构
		 * 但也要符合父节点都比子节点大的最大堆原则
		 * 所以除了插入数据之外，还要为数据寻找合适的位置
		 * 所以插入操作就包含了插入数据以及排序两部分工作
		 */
		
		//插入了一个元素，堆变大1，使count指向下一个下标
		this.count = this.count + 1;
		//自动变长数组实现，使得该堆可以根据需要自动扩展存储空间
		if(this.count > this.capacity-1){
			this.capacity = this.capacity + 10;
			@SuppressWarnings("unchecked")
			T[] longData = (T[]) new Object[this.capacity];
			for (int i = 1;i < count;i++) {
				longData[i] = data[i];
			}
			this.data = longData;
		}
		//1.先把数据插入到当下data的最末
		data[count] =  t;
		//2.让该节点与之父节点比较，大于父节点则交换位置（这是不断往上的过程直到根节点的过程）
		//以下内容可以独立出成为一个私有方法shiftUp
		shiftUp(count);
		
	}
	
	//出列，从堆中删除一个元素，按照优先级从高到低出列，其他元素无法出列
	public T extractMax(){
		//取出优先级最高的，在最大堆中即为根节点,元素个数-1
		T max = data[1];
		//从堆中删除根节点，并重新整理使完全二叉树再次成为堆，可以封装成为一个方法-shiftDown
		//1.让最后一个结点代替根节点
		this.data[1] = this.data[count];
		this.count = this.count - 1;
		//2.重新排序，其实就是不断从子节点中找大的交换，因为最后一个元素肯定是小于它前面所有的父节点
		shiftDown(1);
		return max;
	}
	
	//为当前位置的元素往上寻找合适位置
	private void shiftUp(int i){
		T temp = null;
		while(i>1){
			if( comparator.compare(data[i], data[i>>1]) == 1){
				temp = data[i];
				data[i] = data[i>>1];
				data[i>>1] = temp;
				i = i>>1;
			}else{
				break;
			}
		}
	}
	
	//为当前元素位置往下寻找合适位置
	private void shiftDown(int i){
		T temp = null;
		while((i<<1) <= count){
			//在此轮循环中，data[i]与data[j]，先让j为i的左儿子
			int j = i<<1;
			//判断如果已经比所在位置的子节点都大了，就跳出循环，完成了排序
			//1.先判断有无右儿子，有就比较左右儿子大小，取大的为j
			if(j+1 <= count){
				if( comparator.compare(data[j], data[j+1]) == -1){
					j = j+1;
				}
			}
			//2.比较大的儿子节点与父节点谁大，父节点大即该位置已合适，跳出循环
			if( comparator.compare(data[i], data[j]) != -1){
				break;
			}
			//3.交换i与j位置，完成一轮下放的动作
			temp = data[j];
			data[j] = data[i];
			data[i] = temp;
			i = j;
		}
	}
		
}
