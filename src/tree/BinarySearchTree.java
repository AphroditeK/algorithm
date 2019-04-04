package tree;

import java.util.Comparator;

/**
 * 二分查找树，一种数据结构类型，拥有高性能的数据查找
 * @author asus
 *
 */
public class BinarySearchTree<K,V>{
	
	//内部结点类
	@SuppressWarnings("hiding")
	private class Node<K,V>{
		private K key;
		private V value;
		private Node<K,V> left;
		private Node<K,V> right;
		public Node(K key, V value) {
			super();
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	//二叉树的根节点，输的管理都是通过根节点往下进行的
	private Node<K,V> root;
	private int count;
	private Comparator<K> comparator;
	
	/**
	 * 请传入key的比较器，大于0的表示大于号，小于0表示小于号，0表示等于号
	 * @param comparator 结点key值的比较器
	 */
	public BinarySearchTree(Comparator<K> comparator) {
		super();
		this.comparator = comparator;
		this.root = null;
		this.count = 0;
	}

	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void insert( K key, V value ){
		//维护二叉搜索树其实就是维护根节点，一切的结点都可以通过root往下寻找
		//所以insert方法其实就是刷新一下root，使得新内容插入
		//这里还简单的使用了一下Java的多态
		this.root = insert(this.root,key, value);
	}
	
	public boolean contain(K key){
		//多态调用内部方法判断
		return contain( root, key);
	}
	
	public V remove(K key){
		Node<K,V> node = null;
		
		return node.value;
	}
	
	/**
	 * 这里其实跟插入是差不多的，都是根据搜索树的规则从根节点往下寻找
	 * @param node 每次判断的子树的根节点
	 * @param key 判断节点的key
	 * @return
	 */
	private boolean contain( Node<K, V> node, K key) {
		if( node == null ){
			return false;
		}
		int r = comparator.compare(node.key, key);
		if( r == 0 ){
			return true;
		}else if( r > 0 ){
			return contain(node.left, key);
		}else{
			return contain(node.right, key);
		}
		
	}

	/**
	 * 递归实现插入结点，原理是不断往下比较找到要插入结点的合适位置
	 * 当前存在的key默认为跟新操作，不存在的key就是寻找空位插入
	 * @param node 当前子树的根节点
	 * @param key 插入的key
	 * @param value 插入的value
	 * @return 返回更新后的子树根节点
	 */
	private Node<K, V> insert( Node<K, V> node, K key, V value ){
		if( node == null ){
			count ++;
			return new Node<K, V>(key, value);
		}
		int r = comparator.compare(node.key, key);
		if( r == 0 ){
			//key相等表示更新操作，只更新value，其他的内容是属于结构的，不属于用户
			node.value = value;
		}else if( r < 0 ){
			//大于根节点新元素放右侧，递归返回以右儿子作为根节点的子树的根节点
			node.right = insert(node.right, key, value);
		}else if( r > 0 ){
			//小于根节点新元素放左侧，递归返回以左儿子作为根节点的子树的根节点
			node.left = insert(node.left, key, value);
		}
		return node;
	}
	
}
