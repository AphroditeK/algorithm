package sort;

import org.junit.Test;

import util.Timer;

public class TestDemo {
	
	@Test
	public void test2() {
		Integer[] arr1 = SortHelper.autoArr(3000, 0, 60000);
		Long time = Timer.timeMillisTimer(sort.SelectSort.class, "doSort2", arr1,3000);
		System.out.println(time);
	}
		
}
