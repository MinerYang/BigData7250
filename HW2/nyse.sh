#!/bin/bash
for i in /Users/mineryang/Desktop/NYSE/NYSE_daily_prices_*.csv
do
  mongoimport --db mydb --collection nyse2 --type csv --headerline --file $i
done


