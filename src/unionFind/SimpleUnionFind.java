package unionFind;


/**
 * 简单的并查集实现，data是在数组中存储的，那么所有的元素都会有一个天然的下标
 * 这里这个并查集不存储数据，但是存储了数据元素之间的连接关系和部分的连接操作
 * id表示元素的所在组
 * 同组元素相互连接
 * O(1)级别的quickFind
 * O(n)级别的union
 * @author asus
 */
public class SimpleUnionFind {
	private int[] id;
	private int count;
	
	/**
	 * 初始化数组元素之间的连接关系，n代表元素个数
	 * @param n
	 */
	public SimpleUnionFind(int n){
		this.count = n;
		this.id = new int[n];
		//初始化id，所有的id都不同，所有的元素都相互不连接
		for(int i = 0; i < count; i++){
			id[i] = i;
		}
	}
	
	/**
	 * 传入元素下标，可以得到元素所在的组的id号
	 * 一个组代表内部元素相互连接
	 * 时间复杂度O(1)
	 * @param p
	 * @return
	 */
	public int find(int p){
		if( p >= count || p < 0){
			return -1;
		}
		return id[p];
	}
	
	/**
	 * 并查集的核心操作，并列元素使他们在同一组，相互连接
	 * p/q指的是数组元素下标
	 * 时间复杂度O(n)
	 * @return
	 */
	public boolean union(int p,int q){
		//p/q不是超出数组元素下标
		if( p >= count || q >= count){
			return false;
		}
		int pId = find(p);
		int qId = find(q);
		//p/q已经同组
		if( pId == qId ){
			return true;
		}
		
		//把p的id改为q的id，则两人连接
		//同时原p组中的所有都与q组中的连接，所有所有都并到q组中去
		for(int i = 0; i < count; i++){
			if( id[i] == pId ){
				id[i] = qId;
			}
		}
		return true;
	}
	
	public boolean isConnected(int p,int q){
		return find(p) == find(q);
	}
	
}
