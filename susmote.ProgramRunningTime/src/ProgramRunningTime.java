public class ProgramRunningTime {
    public static double round(double value){
        return Math.round(value * 10.0) / 10.0;
    }
    public static String getElapsedText(long elapsedMillis){
        if(elapsedMillis < 60000){
            double unit  = round(elapsedMillis / 1000);
            return unit + "秒";
        }else if(elapsedMillis < 60000 * 60){
            double unit = round(elapsedMillis /  60000.0);
            return unit + "分";
        }else if(elapsedMillis < 60000 * 60 * 24){
            double unit = round(elapsedMillis / (60000.0 * 60));
            return unit + "时";
        }else{
            double unit = round(elapsedMillis / (60000.0 * 60 * 24));
            return unit + "天";
        }
    }public static void main(String[] args){
        long begin = System.currentTimeMillis();
        System.out.println("程序开始运行的时间: " + begin);
        for (int i = 0; i < 1000000000; i++ ){
            Math.random();
        }
        long end = System.currentTimeMillis();
        System.out.println("程序运行结束的时间: " + end);
        System.out.println("程序总共运行时间: " + getElapsedText(end - begin));
    }
}
