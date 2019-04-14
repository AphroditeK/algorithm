package graph;

/**
 * 邻接矩阵实现稠密图（无平行边无权）
 * @author asus
 */
public class DenseGraph {
	
	private int nodeSize;
	private int edgeSize;
	//定义是否为有向图
	private boolean directed;
	//定义一个邻接矩阵，无权图
	private Boolean[][] graph;
	
	@SuppressWarnings("unused")
	public DenseGraph(int nodeSize, boolean directed){
		this.nodeSize = nodeSize;
		this.directed = directed;
		this.edgeSize = 0;
		this.graph = new Boolean[nodeSize][nodeSize];
		for (Boolean[] i : graph) {
			for ( Boolean j : i) {
				j = false;
			}
		}
	}
	
	public int nodeSize(){
		return nodeSize;
	}
	
	public int edgeSize(){
		return edgeSize;
	}
	/**
	 * O(1)级别的连接查询
	 * @param v 节点v的索引
	 * @param w 节点w的索引
	 * @return
	 */
	public boolean hasEdge(int v, int w){
		if( isOverStack(v) || isOverStack(w)){
			return false;
		}
		return graph[v][w];
	}
	
	/**
	 * 为v和w两个节点增加一条边
	 * @param v 节点索引
	 * @param w 节点索引
	 */
	public void addEdge(int v, int w){
		//越界判断
		if( isOverStack(v) || isOverStack(w) ){
			return;
		}
		//是否有边判断
		if( hasEdge(v, w) ){
			return;
		}
		graph[v][w] = true;
		if( !directed ){
			graph[w][v] = true;
		}
		this.edgeSize++;
	}
	
	//使用迭代器遍历
	public void getGraph(){
		//TODO
	}
	
	private boolean isOverStack(int n){
		if( n >= 0 && n < nodeSize ){
			return false;
		}
		return true;
	}
	
}
