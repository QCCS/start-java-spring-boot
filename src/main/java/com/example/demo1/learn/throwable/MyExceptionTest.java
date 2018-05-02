package com.example.demo1.learn.throwable;
/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class MyExceptionTest {
    public static void main(String[] args) {
        MyException exception = new MyException();
        exception.showArrayIndexOutOfBoundsException();
        exception.showMuException();
    }
}
