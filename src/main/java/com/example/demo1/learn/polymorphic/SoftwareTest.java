package com.example.demo1.learn.polymorphic;

public class SoftwareTest {
    public static void main(String[] args) {
        //创建三个软件的实例
        //都是软件类，指向子类
        SoftWare Excel = new SoftWareExcel("Excel",1);
        SoftWare PPT = new SoftWarePPT("PPT",1);
        SoftWare Word = new SoftWareWord("Word",1);

        //测试多态
        showSoftWareName(Excel);
        showSoftWareName(PPT);
        showSoftWareName(Word);

    }
    //传入软件类，显示软件名称
    //传入什么软件就显示什么软件名称
    public static void showSoftWareName(SoftWare softWare)  {
        //可以这样
        softWare.showName();
        //也可以这样
        // 类型判断
        /*
        if (softWare instanceof SoftWareExcel)  {
            SoftWare Excel = (SoftWareExcel) softWare;
            Excel.showName();
        } else if (softWare instanceof SoftWarePPT)  {
            SoftWare PPT = (SoftWarePPT) softWare;
            PPT.showName();
        }else if (softWare instanceof SoftWareWord)  {
            SoftWare Word = (SoftWareWord) softWare;
            Word.showName();
        }else {
            System.out.println("不知道什么软件");
        }
        */
    }
}
