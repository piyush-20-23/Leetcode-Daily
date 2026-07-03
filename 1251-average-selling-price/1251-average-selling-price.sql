# Write your MySQL query statement below
with cte as(
    select 
        p.*
        ,u.purchase_date
        ,u.units
    from prices p
    left join unitsSold u
    on p.product_id = u.product_id
        and u.purchase_date between p.start_date and p.end_date
)

select 
    product_id
    ,coalesce(round(sum(price * units) / sum(units), 2) , 0) as average_price
from cte
group by product_id

