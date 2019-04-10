package unionFind;

/**
 * 基于rank的优化，根据元素的高度来判断如何并集
 * 把矮的指向高的
 * @author asus
 */
public class NormalUnionFind3 {

	private int[] parent;
	//新增一个数组，表示已该位置元素为根节点的树的高度
	private int[] rank;
	private int count;
	
	public NormalUnionFind3(int n){
		this.count = n;
		this.parent = new int[n];
		this.rank = new int[n];
		//parent表示该位置元素指向的父节点，一开始都没有关系，就指向自身
		//即后续只要发现指向自身的元素，就是根节点的元素
		//元素所在组就以根节点的parent为准
		for( int i=0; i<count; i++){
			parent[i] = i;
			rank[i] = 1;
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
		
		int pId = find(p);
		int qId = find(q);
		if( pId == qId ){
			return;
		}
		
		
		//把矮的指向高的，这样rank就保持原有的高度不变
		if( rank[pId] > rank[qId]){
			parent[qId] = pId;
		}else if(rank[pId] < rank[qId]){
			parent[pId] = qId;
		}else{
			//两者高度一致时随便指，然后维护rank
			parent[qId] = pId;
			rank[pId] += 1;
		}
		
		
		
		
		for (int i : rank) {
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
