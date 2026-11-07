# maven-snapshots-proxy

[![Java support](https://img.shields.io/badge/Java-21-green?logo=java&logoColor=white)](https://openjdk.java.net/)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

用于本地代理访问的Maven中央仓库快照元数据的简易Java SpringBoot项目。

结合访问maven-snapshots.wlhhd.cn网页可以快速查询Sonatype Central（Maven 中央仓库）快照仓库中的版本列表与快照文件，方便大家快速查看依赖的快照版本便于交流与学习。

## Java环境要求

JDK 21

## 运行命令

JAVA HOME 为jdk21时运行：

java -jar ~/maven-snapshots-proxy/maven-snapshots-proxy-0.0.1-SNAPSHOT.jar 

使用指定路径的jdk运行：

~/Library/Java/JavaVirtualMachines/jbr-21.0.11/Contents/Home/bin/java -jar  ~/maven-snapshots-proxy/maven-snapshots-proxy-0.0.1-SNAPSHOT.jar

注： 

~/Library/Java/JavaVirtualMachines/jbr-21.0.11/Contents/Home/bin/ 为示例jdk21的实际路径，请按照自己机器的实际路径进行更换

~/maven-snapshots-proxy/maven-snapshots-proxy-0.0.1-SNAPSHOT.jar 为示例jar的实际路径，请按照自己机器的实际路径进行更换

## maven-snapshots.wlhhd.cn访问使用示例：

使用本地代理查询坐标下的版本列表
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind&s=l

使用本地代理查询坐标下的最新版本
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind&s=l&l=true
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind:latest&s=l

使用其他代理查询坐标下的版本列表（更换为实际对应的地址）
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind&s=o&o=http://localhost:8080/api/proxy/repository/maven-snapshots

使用公共代理查询坐标下的版本列表
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind&s=s

使用公共代理查询坐标下的最新版本
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind&s=s&l=true
https://maven-snapshots.wlhhd.cn/zh/query?q=com.fasterxml.jackson.core:jackson-databind:latest&s=s

其他：也可直接使用域名查询
https://maven-snapshots.wlhhd.cn?q=com.fasterxml.jackson.core:jackson-databind&s=l

注：网页参数说明可以访问网页后找到使用说明进行查看

## 声明

上述页面地址及该项目仅作快照版本临时查询参考工具，禁止用于任何违规、非法用途，请遵守相关法律法规