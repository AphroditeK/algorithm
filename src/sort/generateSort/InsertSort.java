package sort.generateSort;

/**
 * 插入排序是指不断调整序列，使得调整到的位置前面都是有序的
 * 插入排序本质也是O(n^2)的算法，只是它省略了对已排好序的部分比较，使得算法效率大大增加
 * 每次排序就是把后面的数按顺序一个个往前面插，插完最后一个就排好序了
 * 在对于几乎已经有序的序列插入排序几乎等于O(n)算法
 * 因为每次循环几乎都是只和前一个数比较久结束循环了，这样插入排序有巨大的优势
 * @author asus
 */
public class InsertSort {
	/**
	 * 每次往前面排序都是一个一个位置往前比较
	 * 根据比较结果确定要不要交换位置，最终交换到比前一个大的位置
	 */
	public void doSort1(Integer[] arr,Integer n){
		//为第i个数往前寻找合适的位置
		for(int i=1;i<n;i++){
			//在(0,i)中寻找arr[i]合适的位置
			for(int j=i;j>0;j--){
				//每次都和前一个数比较，小于前一个就交换
				//直到出现不小于，即找到位置，直接跳出循环
				if(arr[j]<arr[j-1]){
					int swap = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = swap;
				}else {
					break;
				}
			}
		}
	}
	
	/**
	 * 复制一个副本，每次都用副本比较，不合适就前面的往后退，留下空位
	 * 直到前一个比它小了，那就插入该位置，这样就大大省下了交换的时间
	 */
	public void doSort2(Integer[] arr,Integer n){
		//为第i个数往前寻找合适的位置
		for(int i=1;i<n;i++){
			//先复制一个arr[i]副本
			int iCopy = arr[i];
			for(int j=i;j>0;j--){
				//比较，一旦比该数小，直接后放不用交换
				//因为有副本,元素不断后放只会丢失i位置的元素，其他的不会丢失
				if(arr[j-1]>iCopy){
					arr[j] = arr[j-1]; 
				}else{
					//找到合适位置，赋值，并跳出循环
					arr[j]=iCopy;
					break;
				}
			}
		}
	}
	
}
