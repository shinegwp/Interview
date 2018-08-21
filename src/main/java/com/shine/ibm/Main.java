package com.shine.ibm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月20日 下午1:47:09
* @describe
*/
public class Main {

	//非递归二分查找,返回查找值的下标
	public int getIndex (int[] arr, int target) {
		if (arr != null && arr.length >= 1) {//异常情况除外
            return getResult(arr, target, 0, arr.length-1);//进行二分查找			
		}
		return -1;
	}
    //二分查找主函数
	private int getResult(int[] arr, int target, int start, int end) {
		//获取中间下标
		int middle = start + ((end - start) >> 1);
		while (start <= end) {//循环判断
			middle = start + ((end - start) >> 1);
			if (arr[middle] == target) {
				return middle;
			} else if (arr[middle] > target) {
				end = middle-1;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}
	
	//递归二分查找,返回查找值的下标
	public int getIndexByRecursion (int[] arr, int target) {
		if (arr != null && arr.length > 0) {
			return getBinarySearchByRecursion(arr, target, 0, arr.length-1);
		}
		return 0;
	}
	private int getBinarySearchByRecursion(int[] arr, int target, int start, int end) {
		if (start <= end) {
			int middle = start + ((end - start) >> 1);
			if (arr[middle] == target) {
				return middle;
			} else if (arr[middle] > target ) {//递归左部分
				getBinarySearchByRecursion(arr, target, start, middle-1);
			} else {//递归右部分
				getBinarySearchByRecursion(arr, target, middle+1, end);
			}
		}
		return -1;
	}
	//https://zoom.us/j/8035300897

	//二叉树的遍历
	public void getTraverseBinaryTree(TreeNode root){
		if(root == null) return;//若根节点为null，则直接返回
	    getHierarchical(root);//按层次遍历
	    getFirstNotRecursion(root);//先序遍历非递归
	    getInOrderNotRecursion(root);//中序遍历非递归
	    getPostorderNotRecursion(root);//后序遍历非递归
	    getFirst(root);//先序遍历递归
	    getInOrder(root);//中序遍历递归
	    getPostorder(root);//后续遍历递归
	}
	private void getPostorderNotRecursion(TreeNode root) {
		Stack<Integer> stack = new Stack<>();//用于存储反遍历获取的值
		Stack<TreeNode> tempStack = new Stack<>();//存储反遍历过程中压栈的结点
		TreeNode current = root;
		while (current != null || stack != null) {
			if (current != null) {
				stack.push(current.getValue());//将父节点输出到存储值的栈中
				tempStack.push(current);//父节点压栈
				current = current.getRight();//遍历右孩子
			} else {
				current = tempStack.pop();//右孩子不存在时，返回父节点
				current = current.getLeft();//遍历左孩子
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	private void getPostorder(TreeNode root) {
		if (root == null) return;
		getPostorder(root.getLeft());
		getPostorder(root.getRight());
		System.out.println(root.getValue());
		
	}
	private void getInOrderNotRecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();//模拟递归
		TreeNode current = root;
		while (current!=null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);//保存父结点
				current = current.getLeft();//遍历左孩子
			} else {
				current = stack.pop();//左孩子不存在时，返回父节点
				System.out.println(current.getValue());//输出
				current = current.getRight();//遍历右孩子
			}
		}
	}
	private void getInOrder(TreeNode root) {
		if (root == null) return;
		getInOrder(root.getLeft());//递归左孩子
		System.out.println(root.getValue()+" ");//输出父节点
		getInOrder(root.getRight());//递归右孩子
	}
	private void getFirstNotRecursion(TreeNode root) {
		// TODO Auto-generated method stub
		Stack<TreeNode> stack = new Stack<>();//用stack模拟递归
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			if (current!=null) {
				System.out.println(current.getValue());//输出父节点
				stack.add(current);//将结点压栈，由于后续访问右孩子
				current = current.getLeft();//访问左孩子
			} else {//没有左孩子了
				current = stack.pop();//将父节点出栈
				current = current.getRight();//访问右孩子
			}
		}
	}
	//先序递归遍历
	private void getFirst(TreeNode root) {
		if (root == null) return;
		System.out.println(root.getValue()+" ");//输出父节点
		getFirst(root.getLeft());//递归左孩子
		getFirst(root.getRight());//递归右孩子
	}
	//按层次遍历
	private void getHierarchical(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//使用queue来遍历
	    queue.add(root);
	    while(!queue.isEmpty())//队列中有元素（层数，当最后一层时，队列中是没有元素的）
	    {
	        for(int i=0, len = queue.size();i <len; i++)//遍历该层中的结点
	        {
	            TreeNode temp = queue.poll();//将遍历的结点取出
	            System.out.print(temp.getValue()+" ");//
	            if(temp.getLeft() != null)  queue.add(temp.getLeft());//将孩子结点放到队列中
	            if(temp.getRight() != null) queue.add(temp.getRight());
	        }
	        System.out.println("");//一层遍历结束，进行换行
	    }		
	}
	
	
}
class TreeNode{
	private int value;
	private TreeNode left;
	private TreeNode right;
	public TreeNode(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
}