package susmote.FormatDate;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {
	public static void main(String[] args) {
		Date date = new Date();
		DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);
		String string = formater.format(date);
		System.out.println("中国日期： \t" + string);
		formater = DateFormat.getDateInstance(DateFormat.FULL,Locale.CANADA);
		System.out.println("加拿大日期： " + formater.format(date));
		formater = DateFormat.getDateInstance(DateFormat.FULL,Locale.JAPAN);
		System.out.println("日本日期：  \t" + formater.format(date));
		formater = DateFormat.getDateInstance(DateFormat.FULL,Locale.FRANCE);
		System.out.println("法国日期：  \t" + formater.format(date));
		formater = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
		System.out.println("德国日期： \t" + formater.format(date));
		formater = DateFormat.getDateInstance(DateFormat.FULL,Locale.ITALIAN);
		System.out.println("意大利日期：" + formater.format(date));
	}

}
