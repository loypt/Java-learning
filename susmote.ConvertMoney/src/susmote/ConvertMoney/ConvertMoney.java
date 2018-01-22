package susmote.ConvertMoney;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConvertMoney {
	private final static String[] STR_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍",
            "陆", "柒", "捌", "玖"};
	private final static String[] STR_UNIT = { "", "拾", "佰", "仟", "万", "拾",
            "佰", "仟", "亿", "拾", "佰", "仟" };
	private final static String[] STR_UNIT2 = { "角", "分", "厘" };
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个金额");
		String convert = convert(scan.nextDouble());
		System.out.println(convert);
	}
	public static String convert(double d) {
		DecimalFormat df = new DecimalFormat("#0.###");
		String strNum = df.format(d);
		if(strNum.indexOf(".") != -1) {
			String num = strNum.substring(0,strNum.indexOf("."));
			if (num.length() > 12) {
				System.out.println("数字太大，不能完成装换！！！");
				return "";
			}
		}
		String point = "";
		if(strNum.indexOf(".") != -1) {
			point = "元";
		}else {
			point = "元整";
		}
		String result = getInteger(strNum) + point + getInteger(strNum);
		if (result.startsWith("元")) {
			result = result.substring(1,result.length());
		}
		return result;
	}
	public static String getInteger(String num) {
		if(num.indexOf(".") != -1) {
			num = num.substring(0, num.indexOf("."));
		}
		num = new StringBuffer(num).reverse().toString();
		StringBuffer temp = new StringBuffer();
		for (int i = 0;i < num.length(); i++) {
			temp.append(STR_UNIT[i]);
			temp.append(STR_NUMBER[num.charAt(i) - 48]);
		}
		num = temp.reverse().toString();
		num = numReplace(num, "零拾", "零");
		num = numReplace(num, "零佰", "零");
		num = numReplace(num, "零仟", "零");
		num = numReplace(num, "零万", "万");
		num = numReplace(num, "零亿", "亿");
		num = numReplace(num, "零零", "零");
		num = numReplace(num, "亿万", "亿");
		if (num.lastIndexOf("零") == num.length() - 1) {
			num = num.substring(0,num.length() - 1);
		}
		return num;
	}
	public static String numReplace(String num,String oldStr,String newStr) {
		while (true) {
			if (num.indexOf(oldStr) == -1) {
				break;
			}
			num = num.replaceAll(oldStr, newStr);
		}
		return num;
	}
}

