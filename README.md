#### spring-cloud-alibaba
微服务的一种解决方案

#### 服务注册与发现 nacos
- 下载安装 windows
```shell script
# 切换 tag 1.2.1
git clone https://github.com/alibaba/nacos.git

# 编译 
mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U 
```

- 启动
```shell script
# linux  standalone表示单机模式运行，非集群模式
sh startup.sh -m standalone

# ubuntu
bash startup.sh -m standalone

# window
点击startup.cmd
```

- 访问服务

打开浏览器：http://localhost:8848/nacos， 密码默认为nacos/nacos

#### 服务提供者 provider
- @EnableDiscoveryClient表明是nacos的一个客户端，是spring cloud提供的原生注解
- http://localhost:8680/hello/study 访问成功
- nacos的服务列表出现该客户端

#### 服务消费者 consumer
- 使用feign作为服务间的通信
  - feign是一个声明式的伪 Http 客户端
  - feign 采用的是基于接口的注解
- 通过 @EnableFeignClients 注解开启 Feign 功能
- 通过 @FeignClient("服务名") 注解来指定调用哪个服务

#### 使用熔断器 Sentinel
- 随着微服务的流行，服务和服务之间的稳定性变得越来越重要。 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性
- feign中使用熔断器
  - 开启熔断
    ```yaml
    feign:
      sentinel:
        enabled: true
    ```
  - 指定fallback类
    ```java
    @Component
    public class EchoServiceFallback implements EchoService {
        @Override
        public String echo(String message) {
            return "echo fallback";
        }
    }
    ```

#### 使用熔断器仪表盘
Sentinel 控制台提供一个轻量级的控制台，它提供机器发现、单机资源实时监控、集群资源汇总，以及规则管理的功能。您只需要对应用进行简单的配置，就可以使用这些功能

- 下载安装
```shell script
# 下载源码
git clone https://github.com/alibaba/Sentinel.git

# 编译打包
mvn clean package

# 跳过test模板
mvn install -Dmaven.test.skip=true
```

- 运行
```shell script
cd sentinel-dashboard\target
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
```

- 访问
打开浏览器：http://localhost:8080/#/dashboard/home， 密码默认为sentinel/sentinel


- feign客户端配置
```yaml
spring:
  cloud:
    sentinel:
      transport:
        port: 8719
        dashboard: localhost:8080
```

#### nacos config 统一的配置中心