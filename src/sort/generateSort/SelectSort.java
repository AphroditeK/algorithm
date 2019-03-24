package sort.generateSort;


import org.junit.Test;

import sort.SortHelper;

/**
 * 选择排序是O(n^2)级别的算法，其实就是暴力排序
 * 每次挑最小的往前面放
 * 通过这个简单的排序算法也说明一个问题
 * 同一个算法实现也有多种办法
 * 最少元操作的方法才是最好的办法
 */
public class SelectSort {
	
	/**
	 * 第一种实现形式（每次发现更小的就交换）
	 * 每次都从未排序的位置中选择该数arr[i]
	 * 然后和后面的每一个数比较，一旦比该数小就交换位置
	 * 一直到和后面所有的数字比较完毕，该位置的数字就确定下来，再寻找下一位数
	 */
	public void doSort1(Integer[] arr,Integer n){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[i]){
					int swap = arr[i];
					arr[i]=arr[j];
					arr[j]=swap;
				}
			}
		}
		
	}	
	/**
	 * 第二种实现形式（发现更小的先记录，最后再交换）
	 * 要确定第i位置的元素，就先假设当前位置元素就是最小的
	 * 然后和后面的元素比较，一旦发现更小的就记录下该元素位置
	 * 用记录下的位置的元素继续和后面的比较，直到全部比较完毕
	 * 交换i位置与记录的最小元素位置，完成i位置的排序
	 */
	public void doSort2(Integer[] arr,Integer n){
		//寻找(i,n)中最小的值
		for(int i=0;i<n;i++){
			//最小值的下标记录
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			//交换位置完成i位置元素的排序
			int swap = arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=swap;
		}
		
	}	
	
	public void doSort(Double[] arr,Integer n){
		for(int i=0;i<n;i++){
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			double swap = arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=swap;
		}
		
	}	

	@Test
	public void test() {
		
		Integer[] arr1 = SortHelper.autoArr(30000, 0, 60000);
		Long bigin1 = System.currentTimeMillis();
		doSort1(arr1, 30000);
		Long end1 = System.currentTimeMillis();
		System.out.println(end1-bigin1);
		Integer[] arr2 = SortHelper. autoArr(30000, 0, 60000);
		Long bigin2 = System.currentTimeMillis();
		doSort2(arr2, 30000);
		Long end2 = System.currentTimeMillis();
		System.out.println(end2-bigin2);
		
	}
	

}
