cd /joy/

md /joy/db1
md /joy/db2
md /joy/db3

@REM Primary
start "a" mongod --dbpath ./db1 --port 3000 --replSet "demo"

@REM Secondary
start "b" mongod --dbpath ./db1 --port 4000 --replSet "demo"

@REM Arbiter
start "c" mongod --dbpath ./db1 --port 5000 --replSet "demo"
