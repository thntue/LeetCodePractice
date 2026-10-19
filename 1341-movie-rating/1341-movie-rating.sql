# Write your MySQL query statement below
(select u.name as results
 from MovieRating mr
 join Users u on mr.user_id = u.user_id
 group by u.user_id
 order by count(*) desc, u.name asc
 limit 1)
union all
(select m.title as results
 from MovieRating mr
 join Movies m on mr.movie_id = m.movie_id
 where mr.created_at between '2020-02-01' and '2020-02-29'
 group by m.movie_id
 order by avg(mr.rating) desc, m.title asc
 limit 1);