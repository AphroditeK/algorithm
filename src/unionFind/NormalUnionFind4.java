package unionFind;

/**
 * 路径压缩的优化
 * @author asus
 */
public class NormalUnionFind4 {
	
	private int[] parent;
	private int count;
	
	public NormalUnionFind4(int n){
		this.count = n;
		this.parent = new int[n];
		for( int i=0; i<count; i++){
			parent[i] = i;
		}
	}
	
	public int find(int p){
		if( p >= count || p < 0 ){
			return -1;
		}
//		while( parent[p] != p ){
//			//路径压缩的优化,每次find都是一次优化
//			//相隔一个优化一次
//			parent[p] = parent[parent[p]];
//			p = parent[p];
//		}
		
		//究极优化，就是把所有节点直接指向跟节点
		if( parent[p] != p ){
			//这里之所以find( parent[p] )是为了能够递归直接把所有的节点直接一次指向根
			parent[p] = find( parent[p] );
		}
		return parent[p];
	}
	
	public boolean isConnected(int p, int q){
		if( !(isIn(p) && isIn(q)) ){
			return false;
		}
		return find(p) == find(q);
	}
	
	public void union(int p, int q){
		if( !(isIn(p) && isIn(q)) ){
			return;
		}
		if( find(p) == find(q) ){
			return;
		}
		
		parent[ find(p) ] = find(q);
		
		for (int i : parent) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private boolean isIn(int p){
		if( p >= count || p<0 ){
			return false;
		}
		return true;
	}
}
