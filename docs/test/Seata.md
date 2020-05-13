## Seata
### 源码相关
#### seata-all
```bash
// 远程调用数据包实体
package io.seata.core.protocol;
// 远程调用的调用方式封装
package io.seata.core.rpc;
// 配置中心
package io.seata.config;
// 注册中心
package io.seata.discovery;

```

### 名词解释
- ACID 事务的关系型数据库
> 原子性(A) + 一致性(C) + 隔离性(I) + 持久性(D)

#### 组件
- TC 事务协调者`seata-server`
> - 维护全局和分支事务的状态，驱动全局事务提交或回滚。
> - Transaction Coordinator

- TM - 事务管理器`seata-all`
> - 定义全局事务的范围：开始全局事务、提交或回滚全局事务。
> - Transaction Manager client

- RM - 资源管理器`seata-all`
> - 管理分支事务处理的资源，与TC交谈以注册分支事务和报告分支事务的状态，并驱动分支事务提交或回滚。
> - Resource Manager client

![image](https://camo.githubusercontent.com/b3a71332ae0a91db7f8616286a69b879fcbea672/68747470733a2f2f63646e2e6e6c61726b2e636f6d2f6c61726b2f302f323031382f706e672f31383836322f313534353239363739313037342d33626365376263652d303235652d343563332d393338362d3762393531333564616465382e706e67)

#### 事务类型
- GT 全局事务
> - Global Transaction

- BT 分支事务
> - Branch Transaction

#### 事务模式
- AT 事务模式
> - Automatic Transaction

- TCC 事务模式
- SAGA 事务模式
- XA 事务模式

### Seata 
#### 事务模式
- AT

- TCC

- SAGA

- XA


----
### Seata Tests
#### 同一个数据库
- 同线程
1. a[db - 新增✔️] -> b[db - ✖️]
> 目标结果: a 数据被回滚

2. a[db - 新增✔️] -> b[db - 新增✔️] -> b[db - ✖️]
> 目标结果: a 数据被回滚, b 数据被回滚

3. a[db - 新增✔️] -> b[db - 新增✔️] -> a[db - ✖️]
> 目标结果: a 数据被回滚, b 数据被回滚

- 不同线程
4. [线程1] a[db - 修改]
   [线程2] a[db - 修改]


