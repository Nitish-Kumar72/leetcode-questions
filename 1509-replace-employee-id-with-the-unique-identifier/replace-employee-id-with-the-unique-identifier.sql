# Write your MySQL query statement below
select Employeeuni.unique_id , Employees.name from 
employees left join 
EmployeeUNI on employees.id = EmployeeUNI.id