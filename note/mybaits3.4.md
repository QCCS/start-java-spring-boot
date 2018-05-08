## 基础注解
MyBatis 主要提供了以下CRUD注解：
```$xslt
@Select
@Insert
@Update
@Delete
```

增删改查占据了绝大部分的业务操作，掌握这些基础注解的使用还是很有必要的，例如下面这段代码无需XML即可完成数据查询：
```$xslt
@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    List<User> list();
}


```

## 映射注解
Mybatis主要提供这些映射注解：

@Results 用于填写结果集的多个字段的映射关系.
@Result 用于填写结果集的单个字段的映射关系.
@ResultMap 根据ID关联XML里面<resultMap>.
例如上面的list方法，我们可以在查询SQL的基础上，指定返回的结果集的映射关系，其中property表示实体对象的属性名，column表示对应的数据库字段名。
```$xslt
 @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "mobileNum", column = "PHONE_NUM")
    })
    @Select("select * from t_user")
    List<User> list();
```
   
查询结果如下，：
```$xslt
[
  {
    "userId": "1",
    "username": "admin",
    "password": "admin",
    "mobileNum": "15011791234"
  },
  {
    "userId": "2",
    "username": "roots",
    "password": "roots",
    "mobileNum": "18812342017"
  }
]
```

为了方便演示和免除手工编写映射关系的烦恼，这里提供了一个快速生成映射结果集的方法，具体内容如下：
```$xslt
 /**
     * 1.用于获取结果集的映射关系
     */
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName()).toUpperCase();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }
```
 
在当前Main方法执行效果如下：然后我们将控制台这段打印信息复制到接口方法上即可。


##高级注解
MyBatis-3 主要提供了以下CRUD的高级注解：
```$xslt
@SelectProvider
@InsertProvider
@UpdateProvider
@DeleteProvider
```

见名知意，这些高级注解主要用于动态SQL，这里以@SelectProvider 为例，主要包含两个注解属性，其中type表示工具类，method 表示工具类的某个方法，用于返回具体的SQL。
```$xslt
@Mapper
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class, method = "list222")
    List<User> list2();
}
```

工具类代码如下：
```$xslt
public class UserSqlProvider {
    public String list222() {
        return "select * from t_user ;
    }
}
```
