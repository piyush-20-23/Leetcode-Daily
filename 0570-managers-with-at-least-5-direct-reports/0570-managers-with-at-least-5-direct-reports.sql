# Write your MySQL query statement below

with cte as (
    select 
        e1.name,
        count(e2.managerID) as numberOfPeopleUnder
    from employee e1
    join employee e2
    on e1.id = e2.managerId
    group by e2.managerId
)
select 
    name 
from cte
where numberOfPeopleUnder > 4