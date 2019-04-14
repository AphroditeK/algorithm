package graph;

import java.util.Vector;

/**
 * 邻接表实现稀疏图（无平行边无权）
 * 在原文中C++使用的是向量Vector类来存储
 * 在这里java使用的是邻接链表
 * @author asus
 */
public class SparseGraph {
	
	private int nodeSize;
	private int edgeSize;
	private boolean directed;
	private class iterator{
		//为了方便直接在这里定义一个私有迭代器类
		//最少应该有2个方法，T next,boolean hasNext,void begin(从新开始迭代)
	}
	
	//用于存储节点的连接情况，但是理论上来时要实现一个可变二维数组才行
	private int[][] graph;
	
	public SparseGraph(int nodeSize,boolean directed){
		this.nodeSize = nodeSize;
		this.edgeSize = 0;
		//TODO 初始化边的存储结构
	}
	
	public int nodeSize(){
		return nodeSize;
	}
	
	public int edgeSize(){
		return edgeSize;
	}
	
	/**
	 * 输入两个节点的下标位置，插入一条边，连接两个节点
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w){
		//TODO
	}
	
	//通过一个点遍历所有的边，得到它所连接的所有的点
	//使用迭代器进行遍历，这里返回一个迭代器
	public void iterator(){
		//TODO
	}
}
