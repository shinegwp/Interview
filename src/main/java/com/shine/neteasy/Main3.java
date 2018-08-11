package com.shine.neteasy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 高伟鹏
 * @email gaoweipeng3@gmail.com
 * @version 创建时间：2018年8月11日 下午7:11:31
 * @describe 字典内的每个单词都包含n个‘a’和m个z，并且所有单词按照字典序排列。求第K个单词是什么 输入：三个整数n，m，k，以空格分隔
 *           输出：输出第k个字典中的字符串，如果无解，输出-1
 */
public class Main3 {
	// 采用回溯发
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		long k = scanner.nextLong();
		String string = "";
		for (int i = 0; i < n; i++) {
			string += "a";
		}
		for (int i = 0; i < m; i++) {
			string += "z";
		}
		// 将其转化为字符数组
		char[] arr = string.toCharArray();
		List<List<Character>> list = new ArrayList<>();
		boolean[] flag = new boolean[arr.length];
		// 回溯法存入所有可能
		backtrack(list, new ArrayList<>(), arr, flag);
		for (char c : list.get((int) (k - 1))) {
			System.out.print(c);
		}
	}
	public static void backtrack(List<List<Character>> list, List<Character> temp, char[] arr, boolean[] flag) {
		//推出递归的条件
		if (temp.size() >= arr.length) {
			list.add(new ArrayList<Character>(temp));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (flag[i]) { // 已被访问过
				continue;
			}
			if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
				continue;
			}
			flag[i] = true;
			temp.add(arr[i]);
			backtrack(list, temp, arr, flag);
			//进行回显
			flag[i] = false;
			temp.remove(temp.size() - 1);
		}
	}
}
