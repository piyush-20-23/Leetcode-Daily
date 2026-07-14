# Write your MySQL query statement below
(
    select 
        m.title as results
    from Movies m
    join MovieRating mr
    on m.movie_id = mr.movie_id
    where month(created_at) = 2
        and year(created_at) = 2020
    group by m.movie_id
    order by avg(mr.rating) desc, m.title
    limit 1 
)
Union all
(
    select 
        u.name as results
    from Users u
    join MovieRating mr
    on u.user_id = mr.user_id
    group by mr.user_id
    order by count(u.user_id) desc, u.name asc
    limit 1
)