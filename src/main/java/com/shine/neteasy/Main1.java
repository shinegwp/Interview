package com.shine.neteasy;

import java.util.Scanner;

/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月11日 下午3:50:22
* @describe 1.瞌睡
*           输入：
*           第一行：n,k,表示持续多少分钟，以及叫醒后，会清醒多少分钟
*           第二行：n个数，a1，a2……an表示对每分钟知识点的感兴趣分数
*           第三行：n个数，t1，t2……tn表示是否清醒，1表示清醒
*           输出，清醒状态下可以获得最高的分数值
*           
*           例：
*           输入
*             6 3
*             1 3 5 2 5 4
*             1 1 0 1 0 0
*             
*           输出
*             16
*           
*/
public class Main1 {
	//以k为滑动窗口做DP
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//接收上课总时长以及清醒时长
		int timeAll, timeAwake;
		timeAll = input.nextInt();
		timeAwake = input.nextInt();
		//创建容器，获取每分钟对知识点的感兴趣程度，以及每分钟是否睡着
		int[] enjoyValue = new int[timeAll];
		int[] isAwake = new int[timeAll];
		//定义记录总收益的变量
		int allValue = 0;
		//接收数据
		for (int i = 0; i < timeAll; i++) {
			enjoyValue[i] = input.nextInt();
		}
		//同时记录每时刻的收益
		for (int i = 0; i < timeAll; i++) {
			isAwake[i] = input.nextInt();
			allValue += enjoyValue[i]*isAwake[i];
		}
		//定义临时变量记录最大的收益
		int temp = allValue;
		for (int i = 0; i < timeAll;) {
			if (isAwake[i] == 0) {
				allValue += enjoyValue[i];
			} else {
			}
			//当滑条的长度等于清醒长度时
			if (++i >= timeAwake) {
				//开始保留动态的最大值，保证滑条长度范围内的值是最大的
				temp = Math.max(temp, allValue);
				if (isAwake[i-timeAwake] == 0) {
					allValue -= enjoyValue[i-timeAwake];
				}
			}
		}
		System.out.println(temp);
		input.close();
	}
}
