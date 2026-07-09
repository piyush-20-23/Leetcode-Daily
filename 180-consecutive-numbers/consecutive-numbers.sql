SELECT 
    DISTINCT num as ConsecutiveNums
FROM (
    SELECT 
        num,
        LEAD(num) OVER(ORDER BY id) AS lead_no, 
        LAG(num) OVER (ORDER BY id) AS lag_no
    FROM logs
)t
WHERE num=lead_no and num=lag_no;
