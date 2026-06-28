# Write your MySQL query statement below

with start_cte as (
    select 
        machine_id,
        CONCAT(machine_id, "0", process_id) as id,
        timestamp as start
    from Activity
    where activity_type = 'start'
),
end_cte as (
    select
        machine_id,
        CONCAT(machine_id, "0", process_id) as id, 
        timestamp as end 
    from Activity
    where activity_type = 'end'
)

select 
    s.machine_id,
    ROUND(AVG( e.end- s.start), 3) as processing_time 
from start_cte s
join end_cte e
on s.id = e.id
group by machine_id