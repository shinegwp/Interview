package 涂鸦;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年9月4日 下午9:44:16
* @describe
*/
public class Main1 {
	public int numberOfCards (float length) {
		if (length >= 0.0) {//进行数据判断
			return getNumberOfCards(length);//获取结果
		}
		throw new IllegalArgumentException("传入的数据："+length+"不符合要求");
	}
	private int getNumberOfCards(float length) {
		int result = 0;
		double hangs = 0.0;
		if (length == 0.0) {
			return result;
		}
		for (result = 1; ; result++) {
			hangs += 1.0/(result+1);//1/2+1/3+……
			if (hangs >= length) {
				break;
			}
		}
		return result;
	}
}
