package unionFind;

/**
 * 也是使用一个数组来进行连接关系的说明
 * 默认数据也是存储在数组中的，用相应的下标来表示数据元素
 * @author asus
 */
public class NormalUnionFind {
	
	private int[] parent;
	private int count;
	
	public NormalUnionFind(int n){
		this.count = n;
		this.parent = new int[n];
		//parent表示该位置元素指向的父节点，一开始都没有关系，就指向自身
		//即后续只要发现指向自身的元素，就是根节点的元素
		//元素所在组就以根节点的parent为准
		for( int i=0; i<count; i++){
			parent[i] = i;
		}
	}
	
	/**
	 * 寻找位置为p的元素所在的组
	 * @param p 数据元素的下标
	 * @return 返回所在组的编号
	 */
	public int find(int p){
		if( p >= count || p < 0 ){
			return -1;
		}
		//寻找父节点的过程
		while( parent[p] != p ){
			//父节点肯定是指向自身的节点，所以parent[p] = p
			//否则继续往上寻找
			p = parent[p];
		}
		return p;
	}
	
	/**
	 * 判断两者是否相连接，就是判断两者的根节点是否一致
	 * @param p 元素的下标
	 * @param q 元素的下标
	 * @return
	 */
	public boolean isConnected(int p, int q){
		if( !(isIn(p) && isIn(q)) ){
			return false;
		}
		return find(p) == find(q);
	}
	
	/**
	 * 连接两个数据
	 * @param p
	 * @param q
	 */
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
