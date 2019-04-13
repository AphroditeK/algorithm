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
	//用于存储节点的连接情况，但是理论上来时要实现一个可变二维数组才行
	private int[][] graph;
	
}
