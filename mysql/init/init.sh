#!/bin/bash

# mysql -u root -proot sample < "/docker-entrypoint-initdb.d/sql/init.sql"

# DDLでテーブルを作成する
mysql -u root -proot sample < "/docker-entrypoint-initdb.d/sql/schema.sql"

# データを流し込む
mysql -u root -proot sample < "/docker-entrypoint-initdb.d/sql/data.sql"