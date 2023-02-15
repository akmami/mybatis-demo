# MyBatisDemo

This is demo project for MyBatis. The basic insert, delete and update operations are performed on employee object.

The demo is implemented locally on MySQL server and with Spring Framerowk. Also, Apache Tomcat is utilized as web container.

## Used Programs and Packages

### Main

| Name  | Version  |
| :------------ |:---------------:|
| Tomcat   | 8.5.85 |
| MySQL | 8.0.32 |


### Packages


| Name  | Version  |
| :------------ |:---------------:|
| springframework   | 5.1.5 |
| javax | 8.0 |
| jstl  | 1.2 |
| mybatis   | 3.0.4 |
| mybatis-spring    | 1.0.0 |
| mysql-connector-java | 8.0.32 |
| c3p0  | 0.9.1.2 |

## Structure

```
.
├── pom.xml
├── queries.sql
└── src
   └── main
       └── webapp
           └── WEB-INF
               ├── java
               │   ├── com
               │   │   └── akmami
               │   │       └── mybatisdemo
               │   │           ├── controller
               │   │           │   └── EmployeeController.java
               │   │           ├── dao
               │   │           │   ├── EmployeeMapper.java
               │   │           │   └── EmployeeMapper.xml
               │   │           ├── entity
               │   │           │   └── Employee.java
               │   │           └── util
               │   │               └── MyBatisDemoUtil.java
               │   └── resources
               │       └── mybatisdemo-config.xml
               ├── jsps
               │   ├── add-employee.jsp
               │   └── list-employees.jsp
               ├── mybatisdemo-servlet.xml
               └── web.xml

```
