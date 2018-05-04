#数据库配置jdbc
创建数据库 test_spring_boot

添加用户表user
```$xslt
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/test_spring_boot
spring.datasource.username=root
spring.datasource.password=mac123
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.max-idle=10
spring.datasource.max-wait=10000
spring.datasource.min-idle=5
spring.datasource.initial-size=5

server.tomcat.uri-encoding=UTF-8

```
添加依赖
```$xslt

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```
测试数据库类
```$xslt


@RestController
@RequestMapping("/mydb")
public class DbController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }
    @RequestMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable String id){
        Map<String,Object> map = null;
        List<Map<String, Object>> list = getDbType();
        for (Map<String, Object> dbmap : list) {
            Set<String> set = dbmap.keySet();
            for (String key : set) {
                if(key.equals("id")){
                    if(dbmap.get(key).equals(id)){
                        map = dbmap;
                    }
                }
            }
        }
        if(map==null) {
            map = list.get(0);
        }
        return map;
    }
}

```

#数据库配置jpa
```$xslt
 <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
 </dependency>
```
```$xslt
#JPA Configuration:
spring.jpa.database=MySQL
spring.jpa.generate-ddl=true  
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.naming_strategy=org.hibernate.cfg.ImprovedNamingStrategy  
#spring.jpa.database=org.hibernate.dialect.MySQL5InnoDBDialect
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MYSQL5Dialect
```
创建实体类，自动建表
```$xslt

@Entity
@Table(name = "user2")
public class User2 {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User2(String name, String password) {
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User2 [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

    public User2() {

    }
}

```

###实体模型Model
###数据查询层DAO
###查询接口，数据处理Service
###接口定义数据使用Controller
