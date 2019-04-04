package tree;

import java.util.Comparator;

/**
 * 二分查找
 * 针对有序序列的数据目标查找
 * @author asus
 */
public class BinarySearch<T> {
	
	private Comparator<T> comparator;
	
	public BinarySearch(Comparator<T> c){
		this.comparator = c;
	}
	
	//循环二分
	public int doSearch(T[] arr,T target){
		int n = arr.length;
		int l = 0;
		int r = n-1;
		while(l <= r){
			//这里也有溢出问题，l+r溢出int范围，可修改为
//			int mid = (l + r)>>1;
			int mid = l +((r-l)>>1);
			
			int c = comparator.compare(arr[mid], target);
			if( c == 0){
				return mid;
			}
			if( c > 0){
				//在[0........(mid-1)]中查找target
				r = mid - 1;
			}else{
				//在[(mid+1)........r]中查找target
				l = mid + 1;
			}
		}
		
		return -1;
	}
	
	//递归二分,略微比循环差
	public int doSearch2(T[] arr,T target,int l,int r){
		if(l > r){
			return -1;
		}
		int mid = l+((r-l)>>1);
		int c = comparator.compare(arr[mid],target);
		if( c == 0 ){
			return mid;
		}else if( c > 0 ){
			return doSearch2(arr, target, l, (mid-1) );
		}else{
			return doSearch2(arr, target, (mid+1), r);
		}
	}
	
	//返回第一个最前面出现的目标位置，如果没有，返回最后搜索的位置
	public int floor(){
		int floor = 0;
		//待续...
		return floor;
	}
	
	//返回最后一个最后面出现的目标位置，如果没有，返回最后搜索的位置
	public int ceil(){
		int ceil = 0;
		//待续...
		return ceil;
	}
	
}
