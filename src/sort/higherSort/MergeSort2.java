package sort.higherSort;

/**
 * 自底向上的归并排序实现
 * 即归并排序最后都是分成一个一个元素然后归并
 * 那么就是可以直接从底层开始直接往上归并实现排序
 * 这个方式对于链表的数据类型有非常好的(nlogn)的算法实现度
 * @author asus
 */
public class MergeSort2 {
	
	public void doSort(Integer[] arr,Integer n){
		//解释sz：指的是每次归并操作的数列大小，直到大小超过了n，即已经归并到最初的了
		/**
		 * 第一次归并操作子列的大小是1，归并后是大小为2的数列
		 * 那第二次归并操作子列的大小就是2，归并后是大小为4的数列
		 * 第三次归并操作子列的大小是4，以此类推，最后归并的大小应该就是n
		 */
		for(int sz = 1;sz <= n;sz = (sz<<1)){
			//二层循环要确定的是每次进行归并操作数列的三个下标
			/** 
			 * 解释一：
			 * 子列大小为sz的有n/i个，每两个两个一组进行一次归并
			 * 最前的两个子列三个下标为(0,0+sz-1,0+sz+sz-1),归并
			 * 接下来两个是(0+sz+sz,0+sz+sz+sz-1,0+sz+sz+sz+sz-1)
			 * 以此类推，每次都以 i 为每一组的 left 下标
			 * 所以以i为基点三个下标是(i,i+sz-1,i+sz+sz-1)
			 * 所以下一组归并的 left 下标就是(i+sz+sz)
			 * i<n 时（即left下标还没超出arr数列）都可以继续归并
			 */
			/**
			 * 解释二：
			 * 下标溢出问题，即最后一组大小为sz的子列
			 * 它并不是一定能够有两个子列归并的，它可能就是它自己一个成为了一组
			 * 所以它的往上一层归并其实就是自己跟自己归并
			 * 这就是分组不一定是偶数组的所带来的问题
			 * 所以(i<n)的循环判断条件变为(i+sz<n)
			 * 即中点后一位（就是right子列的第一个元素下标）超出n时
			 * 说明他就是一个单列成组，后面没有子列跟它归并，就可以跳出归并操作的循环
			 * 那这里就又带来一个问题，就是没有(i+sz)
			 * 那就更不存在(i+sz+sz-1)这个后面子列的最后一个下标了
			 * 所以应该把最后一个下标变为(n-1)
			 * 即min(i+sz+sz-1,n-1)
			 */
	 		for(int i = 0;i < n;i = i+sz+sz){
	 			//对arr[i.....i+sz-1]
	 			//和arr[i+sz.......i+sz+sz-1]
	 			//进行归并
	 			__merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
	 		}
		}
	}
	
	private void __merge(Integer[] arr, int left, int mid, int right) {
		//归并流程
		//1.先复制出一个数列副本
		Integer[] aux = new Integer[right-left+1];
		for(int i = left;i<=right;i++){
			aux[i-left] = arr[i];
		}
		//2.建立两个下标分别指向要归并的两个数列的第一个元素
		int i = left;
		int j = mid+1;
		//3.开始为归并的数列进行排序赋值
		for(int k = left;k<=right;k++){
			//4.在循环赋值的时候要判断两个数列是否被用完了
			if(i>mid){
				//如果i先被用完，就可以直接把剩余的j直接归并到后面
				arr[k] = aux[j-left];
				j++;
			}else if(j>right){
				//如果j先被用完，就直接把剩余的i归并到后面
				arr[k] = aux[i-left];
				i++;
			}else if(aux[i-left]<aux[j-left]){
				/**
				 * 判断要归并的两个数列谁应该在k位上
				 * 这里有个问题，aux辅助数列的下标问题
				 * 应该注意到最初要排序的arr数列只是形式上分开了，实际上并没有划分出独立的子列
				 * 辅助函数aux只是复制了arr[left.....right]这部分的副本
				 * 而aux下标还是从0开始的，这里i最初是等于left的，所以存在偏移量	
				 */
				arr[k] = aux[i-left];
				//aux[i-left]被归并了，下标后移
				i++;
			}else{
				arr[k] = aux[j-left];
				//aux[j-left]被归并了，下标后移
				j++;
			}
		}
	}	
	
}
