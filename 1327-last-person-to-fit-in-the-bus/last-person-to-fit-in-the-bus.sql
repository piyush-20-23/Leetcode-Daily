# Write your MySQL query statement below
with running_sum as(
    select 
        person_name
        , SUM(weight) OVER(ORDER BY turn) as s
    from Queue
)

select 
    person_name
from running_sum
where s <= 1000
order by s desc
limit 1