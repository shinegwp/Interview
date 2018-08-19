package 贝壳;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月18日 下午8:06:49
* @describe 取消社团预约 题目见markdown
*/
public class Main1 {
    //通过45%
//	public static void main (String[] args) {
//        Scanner input = new Scanner(System.in);
//        int length = input.nextInt();
//        HashSet<Integer> list = new HashSet<Integer>();
//        list.add(0);
//        int count = 0;
//        int result = 0;
//        boolean resultFlag = true; 
//        for (int i = 0, first = 0, last = 0; i < length; i++) {
//            first = input.nextInt();
//            last = input.nextInt();
//            boolean flag = true;
//            a:
//            for (int j = first; j < last; j++) {
//                if (flag) {
//                    if (list.contains(j)) {
//                        flag = false;
//                        count++;
//                        if (resultFlag) {
//                            result = i;
//                            resultFlag = false;
//                            if (count < 2) {
//                            	for (int z = j-1; z >= first; z--) {
//                                	list.remove(z);
//                                }
//                                break a;
//                            }
//                        }
//                    }
//                    list.add(j);
//                }else {
//                    list.add(j);
//                } 
//            }
//            flag = true;
//            if (count > 1) {
//                break;
//            }    
//        }
//        if (count == 0) {
//            System.out.println(length);
//            for (int i = 1; i < length; i++) {
//                System.out.print(i+" ");
//            }    
//            System.out.println(length);
//        } else if (count == 1) {
//            System.out.println(1);
//            System.out.println(result);
//        } else {
//            System.out.println(0);
//        }
//        input.close();
//    } 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		Help[] hs = new Help[length];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			hs[i] = new Help();
			hs[i].setLeft(input.nextInt());
			hs[i].setRight(input.nextInt());
			hs[i].setId(i+1);
		}
		//对所有的活动进行排序
		Arrays.sort(hs, new Comparator<Help>() {
			@Override
			public int compare(Help o1, Help o2) {
				if (o1.getLeft() == o2.getLeft()) {
					if (o1.getRight() > o2.getRight()) {
						return 1;
					}else if (o1.getRight() < o2.getRight()) {
						return -1;
					} else {
						return 0;
					}
				} else if (o1.getLeft() < o2.getLeft()) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		int resultIndex = 0;
		//从头开始撤销社团预约
		for (int i = 0, pre = -1; i < length; i++) {
			pre = -1;
			boolean flag = true;
			//查看撤销此社团预约时，是否可以安排顺利
			for (int j = 0; j < length && flag; j++) {
				if (j == i) continue;
				if (hs[j].getLeft() >= pre) {
					pre = pre > hs[j].getRight() ? pre : hs[j].getRight();
				} else {
					flag = false;
				}
			}
			if (flag) {
				list.add(hs[i].getId());
				resultIndex++;
			}
		}
		Collections.sort(list);
		System.out.println(resultIndex);
		//遍历输出所有可能
		for (int i = 0; i < resultIndex; i++) {
			System.out.print(list.get(i)+" ");
		}
		input.close();
	}
	
}

class Help{
	private int left;
	private int right;
	private int id;
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}