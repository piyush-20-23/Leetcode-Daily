# Write your MySQL query statement below
with delete_rows as
(select
    min(id) as id
    , count(email) 
from Person 
group by email)

delete
from Person
where id not in (
    select id from delete_rows
)