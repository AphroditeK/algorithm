package sort.higherSort;

import java.util.Random;

/**
 * 快速排序，被认为是最伟大的排序算法
 * 主要思路就是取一个标准，把一个数列分为两部分，前后有严格的大小关系
 * 即前面的元素都比标准小（大），后面的都比标准大（小）
 * 然后每部分再按照这样的规则再分为两部分，直到每部分都是一个元素，则排序完毕
 * @author asus
 */
public class QuickSort1 {
	
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
	
	
	/**
	 * 把传入的整个数列按大小关系分为两部分，并移动元素使得数列两部分有严格大小关系
	 * 得到分开的下标的位置
	 * @param arr 传入数列以供操作
	 * @param left 子数列第一个部分的第一元素下标
	 * @param right 子数列第二部分的最后元素下标
	 */
	private int __partition(Integer[] arr,int left,int right){
		int temp = 0;
		//选取第一个数作为标准划分数列
		int position = left;
/**
 * 这里会有一个致命的bug，因为选取第一个数作为标准
 * 如果这是一个近乎有序的序列，那么第一个数很有可能就是最小的数
 * 那么以此为标准分出的两部分其实就一个一个数和剩下的大部分
 * 如果每次都分成这样，那么就要分接近n次才能把数列分完
 * 那么快速排序就会退化成(n^2)的算法，这样反而归并排序会更快
 * 而且分成n次意味着递归了n次，一旦数量（即n）太大，那么递归会导致严重bug
 * java.lang.StackOverflowError(栈堆溢出错误，调用函数层级过多)
 */
		//解决对几乎有序的序列排序，即随机选取标准,让其和第一个元素换
		int k = new Random().nextInt(right-left+1)+left;
		temp = arr[k];
		arr[k] = arr[left];
		arr[left] = temp;
		
		int v = arr[left];
		for(int i = left+1;i <= right ;i++){
			if(arr[i]<v){
				temp = arr[position+1];
				arr[position+1] = arr[i];
				arr[i] = temp;
				position++;
			}
		}
		temp = arr[position];
		arr[position] = arr[left];
		arr[left] = temp;
		return position;
	}
	
}
