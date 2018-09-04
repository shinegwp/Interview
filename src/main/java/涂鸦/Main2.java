package 涂鸦;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年9月4日 下午10:19:25
* @describe
*/
public class Main2 {

	
	public int beautyOfArray(int[] array){
		if (array != null && array.length > 0) {//参数判断
			return getBeautyOfArray(array);
		}
		throw new IllegalArgumentException("传入数组不合法");
	}
	private int getBeautyOfArray(int[] array) {
		int sum = 0;//返回结果
		HashSet<Integer> hash = new HashSet<>();//记录子序列中的美丽值
		for (int i = 0, len = array.length; i < len; i++) {
			for (int j = i; j < len; j++) {
				hash.add(array[j]);
				sum += getSum(hash);//对子序列的美丽值求和
			}
			hash.clear();//遍历完清空
		}
		return sum;
	}
	private int getSum(HashSet<Integer> hash) {
		int sum = 0;
		Iterator<Integer> it = hash.iterator();
		while (it.hasNext()) {
			sum+=it.next();
		}
		return sum;
	}
}
