#DAO (Data Access Object）
由于添加了双数据源

有了如下的配置
```$xslt
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySecondary",
        transactionManagerRef="transactionManagerSecondary",
        basePackages= { "com.example.demo1.domain.s" }) //设置Repository所在位置
```
就把dao类全部放在了对于的目录

不然程序找不到就报错

加上了双数据源，把实体类放在domain下面了