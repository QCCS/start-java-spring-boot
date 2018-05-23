#测试servlet

创建servlet类之后，需要修改配置文件，demo1.iml
因为这个项目是spring-boot初始化的
```$xslt
<configuration>
    <descriptors>
      <deploymentDescriptor name="web.xml" url="file://$MODULE_DIR$/web/WEB-INF/web.xml" />
    </descriptors>
    <webroots>
      <root url="file://$MODULE_DIR$/web" relative="/" />
    </webroots>
    <sourceRoots>
      <root url="file://$MODULE_DIR$/src/main/java" />
      <root url="file://$MODULE_DIR$/src/main/resources" />
    </sourceRoots>
</configuration>

```
还需要导入tomcat-servlet包，
配置tomcat服务器，运行即可看见对应的jsp页面
