启动项目的方式
#
方式1

就是通过idea直接启动的方式

#
方式2

安装maven

官网下载-下载安装包

配置Maven环境变量

启动命令
```$xslt
mvn spring-boot:run
```
#
方式2

先编译为jar包

mvn install

在target目录下，然后运行jar包

java -jar ***.jar

可以加配置参数

java -jar ***.jar --spring.profiles.active=dev



