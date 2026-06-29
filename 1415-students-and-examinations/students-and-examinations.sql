# Write your MySQL query statement below
# Students 
# Subjects
# Examinations
# find the number of times each student attended each exam

with id_name_subject as(
    select 
        stu.student_id,
        stu.student_name,
        sub.subject_name
    from Students stu
    cross join Subjects sub
    order by student_id, subject_name
)

select 
    ins.*,
    count(ex.student_id) as attended_exams
from id_name_subject ins
left join examinations ex
on ins.student_id = ex.student_id 
    and ins.subject_name = ex.subject_name
group by ins.student_id, ins.subject_name
order by ins.student_id, ins.subject_name 
    