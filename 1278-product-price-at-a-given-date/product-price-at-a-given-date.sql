# Write your MySQL query statement below
with previous_change as
(select 
    product_id
    , new_price
    , RANK() OVER(Partition by product_id order by change_date desc) as r
from Products
where change_date <= '2019-08-16')

select 
    product_id
    , new_price as price
from previous_change
where r = 1

Union

select 
    product_id
    , 10 as price
from Products
where product_id not in (
    select product_id from previous_change 
)








