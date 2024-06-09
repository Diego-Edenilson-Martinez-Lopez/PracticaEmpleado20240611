use PracticaEmpleado20240611

create table Empleados(
EmpleadoID INT PRIMARY KEY IDENTITY(1,1),
Nombre Varchar(100) Not Null,
Apellido Varchar(100) Not Null,
Cargo Varchar (100) Not Null,
Salario Decimal (10,2) Not Null
);

Create Table Vacaciones(
VacacionID INT PRIMARY KEY IDENTITY (1,1),
EmpleadoID INT not Null,
FechaInicio Date Not Null,
FechaFin Date Not null,
Motivo Varchar (200),
FOREIGN KEY (EmpleadoID) References Empleados(EmpleadoID)
);