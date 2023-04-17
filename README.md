# Libaryapi

- mybayis 配置
- java
```java
@Mapper
public interface UserMapper {
    // @Select ("select * from user")
    List<User> listUsers();
}
```
- yml
```yml
mybatis:
  mapper-locations: classpath:mapper/*.xml
```
- xml id为方法名  
- 位置src/main/resources/mapper/User.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.libary.mapper.UserMapper">
    <select id="listUsers" resultType="com.example.libary.entity.User">
        select * from user
    </select>
</mapper>
```
- 分页
```xml
        <!--分页-->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.3.0</version>
</dependency> 
```
- ctrl+alt+o   清除无用的导入
- ctrl+alt+l   格式化
>常见错误
Source must not be null
未考虑异常情况
