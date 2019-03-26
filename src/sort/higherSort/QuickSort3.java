package sort.higherSort;

import java.util.Random;

/**
 * 针对存在大量重复数据的排序
 * 另一种思路就是3路排序，即分成(<v)(>v)(=v)三部分
 * @author asus
 */
public class QuickSort3 {
	
	public void doSort(Integer[] arr,Integer n) {
		__partition(arr, 0, n-1);
	}


	private void __partition(Integer[] arr, int left, int right) {
		//判断子列是否是一个元素，是就不用执行下面的操作了
		if(left<right){
			//lt从左边开始
			int lt = left;
			//这里+1是为了最后gt都能指向第一个比v大的数
			int gt = right+1;
			//i从标准之后的数开始遍历
			int i = left+1;
			
			//选取一个随机数作为标准
			int r = new Random(System.currentTimeMillis()).nextInt(right-left+1)+left;
			int temp = arr[left];
			arr[left] = arr[r];
			arr[r] = temp;
			
			int v = arr[left];
			while(i < gt){
				if(arr[i]<v){
					//如果i<v,把该元素放到lt后面，然后指针lt++，i++
					temp = arr[i];
					arr[i] = arr[lt+1];
					arr[lt+1] = temp;
					lt++;
					i++;
				}else if(arr[i]>v){
					//i>v，把该元素放到gt前面，指针gt--
					temp = arr[i];
					arr[i] = arr[gt-1];
					arr[gt-1] = temp;
					gt--;
				}else{
					//i=v，指针i++,继续遍历
					i++;
				}
			}
			//交换标准与lt位置的元素，中间段多一个，lt少一个
			temp = arr[left];
			arr[left] = arr[lt];
			arr[lt] = temp;
			lt--;
			
			__partition(arr, left, lt);
			__partition(arr, gt, right);
		}
	}
	
	
}
