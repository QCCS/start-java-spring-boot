package com.example.demo1.learn.throwable;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class SelfDefineExceptionTest {
    public static void main(String[] args) {
        String[] arr = {"1","2","3"};
        for(int i = 0; i < arr.length; i++){
            if("4".equals(arr[i])){
                try {
                    //抛出自定义异常
                    throw new SelfDefineException("SelfDefineException");
                }catch (SelfDefineException e){
                    System.out.println(e);
                }
            }else{
                System.out.println(arr[i]);
            }
        }
    }
}
