package com.java.studio;

import java.util.Scanner;

public class JudgeLeapYear {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个年份");
		long year = scan.nextLong();
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year + "是闰年！");
		}else {
			System.out.println(year + "不是闰年！");
		}
		
		
	}

}
