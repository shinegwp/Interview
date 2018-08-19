package 贝壳;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月18日 下午8:21:29
* @describe 搭建道路 通过100%  题目见markdown
*/

import java.util.Scanner;
public class Main2{
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int min = input.nextInt();
        int result = min;
        for (int i = 1,temp = 0;i < len; i++){
            temp = input.nextInt();
            result += temp;
            if(temp < min) min = temp;
        }    
        System.out.println(result - min);
        input.close();
    }    
} 