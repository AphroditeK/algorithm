package tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

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
	
	//二叉树的根节点，树的管理都是通过根节点往下进行的
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
	
	//使用后序遍历清空该树
	public void destory(){
		//其实这里与C++有所不同，因为java对象都是引用，没有指针的概念
		//所以并不用清空内容，只要堆中对应对象没有引用指向它的话，jvm会自动进行垃圾回收，不用主动操作
		//所以这里可以直接让root=null,count=0,没了引用jvm会自动进行回收
		destory(root);
	}
	
	private void destory(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node != null ){
			destory(node.left);
			destory(node.right);
			node = null;
			this.count--;
		}
	}
	
	public V maxmun(){
		return maxmun(root).value;
	}
	
	/**
	 * 返回以当前结点作根节点的子树的最大结点
	 * @param node
	 * @return
	 */
	private Node<K, V> maxmun( BinarySearchTree<K, V>.Node<K, V> node ){
		if( node.right == null ){
			return node;
		}
		return maxmun(node.right);
	}
	
	public V minmun(){
		return minmun(root).value;
	}
	
	/**
	 * 返回以当前结点作根节点的子树的最小结点
	 * @param node
	 * @return
	 */
	private Node<K, V> minmun(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node.left == null ){
			return node;
		}
		return minmun(node.left);
	}

	/**
	 * 插入key-value结点，如果key已存在，则更新已存在结点
	 * @param key
	 * @param value
	 */
	public void insert( K key, V value ){
		//维护二叉搜索树其实就是维护根节点，一切的结点都可以通过root往下寻找
		//所以insert方法其实就是刷新一下root，使得新内容插入
		//这里还简单的使用了一下Java的多态
		this.root = insert(this.root,key, value);
	}
	
	/**
	 * 判断树中是否含有相应key值的结点
	 * @param key
	 * @return
	 */
	public boolean contain(K key){
		//多态调用内部方法判断
		return contain( root, key);
	}
	
	/**
	 * 查找相应key的value值
	 * @param key
	 * @return
	 */
	public V search(K key){
		//多态调用内部方法进行判断读取返回相应结点的值
		if( search(root,key) != null ){
			return search( root, key).value;
		}
		return null;
	}
	
	//前序遍历
	public void preOrder(){
		preOrder(root);
		System.out.println();
	}
	
	//中序遍历,由于二分搜索树左儿子小右儿子大的特点，中序遍历就相当于排序
	public void inOrder(){
		inOrder(root);
		System.out.println();
	}
	
	//后序遍历，利用此可以很好的清空二分搜索树
	public void postOrder(){
		postOrder(root);
		System.out.println();
	}
	
	//层序遍历,需要利用一个队列结构进行辅助遍历
	public void levelOrder(){
		//1.取出根节点放入队列中
		//注意：这里使用的是java提供的队列，java仅仅提供了该接口，要实例化需要用到java链表
		Queue<BinarySearchTree<K, V>.Node<K, V>> q = new LinkedList<>();
		q.offer(root);
		
		//循环遍历队列达到层序遍历的效果
		while( !q.isEmpty() ){
			//2.从队列取出（遍历）
			Node<K, V> node = q.poll();
			System.out.print( node.key.toString() + " " );
			//3.判断是否有儿子结点，有即再放入队列中
			if( node.left != null ){
				q.offer(node.left);
			}
			if( node.right != null ){
				q.offer(node.right);
			}
		}
		System.out.println();
	}
	
	public void removeMin(){
		//这里单从操作来说使用while循环的方式更好，不过使用递归的话还能重复利用函数
		root = removeMin(root);
	}

	public void removeMax(){
		//这里单从操作来说使用while循环的方式更好，不过使用递归的话还能重复利用函数、
		root = removeMax(root);
	}
	
	public void remove(K key){
		//删除结点后更新根
		if( contain(key) ){
			root = remove(root,key);
		}else{
			System.out.println("该key结点不存在");
		}
	}
	
	/**
	 * 删除以node为根的子树的key结点
	 * @param node
	 * @param key
	 * @return 返回删除key结点后更新的根节点
	 */
	private Node<K, V> remove(BinarySearchTree<K, V>.Node<K, V> node, K key) {
		//有以下这几种情况，分开处理
		int r = comparator.compare(node.key, key);
		if( r > 0 ){
			node.left = remove(node.left, key);
		}else if( r < 0 ){
			node.right = remove(node.right, key);
		}else{
			//r=0,该node结点为要删除的key
			//这里有三种情况
			//1.只有左孩子(左右都为空时会进入这种情况，返回null就相当于直接删除了node)
			if( node.right == null ){
				//直接让左孩子替代要删除的结点的位置即可
				count--;
				return node.left;
			}
			//2.只有右孩子
			if( node.left == null ){
				//直接让右孩子替代要删除的结点的位置即可
				count--;
				return node.right;
			}else{ 
				/**
				 * 同时拥有左右孩子
				 * 两种解决方案，这里使用第一种
				 * 1.让右子树中最小值替代该节点位置
				 * 2.让左子树最大值替代该节点位置
				 */
				//这里要注意的是，在C++中，remove是要释放内存的，释放内存后所有指向该节点的指针都将失效
				//但是java不同，java通过指向null使得内容没有指针指向，然后交由JVM自动回收
				//java没有指针的概念，但对象全部都是引用类型，即对象变量名存储的都是地址
				Node<K,V> rightMinmun = minmun(node.right);
				//有了上面新的指针指向后，即使remove了结点也不会导致指针指向空，因为JVM还不会回收内存
				node.right = removeMin(node.right);
				node.key = rightMinmun.key;
				node.value = rightMinmun.value;
				return node;
			}
		}
		return node;
	}

	//删除以node结点为根的树的最大结点
	private Node<K, V> removeMax(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node.right == null ){
			count--;
			return node.left;
		}
		node.right = removeMax(node.right);
		return node;
	}

	//删除以node结点为根的树的最小结点
	//删除后该结点的左右子树肯定有变化，把变化后的内容重新回传给该节点
	private Node<K, V> removeMin(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node.left == null ){
			//这里与C++有所不同，因为java对象都是引用，没有指针的概念
			//所以并不用清空内容，只要堆中对应对象没有引用指向它的话，jvm会自动进行垃圾回收，不用主动操作
			count--;
			return node.right;
		}
		//递归调用函数
		/**
		 * 如果该节点还有做孩子，即该节点不是最小结点
		 * 再以该节点的做孩子为根节点，删除子树的最小值
		 * 返回删除后的新节点
		 */
		node.left = removeMin(node.left);
		return node;
	}
	
	private void postOrder(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node != null ){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.key.toString() + " ");
		}
	}

	private void inOrder(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node != null ){
			inOrder(node.left);
			System.out.print(node.key.toString() + " ");
			inOrder(node.right);
		}
	}
	
	private void preOrder(BinarySearchTree<K, V>.Node<K, V> node) {
		if( node != null ){
			System.out.print(node.key.toString() + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	

	/**
	 * 已node为当前根节点，遍历该二分搜索树，返回相应的key的value值
	 * @param node
	 * @param key
	 * @return
	 */
	private Node<K, V> search(BinarySearchTree<K, V>.Node<K, V> node, K key) {
		
		if( node == null){
			return null;
		}
		int r = comparator.compare(node.key, key);
		if( r == 0){
			return node;
		}else if( r > 0 ){
			return search(node.left, key);
		}else{
			return search(node.right, key);
		}
		
	}

	/**
	 * 这里其实跟插入是差不多的，都是根据搜索树的规则从根节点往下寻找
	 * @param node 每次判断的子树的根节点
	 * @param key 判断节点的key
	 * @return
	 */
	private boolean contain( BinarySearchTree<K, V>.Node<K, V> node, K key) {
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
	private Node<K, V> insert( BinarySearchTree<K, V>.Node<K, V> node, K key, V value ){
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
