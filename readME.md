# zookeeper

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
```
<!-- 访问dubbo自己占用的端口 -->
<dubbo:protocol name="dubbo" port="20881"></dubbo:protocol>
```
7 shop-web(.war)

8 manager-web(.war)