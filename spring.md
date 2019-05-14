## spring注解功能(@)

**@Param**(mybatis)

```
<!-- @Param是MyBatis所提供的(org.apache.ibatis.annotations.Param)，作为Dao层的注解，作用是用于传递参数，从而可以与SQL中的的字段名相对应，一般在2=<参数数<=5时使用最佳。 -->
public List<Role> findRoleByMix(@Param("roleP") RoleParam role, @Param("permissionP") PermissionParam permission);
<!-- 这样就可以进行如下映射 -->
<select id="findRoleByMix" resultType="role">
    SELECT id,name FROM t_role
    WHERE roleName=#{roleP.roleName}
    AND note=#{rolep.note}
    AND level=#{permissionP.level}
<select>
```

**@RequestParam**(spring-boot,spring-mvc)

```java
@RequestMapping("/list")
public String test(int userId) {
  return "list";
}
@RequestMapping("/list")
public String test(@RequestParam int userId) {
  return "list";
}
/*
第一种写法参数为非必传，第二种写法参数为必传。参数名为userId。
第二种写法可以通过@RequestParam(required = false)设置为非必传。因为required值默认是true，所以默认必传。
第二种写法可以通过@RequestParam("userId")或者@RequestParam(value = "userId")指定参数名。
第二种写法可以通过@RequestParam(defaultValue = "0")指定参数默认值
*/

@RequestMapping("/list")
public String test(@RequestParam(value = "userId", defaultValue = "0", required = false) int userId) {
  return "list";
}
```

**PathVariable**

```java
/*获取的是请求路径中参数的值*/
@RequestMapping("/pets/{petId}")
public void findPet(@PathVariable String petId) {
	/*todo*/
}
```

**@Valid**

```java
/*用于验证注解是否符合要求，直接加在变量user之前，在变量中添加验证信息的要求，当不符合要求时就会在方法中返回message的错误提示信息。*/
@RestController
@RequestMapping("/user")
public class UserController {
  @PostMapping
  public User create (@Valid @RequestBody User user) {

  }
}
public class User {
  private String id;

  @NotBlank(message = "密码不能为空")
  private String password;
}
```
![注解](./screenshots/20190430085603.jpg)

**@RequestBody**
```java
/*接收json请求的参数 content-type要设置成application-json*/
public class UserController {
	@PostMapping
	public User create(@RequestBody User user) {

	}
}
```