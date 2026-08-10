# Write your MySQL query statement below
select p.product_name ,sum(o.unit)as unit
from Products p left join Orders o on p.product_id=o.product_id
and month(o.order_date)='02'and year(o.order_date)='2020'
group by p.product_id having sum(unit)>=100