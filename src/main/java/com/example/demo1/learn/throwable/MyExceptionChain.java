package com.example.demo1.learn.throwable;
/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
import java.util.*;

//假设B模块完成自己的逻辑需要调用A模块的方法，
//如果A模块发生异常，则B也将不能完成而发生异常，
//但是B在抛出异常时，会将A的异常信息掩盖掉，
//这将使得异常的根源信息丢失。异常的链化可以将多个模块的异常串联起来，使得异常信息不会丢失。

//下面是一个例子，演示了异常的链化：从命令行输入2个int，将他们相加，输出。输入的数不是int，则导致getInputNumbers异常，从而导致add函数异常，则可以在add函数中抛出

public class MyExceptionChain {
    public static void main(String[] args) {
        System.out.println("请输入2个加数");
        int result;
        try {
            result = add();
            System.out.println("结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers() {
        List<Integer> nums = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        try {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            nums.add(new Integer(num1));
            nums.add(new Integer(num2));
        } catch (InputMismatchException immExp) {
            throw immExp;
        } finally {
            scan.close();
        }
        return nums;
    }

    //执行加法计算
    private static int add() throws Exception {
        int result;
        try {
            List<Integer> nums = getInputNumbers();
            result = nums.get(0) + nums.get(1);
        } catch (InputMismatchException immExp) {
            //链化:以一个异常对象为参数构造新的异常对象。
            throw new Exception("计算失败", immExp);
        }
        return result;
    }

}
