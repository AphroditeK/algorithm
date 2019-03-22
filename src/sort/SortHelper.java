package sort;

import java.util.Random;

public class SortHelper {
	
	/**
	 * 生成伪随机数数组
	 * @param n 数组长度
	 * @param minL 随机数最小值
	 * @param maxR 随机数最大值
	 * @return int[] 数组
	 */
	public static Integer[] autoArr(Integer n,Integer minL,Integer maxR){
		Integer[] arr = new Integer[n];
		Random r = new Random();
		if(n>0 && maxR>=minL){
			for(int i=0;i<n;i++){
				arr[i] = r.nextInt(maxR-minL+1)+minL;
			}
		}
		return arr;
	}
	
	public static Double[] autoArr(Integer n,Double minL,Double maxR){
		Double[] arr = new Double[n];
		Random r = new Random();
		if(n>0 && maxR>=minL){
			for(int i=0;i<n;i++){
				arr[i] = r.nextDouble()+minL;
			}
		}
		return arr;
	}
	
}
