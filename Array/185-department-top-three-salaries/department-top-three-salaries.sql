# Write your MySQL query statement below
with department_salary as(
    select name as Employee,salary,departmentId  as id,dense_rank()over(partition by departmentId  order by salary desc) as ranki
    from Employee
)
select 
d.name as Department ,ds.Employee as Employee ,ds.salary as Salary
from department_salary as  ds left join Department as d on ds.id=d.id
where ds.ranki<=3