# Write your MySQL query statement below
with cte as(
    select 
        departmentId 
        , name
        , salary
        , dense_rank() over(partition by departmentId order by salary desc) as r
    from employee
)

select
    d.name as Department
    , e.name as Employee
    , e.salary as Salary
from cte e
left join Department d
on e.departmentId = d.id
where r <= 3
