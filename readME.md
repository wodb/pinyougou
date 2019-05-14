## 品优购(pinyougou)

### 创建工程
1.parent。引入maven(pom)

2.pojo(.jar)

	需要实现Serializable。因为要在网络中传输

3.dao(.jar)

	引入跟数据库相关jar包
	引入pojo(依赖)

4.common(.jar)

5.sellergoods-interface(.jar)

6.sellergoods-service(.war)

	在web.xml中引入spring配置文件。
	在pom中增加interface.jar。加入interface.jar之后会依赖传递进来pojo
	使用@Autowride自动注入dao方法，dao是在本地运行所以可以实现自动装配功能。进行调用
	在spring配置文件中增加dubbo提供者
	在dubbo中的端口号.可能会有多个service 使用端口号区分开
	<dubbo:protocol name="dubbo" port="20881" />
	<dubbo:application name="pinyougou-sellergoods-service"/>  
	<dubbo:registry address="zookeeper://192.168.3.101:2181"/>
	<dubbo:annotation package="com.pinyougou.sellergoods.service.impl" />

7.shop-web(.war)

8.manager-web(.war)

	@Reference可以自动装配提供者的service

	在调用service中返回Page对象，调用之后报以下错误

![错误](./screenshots/20190430101551.jpg)

	总结就是这个错误：java.lang.NoClassDefFoundError: org/apache/ibatis/session/RowBounds
	这是因为web工程中没有依赖MyBatis的包，在pom.xml中再次添加上相应的依赖就行。
	<dependency>
	    <groupId>com.github.pagehelper</groupId>
	    <artifactId>pagehelper</artifactId>	   
	</dependency>
	<dependency>
		<groupId>com.github.miemiedev</groupId>
		<artifactId>mybatis-paginator</artifactId>		
	</dependency>
