# Write your MySQL query statement below
with 
cte as(
    select id as m from Tree where id not in(select distinct p_id as id from Tree where p_id is not null ) 
)

select id ,case 
when p_id is null then "Root" 
when id in (select m from cte) then "Leaf"
else "Inner"
end as  type
from Tree;
