#!/bin/bash
for i in /Users/mineryang/Desktop/7390相关/lecture2/NYSE/NYSE_daily_prices_*.csv
do
  mongoimport --db mydb --collection nyse --type csv --headerline --file $i
done

