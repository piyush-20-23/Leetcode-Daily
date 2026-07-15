# Write your MySQL query statement below

-- first filter on tiv_2015
-- then filter on location 
-- this is because if location id filtered first, it would loose info on duplicate tiv_2015
with filter_tiv_2015 as(
    select 
        pid
        , tiv_2016
    from Insurance
    where tiv_2015 not in (
        select
            tiv_2015
        from Insurance
        group by tiv_2015
        having count(*) = 1
    )
)

-- filter location
, filter_location as(
    select
        pid
        , concat(lat,'-', lon) as loc
    from Insurance
    group by loc
    having count(*) = 1
)

select
    round(sum(tiv_2016), 2) as tiv_2016
from filter_tiv_2015 ft
join filter_location fl
on ft.pid = fl.pid

