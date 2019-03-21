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
	public static int[] autoArr(int n,int minL,int maxR){
		int[] arr = new int[n];
		Random r = new Random();
		if(n>0 && maxR>=minL){
			for(int i=0;i<n;i++){
				arr[i] = r.nextInt(maxR-minL+1)+minL;
			}
		}
		return arr;
	}
	
	public static double[] autoArr(int n,double minL,double maxR){
		double[] arr = new double[n];
		Random r = new Random();
		if(n>0 && maxR>=minL){
			for(int i=0;i<n;i++){
				arr[i] = r.nextDouble()+minL;
			}
		}
		return arr;
	}
	
	
}
