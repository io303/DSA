# Write your MySQL query statement below
select distinct s1.num as ConsecutiveNums
from Logs s1,Logs s2,Logs s3
where s1.id=s2.id-1 and s2.id=s3.id-1 and s1.num=s2.num and s2.num=s3.num;