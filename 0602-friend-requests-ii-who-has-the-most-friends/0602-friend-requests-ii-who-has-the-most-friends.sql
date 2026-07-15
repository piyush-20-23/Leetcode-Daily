with cte as(
    (select 
        requester_id as id
        , count(*) as num
    from RequestAccepted
    group by requester_id)

    union all

    (select 
        accepter_id as id
        , count(*) as num
    from RequestAccepted
    group by accepter_id)
)

, id_sum as(
    select 
        id
        , sum(num) as num
    from cte
    group by id
)

select 
    id
    , num
from id_sum
where num = (
    select
        max(num) as num
    from id_sum
)
