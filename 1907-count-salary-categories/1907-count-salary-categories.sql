# Write your MySQL query statement below
with category_col as (
    select
        sum(case when income < 20000 then 1 else 0 end ) as low_income
        , sum(case when income > 50000 then 1 else 0 end) as high_income
        , sum(case when income between 20000 and 50000 then 1 else 0 end) as avg_income
    from accounts
)

select 
    'Low Salary' as category
    , low_income as accounts_count
from category_col

UNION ALL 

select 
    'Average Salary' as category
    , avg_income as accounts_count
from category_col

UNION ALL 

select 
    'High Salary' as category
    , high_income as accounts_count
from category_col