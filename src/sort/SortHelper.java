package sort;
import java.util.Random;

/**
 * 该类中所有的方法都以integer参数作为实现
 * 其中有部分可以修改成泛型方法，方便更广的适用性
 * 但这里略过不做，只是单从算法实现方便性的角度，不讨论代码问题
 * @author asus
 */
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
	
	/**
	 * 打印数组的方法
	 * @param arr 要打印的数组
	 */
	public static void printResult(Integer[] arr){
		for (Integer integer : arr) {
			System.out.print(integer+" ");
		}
		System.out.println();
	}
	
	/**
	 * 复制数组，因为直接用数组赋值数组会指向同一个数组，所以使用方法达到复制效果
	 * @param target 要复制的目标数组
	 * @param n 数组长度
	 * @return 复制数组
	 */
	public static Integer[] copyArr(Integer[] target,Integer n) {
		Integer[] arr = new Integer[n];
		for(int i=0;i<n;i++){
			arr[i] = target[i];
		}
		return arr;
	}
	
}
