#!/bin/bash

# DDLでテーブルを作成する
mysql -u root -proot spring_boot_app < "/docker-entrypoint-initdb.d/sql/schema.sql"

# データを流し込む
mysql -u root -proot spring_boot_app < "/docker-entrypoint-initdb.d/sql/data.sql"