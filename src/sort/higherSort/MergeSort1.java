package sort.higherSort;

/**
 * 自顶向下的归并排序
 * 即语法结构是跟随自顶向下的算法实现
 * @author asus
 */
public class MergeSort1 {
	/**
	 * 归并排序其实就是归并的过程，因为分到最后子列都是只有一个元素，不用排序就已经有序
	 * @param arr 排序数列
	 * @param n 数列长度
	 */
	public void doSort(Integer[] arr,Integer n){
		__mergeSort(arr,0,n-1);
	}
	
	/**
	 * 递归使用归并排序对arr[left.....right]的进行划分、排序、归并
	 * @param arr 排序数列
	 * @param left 数列第一个元素下标
	 * @param right 数列最后一个元素下标
	 */
	private void __mergeSort(Integer[] arr, int left, int right) {
		
/**
 * 优化二：可以设置一个分子列的下限
 * 即分子列不一定要分到底，可以设置一个比较小的值，比如10
 * 小数列的有序性就比较强，可以用插入排序（因为插入排序的效率对于有序性强的序列效率更高），然后归并
 * 这里就不实现了
 */
		
		//判断当数列可以再分时，应该继续往下分
		if(left < right){
			//溢出错误，left和right很大时相加可能超出int范围而发生错误
			//这里如果(left+right)是奇数，/2之后强转为int就会直接抛弃小数
			int mid = (left+right)>>1;	
			//让mid下标的元素指向第一个数列的最后一个元素，即把arr[mid]给第一数列
			__mergeSort(arr, left, mid);
			__mergeSort(arr, mid+1, right);
			
/**
 * 优化一：当arr[mid]<arr[mid+1],认为它已经有序了，就不再执行归并操作
 * 这里是针对几乎有序数列的优化，如果是完全无序的，这里有可能还阻碍了算法速度
 * 因为比较也要占用时间的
 */
			if(arr[mid]>arr[mid+1]){
				//分开的两个序列排好序后进行一次归并操作
				__merge(arr,left,mid,right);
			}
			
		}
		
	}
	
	/**
	 * 归并已排好序的数列arr的两个子列成为有序的arr
	 * @param arr
	 * @param left 指向数列的第一个元素
	 * @param mid 指向数列前子列的最后一个元素
	 * @param right 指向数列最后一个元素
	 */
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
