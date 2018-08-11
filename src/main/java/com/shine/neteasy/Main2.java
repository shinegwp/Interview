package com.shine.neteasy;

import java.util.Scanner;

/**
 * @author 高伟鹏
 * @email gaoweipeng3@gmail.com
 * @version 创建时间：2018年8月11日 下午7:00:15
 * @describe 果园有n堆苹果，每堆苹果的数量为ai，求总做往右数第x个苹果是哪一堆的 输入： 第一行一个数n 第二行n个数ai
 *           第三行一个数m,表示询问m次 第四行m个数xi
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 总堆数
		int all = input.nextInt();
		// 每一堆的临界值
		int[] perMax = new int[all];
		perMax[0] = input.nextInt();
		for (int i = 1; i < all; i++) {
			perMax[i] = perMax[i - 1] + input.nextInt();
		}
		// 总询问次数
		int askAll = input.nextInt();
		// 每次询问的值，最后作为计算结果返回
		int[] asks = new int[askAll];
		for (int i = 0; i < askAll; i++) {
			asks[i] = input.nextInt();
			// 采用二分进行查找
			asks[i] = getTwoPointHelper(perMax, asks[i], 0, all);

		}
		for (int i = 0; i < askAll; i++) {
			System.out.println(asks[i] + 1);
		}
		input.close();
	}

	private static int getTwoPointHelper(int[] perMax, int target, int first, int last) {
		if (first >= last) {
			return first;
		}
		int middle = first + ((last - first) >> 1);
		System.out.println("dfsafafdsa");
		if (target <= perMax[middle]) {
			System.out.println(first + "  " + middle + "  " + last);
			return getTwoPointHelper(perMax, target, first, middle);
		} else {
			System.out.println(first + "  " + middle + "  " + last);
			return getTwoPointHelper(perMax, target, middle + 1, last);
		}
	}
}
