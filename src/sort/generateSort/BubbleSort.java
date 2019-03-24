package sort.generateSort;

public class BubbleSort {
	
	/**
	 * 自我实现的一种方式
	 * 完全根据算法思想进行实现，缺少优化
	 * 不能体现算法的优点
	 * 但是对于近乎有序的序列，这种实现方式要更好
	 */
	public void doSort1(Integer[] arr,Integer n){
		int times = 0;
		int temp = 0;
		//下面是循环冒泡
		while(true){
			//times是经过比较，但是没有发生交换的次数
			//如果n个元素放生了n-1次比较都没有发生交换
			//即该数列已经排好顺序了，可以跳出循环，结束冒泡
			if(times==n-1){
				break;
			}else{
				times = 0;
			}
			//开始一次冒泡循环
			for(int i=0;i<n-1;i++){
				if(arr[i]>arr[i+1]){
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}else{
					times++;
				}
			}
			//打印每次排序结果
//			SortHelper.printResult(arr);
		}
		
	}
	
	/**
	 * 最优实现
	 */
	public void doSort2(Integer[] arr,Integer n){
		int i, j, temp;
		//由于每次都能一定确定最后一个元素，所以最多只需要冒泡n-1次，确认到第二个位置的元素
		//整个排序就能确定下来
	    for (j = 0; j < n - 1; j++){
	    	//i<n-1-j的含义是因为冒泡每循环一次，唯一能确定的下来的就是最后一个一定是最大的
	    	//每一次冒泡最少能实现最后一个位置的确定，即后面的n-1-j都是不用比较，一定是正确的顺序了
	        for (i = 0; i < n - 1 - j; i++)
	        {
	            if(arr[i] > arr[i + 1])
	            {
	                temp = arr[i];
	                arr[i] = arr[i + 1];
	                arr[i + 1] = temp;
	            }
	        }
	        //打印每次排序结果
//	        SortHelper.printResult(arr);
	    }
	}
	
}
