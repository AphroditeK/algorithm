package sort;

public class BubbleSort {
	
	/**
	 * 自我实现的一种方式
	 */
	public void doSort1(Integer[] arr,Integer n){
		int times = 0;
		int temp = 0;
		while(true){
			if(times==n-1){
				break;
			}else{
				times = 0;
			}
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
	
	
	public void doSort2(Integer[] arr,Integer n){
		int i, j, temp;
	    for (j = 0; j < n - 1; j++){
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
