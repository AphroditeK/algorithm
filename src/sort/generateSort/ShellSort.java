package sort.generateSort;

public class ShellSort {
	
	public void doSort(Integer[] arr){
		int d=arr.length;
        while(true)
        {
        	//定义了d为int类型，所以这里计算后小数位会被直接丢弃
            d=d/2;
            for(int x=0;x<d;x++)
            {
                for(int i=x+d;i<arr.length;i=i+d)
                {
                    int temp=arr[i];
                    int j;
                    for(j=i-d;j>=0&&arr[j]>temp;j=j-d)
                    {
                        arr[j+d]=arr[j];
                    }
                    arr[j+d]=temp;
                }
            }
            if(d==1)
            {
                break;
            }
        }
	}

	
	
}
