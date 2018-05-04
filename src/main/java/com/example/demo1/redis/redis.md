##https://redis.io/download
```
$ wget http://download.redis.io/releases/redis-4.0.9.tar.gz
$ tar xzf redis-4.0.9.tar.gz
$ cd redis-4.0.9
$ make
安装完毕
-----
启动
$ src/redis-server
------
链接
$ src/redis-cli
redis> set foo bar
OK
redis> get foo
"bar"
```
