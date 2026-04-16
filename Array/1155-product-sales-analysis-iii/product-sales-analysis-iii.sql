# Write your MySQL query statement below
select product_id, first_year, quantity, price
from (
    select product_id, year as first_year, quantity, price, RANK() over (partition by product_id order by year) as row_num
    from sales
) a
where row_num = 1