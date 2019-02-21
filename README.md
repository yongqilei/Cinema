## 资源链接

猫眼电影APP改版设计：https://www.zcool.com.cn/work/ZMjU5MTU3Mjg=.html

影院APP开发的基本功能：http://www.adinnet.cn/bloginfo/2018_02/blog_3437.html

猫眼电影选座模仿(包含落单座位限制)：https://github.com/z624821876/YSSeatsPicker

影院选座算法-限制单独座位：https://www.cnblogs.com/v-jing/p/4180129.html

## 界面设计(大致)

### 1、模仿各大影院售票APP界面设计。<br/>
主要一下几个影院售票APP。

影院设计：https://www.uisdc.com/design-elements-of-cinema-app

https://www.ui.cn/detail/328165.html

淘票票UI设计：<br/>
https://www.zcool.com.cn/work/ZMTgyMTg2NzY=.html<br/>
https://www.zcool.com.cn/work/ZMjE5MTUyNzY=.html<br/>

猫眼电影APP：https://www.zcool.com.cn/work/ZMjU5MTU3Mjg=.html<br/>

基于原生小程序精仿的猫眼电影：https://blog.csdn.net/qq_37860930/article/details/83473562

Icon的图我再想办法搞一搞

### 数据库设计

用户表设计：https://blog.6ag.cn/1619.html || https://blog.csdn.net/weixin_37878702/article/details/78350271

影院APP数据库设计：https://blog.csdn.net/chenzr9527/article/details/70199204 (供参考，APP应设计更复杂)

### API

城市列表接口：https://maoyan.com/ajax/cities

开发者API资源：https://blog.csdn.net/hengqiaqia/article/details/84061831

淘票票电影票API：https://developer.alibaba.com/docs/api.htm?spm=a219a.7395905.0.0.554075feFrYvkY&apiId=24474

可以根据淘票票提供的各个API的返回值来设计数据库！

### 密码安全
加密算法(对称，非对称)：https://github.com/yidao620c/thinking-java/tree/master/src/main/java/ch02utils/crypto

Java的MD5加密与RSA加密：https://cloud.tencent.com/developer/article/1128214
--- (RSA加密较安全！)

RSA加密实例：https://blog.csdn.net/qing101hua/article/details/44932457 --- 用户密码使用RSA加密客户端保存公钥，服务端保存对应的私钥(考虑服务端用什么方式保存，用MySQL还是Redis或其他更好的方法，Redis:key(用户名)-value(私钥)，MySQL:创建表，字段为USERNAME,PRIVATE_KEY,EXPIRE_TIME,GENERATE_TIME[用用户名来查询私钥])

Druid的ConfigTools中公钥私钥加密：https://github.com/alibaba/druid/blob/master/src/main/java/com/alibaba/druid/filter/config/ConfigTools.java

注册的时候用生成的公钥加密输入的密码之后再将其存入数据库，每次登录时用私钥解密之后再比较。

数据库中user(登录信息)表中加一个登录类型的字段(账号密码登录：0，手机号登录：1，微信登录：2，QQ登录：3，微博登录：4 ....)

### 想要应用的技术

Spring Boot 2,Redis,Spring Cloud(能应用就应用上),Docker,Zookeepr or Eureka,消息队列Rabbit MQ or Kafka...

### 极验验证

极验验证Demo：https://github.com/GeeTeam/gtapp-ios-oc

GeeTest官网：http://www.geetest.com/

### Java新特性

Java 8 新特性：https://www.ibm.com/developerworks/cn/java/j-lo-jdk8newfeature/index.html

Java 9 新特性：https://www.ibm.com/developerworks/cn/java/the-new-features-of-Java-9/index.html

Java 10 新特性：https://www.ibm.com/developerworks/cn/java/the-new-features-of-Java-10/index.html

## 项目技术
### 项目结构大纲

### 技术大纲
暂定：Spring Boot 2.0，Spring AOP/Zuul网关Filter 做登录判断(accessToken和refreshToken)和访问授权判断，Druid，Mybatis，Redis，Log4j(日志系统)，(Spring Cloud + Eureka/Zookeeper)/(Dubbo + Zookeeper)

### 大致功能
mybatis-plus动态数据源：https://gitee.com/baomidou/dynamic-datasource-spring-boot-starter/wikis/pages

Centos7中配置MySQL5.7主从复制：https://blog.csdn.net/vbirdbest/article/details/83153417

Spring Boot 集成Mybatis实现主从（多数据源）分离方案：https://www.jianshu.com/p/8813ec02926a
#### 基本功能
1、用户登陆(第三方登录-微信)

iOS和Java-RSA加密：https://blog.csdn.net/chaijunkun/article/details/7275632

微信登录：https://blog.csdn.net/u014635337/article/details/78966708

微信登录官方文档：https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419317851&token=&lang=zh_CN

即时通讯：socket
消息队列：RabbitMQ,ActiveMQ,Kafka,Redis(推送消息)

#### 扩展功能
1、电影推荐系统(参照Netflix的电影推荐算法)

推荐算法分类：a.按照数据使用划分；b.按照模型划分

协同过滤算法：UserCF(基于用户)，ItemCF(基于物品)，ModelCF(基于模型)

Hadoop构建电影推荐系统：http://blog.fens.me/hadoop-mapreduce-recommend/

Mahout推荐算法API详解：http://blog.fens.me/mahout-recommendation-api/
