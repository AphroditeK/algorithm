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
		tree.insert(7, "lk7");
		tree.insert(11, "lk11");
		tree.insert(18, "lk18");
		tree.insert(92, "lk92");
		tree.insert(16, "lk16");
		tree.insert(88, "lk88");
		System.out.println(".......");
		System.out.println(tree.contain(11));
		System.out.println(tree.search(11));
		System.out.println("前序遍历");
		tree.preOrder();
		System.out.println("中序遍历");
		tree.inOrder();
		System.out.println("后序序遍历");
		tree.postOrder();
		System.out.println("层序遍历");
		tree.levelOrder();
		System.out.println("移除最大值");
		tree.removeMax();
		tree.inOrder();
		System.out.println("移除最小值");
		tree.removeMin();
		tree.inOrder();
		System.out.println("移除key为9的值");
		tree.remove(10);
		tree.inOrder();
		System.out.println(tree.size());
	}
	
}
