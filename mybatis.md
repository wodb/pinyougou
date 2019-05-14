## mybatis
```
<!--
    <insert></insert> 中没有resultType属性，但是<selectKey></selectKey> 标签是有的。
    order="AFTER" 表示先执行插入语句，之后再执行查询语句。
    可被设置为 BEFORE 或 AFTER。
    如果设置为 BEFORE,那么它会首先选择主键,设置 keyProperty 然后执行插入语句。
    如果设置为 AFTER,那么先执行插入语句,然后是 selectKey 元素-这和如 Oracle 数据库相似,可以在插入语句中嵌入序列调用
    keyProperty="userId"  表示将自增长后的Id赋值给实体类中的userId字段。
    SELECT LAST_INSERT_ID() 表示MySQL语法中查询出刚刚插入的记录自增长Id.
    实体类中uerId 要有getter() and setter(); 方法
 -->
<insert id="insertProduct" parameterType="domain.model.ProductBean">
    <selectKey resultType="java.lang.Long" order="AFTER" keyProperty="productId">
      SELECT LAST_INSERT_ID()
    </selectKey>
    INSERT INTO t_product(productName,productDesrcible,merchantId)values(#{productName},#{productDesrcible},#{merchantId});
 </insert>
```
