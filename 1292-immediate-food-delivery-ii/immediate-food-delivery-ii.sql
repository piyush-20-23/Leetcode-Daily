with first_order as
(
    select
        customer_id
        , min(order_date) as first_order
    from Delivery
    group by customer_id
)

select 
    round(
        avg(
            case
            when d.order_date = d.customer_pref_delivery_date 
            then 1
            else 0
            end
        ) * 100
        ,2
    ) as immediate_percentage 
    
from first_order fo
join Delivery d
on fo.customer_id = d.customer_id
    and fo.first_order = d.order_date 







