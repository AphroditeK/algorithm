package sort.higherSort;

import java.util.Random;


/**
 * quicksort1解决了几乎有序的序列排序问题，但还有一个很突出的问题同样会引起bug
 * 就是数列中，存在很多等值的的元素时，那么无论分给左还是右，都会导致分支不平衡
 * 不平衡就会导致算法效率又逐渐回归(n^2),甚至递归过多出现栈溢出错误
 * 所以这里再重写__partition函数
 * @author asus
 */
public class QuickSort2 {
	
	public void doSort(Integer[] arr,Integer n){
		__quickSort(arr, 0, n-1);
	}
	
	/**
	 * 递归实现快速排序不断分成有严格大小关系的两部分
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void __quickSort(Integer[] arr,int left,int right){
		//当left >= right,说明已经分到只有一个元素了，即不用再分了
		if(left<right){
			//执行快速排序分成两部分，并得到选取的标准在的位置
			int position = __partition(arr, left, right);
			//利用标准分开两部分再执行快速排序，因为标准在的位置已经是最终的位置了
			//所以不需要再排序作为标准的元素
			__quickSort(arr, left, position-1);
			__quickSort(arr, position+1, right);
		}
		
	}

	private int __partition(Integer[] arr, int left, int right) {
		//处理多元素等值问题的一个方法
		/**
		 * 从大小两边同时遍历数组，而且遇到与标准等值的都往自己这边放
		 * 这样就算等值的出现很多，也会较为平均的分配到两边
		 * 达到平衡分支的效果
		 */
		int rand = new Random().nextInt(right-left+1)+left;
		int i = left+1;
		int j = right;
		int temp = arr[rand];
		arr[rand] = arr[left];
		arr[left] = temp;
		int v = arr[left];
		while(true){
			while(i <= right && arr[i] < v){
				i++;
			}
			while(j >= left+1 && arr[j] > v){
				j--;
			}
			if(i>j){
				break;
			}
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		temp = arr[j];
		arr[j] = arr[left];
		arr[left] = temp;
		return j;
	}
}
