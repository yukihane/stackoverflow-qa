select `学生`, sum(by_month.`出席(授業数)`) as `出席合計`, sum(by_month.`非欠席数`) as `非欠席合計`, sum(by_month.`授業数`) as `授業合計`, (100 * sum(by_month.`非欠席数`) / sum(by_month.`授業数`) ) as `出席率`
from (

    /* ここから前出のクエリ */
    select
        date_format(lectures.finish_time, '%Y%M') as '期間',
        students.name as '学生',
        count(attend_logs.attend_status = 'attended' or null) as `出席(授業数)`,
        count(attend_logs.attend_status = 'absented' or null) as `欠席(授業数)`,
        count(attend_logs.attend_status = 'late' or null) as `遅刻数`,
        count(attend_logs.attend_status = 'late' or null) DIV 3 as `遅刻分欠席(3回で欠席1回)`,
        count(attend_logs.attend_status) as `授業数`,
        (count(attend_logs.attend_status = 'attended' or null ) + (count(attend_logs.attend_status = 'late' or null) - count(attend_logs.attend_status = 'late' or null) DIV 3) + count(attend_logs.attend_status = 'public_absented' or null) + count(attend_logs.attend_status = 'closed' or null )) as `非欠席数`,
        ROUND((count(attend_logs.attend_status = 'attended' or null ) + (count(attend_logs.attend_status = 'late' or null) - count(attend_logs.attend_status = 'late' or null) DIV 3) + count(attend_logs.attend_status = 'public_absented' or null) + count(attend_logs.attend_status = 'closed' or null ))  / count(attend_logs.attend_status),5) * 100 as `出席率合計(%)`
    from
        attend_logs
        join 
        students 
        on 
        attend_logs.student_id = students.id
    join
        lectures
        on
        lectures.id = attend_logs.lecture_id
    where
        lectures.finish_time between '2021/05/01' and '2021/06/30'
    group by students.name, date_format(lectures.finish_time, '%Y%M')
    /* ここまで前出のクエリ */


) by_month
group by `学生`;
