package com.example.demo1.learn.throwable;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 * 自定义异常
 */

//按照国际惯例，自定义的异常应该总是包含如下的构造函数
//一个无参构造函数
//一个带有String参数的构造函数，并传递给父类的构造函数。
//一个带有String参数和Throwable参数，并都传递给父类构造函数
//一个带有Throwable 参数的构造函数，并传递给父类的构造函数。
public class SelfDefineException extends Exception{
    static final long serialVersionUID = 7818375828146090155L;
    public SelfDefineException() {
        super();
    }

    public SelfDefineException(String message) {
        super(message);
    }

    public SelfDefineException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelfDefineException(Throwable cause) {
        super(cause);
    }

}
