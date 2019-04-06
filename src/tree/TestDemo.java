package tree;

import java.util.Comparator;

import org.junit.Test;

public class TestDemo {
	
	@Test
	public void testBinaryTree(){
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if( o1 > o2 ){
					return 1;
				}else if( o1 < o2 ){
					return -1;
				}
				return 0;
			}
		};
		
		Integer[] arr = {1,2,3,4,5,6};
		int location = new BinarySearch<Integer>(c).doSearch2(arr, 1,0,5);
		System.out.println(location);
	}
	
	
	@Test
	public void testBinarySearchTree(){
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if( o1 > o2 ){
					return 1;
				}else if( o1 < o2 ){
					return -1;
				}
				return 0;
			}
		};
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<>(c);
		
		tree.insert(8, "lk8");
		tree.insert(3, "lk3");
		tree.insert(10, "lk10");
		tree.insert(9, "lk9");
		System.out.println(".......");
		System.out.println(tree.contain(11));
		System.out.println(tree.search(11));
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
	}
	
}
