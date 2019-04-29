# zookeeper

![zookeeper](./screenshots/1383119-20180717001954161-165278124.png)

图片alt就是显示在图片下面的文字，相当于对图片内容的解释。
图片title是图片的标题，当鼠标移到图片上时显示的内容。title可加可不加

#### 安装步骤

1.安装jdk

2.上传代码到linux系统中，需创建一个data文件夹目录，为注册服务使用

3.解压缩包
```
tar -zxvf *.tar.gz
<!-- 创建data -->
mkdir data
```
4.修改config
```
cd conf
mv zoo_sample.cfg  zoo.cfg
dataDir=/root/zookeeper-3.4.6/data

```
#### 命令
```
./zkServer.sh start
./zkServer.sh stop
./zkServer.sh status
```

# 品优购(pinyougou)

## 创建工程
1 parent。引入maven(pom)

2 pojo(.jar)

	需要实现Serializable。因为要在网络中传输

3 dao(.jar)

	引入跟数据库相关jar包
	引入pojo(依赖)

4 common(.jar)

5 sellergoods-interface(.jar)

6 sellergoods-service(.war)

	在web.xml中引入spring配置文件。
	在pom中增加interface.jar。加入interface.jar之后会依赖传递进来pojo
	使用@Autowride自动注入dao方法，dao是在本地运行所以可以实现自动装配功能。进行调用
	在spring配置文件中增加dubbo提供者
	```
		<!-- 在dubbo中的端口号.可能会有多个service 使用端口号区分开 -->
		<dubbo:protocol name="dubbo" port="20881" />
		<dubbo:application name="pinyougou-sellergoods-service"/>  
    <dubbo:registry address="zookeeper://192.168.3.101:2181"/>
    <dubbo:annotation package="com.pinyougou.sellergoods.service.impl" /> 
	```

7 shop-web(.war)

8 manager-web(.war)
	
	@Reference可以自动装配提供者的service
