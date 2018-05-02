package com.example.demo1.learn.throwable;
/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class MyException {
    //数组越界
    public void showArrayIndexOutOfBoundsException() {
        //初始化两行int元素的空间
        int arr[] = new int[2];
        try{
            System.out.println("输出第三个元素 :" + arr[3]);
            System.out.println("再加一个异常 :" + 2/0);
        }
        //1.try不能单独存在，必须有catch或者finally
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("抛出异常1  :" + e);
        }
        catch (Exception e)
        {
            System.out.println("抛出异常2 "  + e.toString());
        }
        //3.catch可以有多个不一样的异常
        //但是后面的catch异常类型必须要比前面的范围大，如果异常被前面catch语句捕获，后面catch就不执行
        catch(Throwable e){
            System.out.println("如果前面有异常，没有捕获到，就执行这里  :" + e);
        }
        finally{
            arr[0] = 6;
            System.out.println("设置第一个元素: " +arr[0]);
        }
        //2.try, catch, finally 块之间不能添加任何代码。
        System.out.println("异常代码块执行完毕");
    }

    public void showMuException() {
        try{
            int x = this.div(4,0);//程序运行截图中的三组示例 分别对应此处的三行代码
            System.out.println("x="+x);
        }
        catch (ArithmeticException e) {
            System.out.println("抛出异常ArithmeticException "  + e.toString());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("抛出异常ArrayIndexOutOfBoundsException  :" + e);
        }
        //如果上面两个catch不写，直接写一个父类，一样可以捕获
        catch(Throwable e){
            System.out.println("是否还有？  :" + e);
        }
        finally{
            System.out.println("finally");
        }
    }

    //抛出两个异常
    int div(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException
    {
        int []arr = new int [a];
        System.out.println(arr[4]);//制造的第一处异常
        return a/b;//制造的第二处异常
    }
}
