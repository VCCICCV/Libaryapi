# Libaryapi
图书管理系统后台

登录页面
![img.png](img.png)
主页
![img_1.png](img_1.png)
list
![img_2.png](img_2.png)
[前端地址](https://github.com/VCCICCV/Libary_vue2)
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
```java
// 全局异常处理
@RestControllerAdvice
@Slf4j

public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误",e);
        return Result.error("系统错误");
    }
    @ExceptionHandler (value = ServiceException.class)
    public Result serviceExceptionError(ServiceException e) {
        log.error("业务异常", e);
        return Result.error(e.getMessage());
    }
}
```
```java
public class ServiceException extends RuntimeException{
    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }
}
```
```sql
清空表 
TRUNCATE TABLE admin;
```
