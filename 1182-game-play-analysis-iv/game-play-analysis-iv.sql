with cte as 
(select 
    player_id
    , min(event_date) as first_login
from Activity
group by player_id)

-- select 
--     a.*
--     , c.*
-- from cte c
-- join Activity a
-- on a.player_id = c.player_id
--     and a.event_date = c.first_login

SELECT
ROUND(
    SUM(
        IF(date_add(F.first_login, interval 1 day) = A.event_date, 1, 0))
        /
        COUNT(DISTINCT A.player_id)
        ,2)
        AS fraction
FROM Activity AS A
JOIN cte AS F
ON F.player_id = A.player_id;

