# Goku.WebService.Bus
基于SpringBoot + Spring +  Apache CXF +Mybatis 开发SOAP的 WebService 服务

# 备注</br>
| **版本** |  **说明**| 
| ------   |:------:|
| 1.0.0版本| |
| 2.0.0版本|springboot启动|

# 原理
Mybatis基于动态代理实现Mapper接口，实现快速开发SOAP的WebService接口服务

# 功能

#### 1.支持日志记录，黑白名单控制</br>
#### 2.支持数据库配置velocity sql查询语句(支持mybatis.velocity指令）</br>
#### 3.基础配置获取增加mybatis缓存机制</br>
##### 4.支持下列业务操作

| 操作类型|交易方法|说明|
| ------------- |:-------------:| -------------:|
|新增|insert|可批量|
|修改|update|可批量|
|删除|delete|可批量|  
|查询单个|SelectOne|  
|查询列表|SelectList|支持分页，需要入参带分页标志参数|  
|存储过程处理|SelectProc|支持分页，需要入带待分页标志参数|  
|新增或修改|insertOrupdate|待完善|  

##### 5.待完善

| 功能 |说明|
| ------------- |:-------------:|
|值域验证|字典值域验证，筛选|
|字段验证|字段类型，格式验证|

# xml格式

## 1.新增或者修改

入参：
```xml
<goku> 
  <header> 
    <!--用户名-->
    <user_id>22</user_id>  
    <!--密码-->
    <password>22</password>  
    <!--操作类型-->
    <tran_no>insertOrupdate</tran_no>  
    <!--交易名称-->
    <bs_code>sysUserMapper</bs_code> 
  </header>  
  <body> 
    <!--操作数据 parameter数据-->
    <data> 
      <id>113</id>  
      <name>mnbhkl</name> 
    </data>  
    <!--操作数据 parameter数据-->
    <data> 
      <id>666</id>  
      <name>3344</name> 
    </data> 
  </body> 
</goku>

```

出参：
```xml
<goku>
  <body>
    <ret_info>成功</ret_info>
    <ret_code>0</ret_code>
  </body>
</goku>

```
## 2.查询列表

入参：
```xml
<goku> 
 <header> 
    <user_id>22</user_id>  
    <password>22</password>  
    <tran_no>SelectList</tran_no>  
    <bs_code>sysUserMapper</bs_code> 
  </header>  
  <body> 
    <data> 
      <id>fjx</id> 
    </data> 
  </body> 
</goku>

```

出参：
```xml
<goku>
  <body>
    <data>
      <Phone_/>
      <company_id>E1C879F8-C493-D26A-699D-604DE42A2BE6-COMPANY</company_id>
      <nickName>***</nickName>
      <valid_>Y</valid_>
      <groupId>90</groupId>
      <companyName>***</companyName>
      <password_>yYSu0BSux2I6VPBZHaB6hf1Ldi0=</password_>
      <extuserid>****</extuserid>
      <emailAddress>nbfujx@qq.com</emailAddress>
      <mobilePhone>***</mobilePhone>
      <favoriteFood>***</favoriteFood>
      <recycled_>N</recycled_>
      <modifiedDate>2017-08-04 09:07:26.0</modifiedDate>
      <description_/>
      <country_/>
      <id>fjx</id>
      <area_/>
      <type_>normal</type_>
      <createDate>2013-07-03 14:53:30.0</createDate>
      <male_>1</male_>
    </data>
    <ret_info>成功</ret_info>
    <ret_code>0</ret_code>
  </body>
</goku>
```

# 分页查询

入参：
```xml
<goku> 
  <header> 
    <user_id>fjx</user_id>  
    <password>1</password>  
    <tran_no>SelectList</tran_no>  
    <bs_code>sysUserMapper</bs_code>  
     <!--是否分页-->
    <is_pagination>Y</is_pagination>  
     <!--当前页-->
    <page_index>1</page_index>  
     <!--单页数-->
    <page_limit>10</page_limit> 
  </header>  
  <body> 
    <data> 
      <id>fjx</id> 
    </data> 
  </body> 
</goku>
```
出参：
```xml
<goku>
  <body>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <data>
	...
    </data>
    <ret_code>0</ret_code>
    <ret_info>成功!</ret_info>
    <!--当前页-->
    <page_index>1</page_index>
    <!--数据总数-->
    <page_count>649</page_count>
  </body>
</goku>
```

