# phlink-common-framework
普惠互联通用框架

## 基础技术
- JDK 1.8
- Springboot 2.1.12
- Mybatis-plus
- Postgres
- Redisson
- 分页使用 pagehelper

## 模块说明
### web-common
web 模块的通用模块
### web-base
web 模块的基础模块，需要开发业务，直接引入该模块即可
- 登录：
    - 支持用户名登录
    - 支持验证码登录
    - 支持手机短信登录
    - 支持登录失败尝试限制 
- 用户权限角色管理
- 统一日志管理
- 字典
- 限流
- 缓存
### web-file-service
文件服务模块，提供文件上传，文件删除等服务，基于fastdfs
### proto
提供 grpc 接口描述
### web-demo
web-base的使用示例

## 整体结构
![整体结构](https://github.com/Sevncz/phlink-common-framework/blob/master/doc/base1.png)

## 整体规划
![整体规划](https://github.com/Sevncz/phlink-common-framework/blob/master/doc/base2.png)
