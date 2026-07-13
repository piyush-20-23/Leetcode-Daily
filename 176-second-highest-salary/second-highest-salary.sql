# Write your MySQL query statement below

-- select (
--     select distinct salary 
--     from employee
--     order by salary desc
--     limit 1 offset 1
-- ) as SecondHighestSalary 

with salary_rank as (
    select
        *
        , dense_rank() over(order by salary desc) as r
    from employee
)

select (
    select 
        distinct salary 
    from salary_rank
    where r = 2
) as SecondHighestSalary 

