package com.java.studio;

import java.util.Scanner;

public class DistributionDepartment {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入新员工的姓名：");
		String name = scan.nextLine();
		System.out.println("请输入新员工的应聘的编程语言：");
		String language= scan.nextLine();
		switch (language) {
		case "Java":
			System.out.println("员工" + name + "被分配到Java程序开发部门。");
			break;
		case "C#":
			System.out.println("员工" + "被分配到C#项目维护组。");
			break;
		case "ASP.NET":
			System.out.println("员工" + name + "被分配到ASP.NET程序测试部门。");
			break;
			default:
				System.out.println("本公司不需要" + language + "语言的程序开发人员。");
		}
		
	}

}
