package unionFind;

import org.junit.Test;

public class TestDemo {
	
	@Test
	public void testSUF(){
		
//		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		SimpleUnionFind suf = new SimpleUnionFind(9);
		
		System.out.println(suf.isConnected(0, 8));
		suf.union(0, 8);
		System.out.println(suf.isConnected(0, 8));
		
	}
	
	@Test
	public void testNUF(){
		
		NormalUnionFind nuf = new NormalUnionFind(10);
		nuf.union(0, 8);
		System.out.println(nuf.isConnected(0, 8));
		nuf.union(1, 7);
		nuf.union(1, 9);
		nuf.union(2, 6);
		nuf.union(9, 3);
		nuf.union(4, 5);
		nuf.union(4, 8);
		System.out.println(nuf.isConnected(0, 4));
		System.out.println(nuf.isConnected(2, 4));
	}
	
	@Test
	public void testNUF2(){
		
		NormalUnionFind2 nuf = new NormalUnionFind2(10);
		nuf.union(0, 8);
		System.out.println(nuf.isConnected(0, 8));
		nuf.union(1, 7);
		nuf.union(1, 9);
		nuf.union(2, 6);
		nuf.union(9, 3);
		nuf.union(4, 5);
		nuf.union(4, 8);
		System.out.println(nuf.isConnected(0, 4));
		System.out.println(nuf.isConnected(2, 4));
	}
}
