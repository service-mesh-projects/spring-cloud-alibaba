## 启动
1. 环境准备
  - nacos: `sh ./docker/nacos/startup.sh`
  - seata-server
    - 导入配置: `sh ./docker/seata-server/conf/nacos-config.sh ${nacos-address}`
    - 启动: `sh ./docker/seata-server/bin/seata-server.sh`
  - mysql
    - 创建数据库: `db_springcloud`
    - 创建 undo_log 表: `./docker/seata-server/conf/seata.sql`
    - 创建 demo 表: `./docs/db`
2. 配置 host
  - mysql.localhost
  - localhost
  - nacos.localhost
3. 启动项目
  - project-services