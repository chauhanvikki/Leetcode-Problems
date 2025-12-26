# Write your MySQL query statement below
select e.name, eu.unique_id from Employees e
LEFT JOIN EmployeeUNI eu
on e.id=eu.id;