# Write your MySQL query statement below
select visited_on, amount, round(amount / 7, 2) as average_amount
from (
    select visited_on, 
           sum(sum(amount)) over (order by visited_on rows between 6 preceding and current row) as amount,
           dense_rank() over (order by visited_on) as rnk
    from Customer
    group by visited_on
) t
where rnk >= 7;