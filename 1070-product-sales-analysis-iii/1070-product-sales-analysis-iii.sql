with cte as (
    select
        product_id
        , min(year) as first_year
    from Sales
    group by product_id
)

select 
    sales.product_id
    ,sales.year as  first_year
    , sales.quantity 
    , sales.price
from Sales
join cte on cte.first_year = sales.year
    and cte.product_id = sales.product_id
