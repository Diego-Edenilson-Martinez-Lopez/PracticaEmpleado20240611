/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author MINEDUCYT
 */
public class Empleado {
    
    private int EmpleadoId;
    private String  Nombre ;
    private String Apellido;
    private String Cargo;
    private double Salario;

    public Empleado() {
    }

    public Empleado(int EmpleadoId, String Nombre, String Apellido, String Cargo, double Salario) {
        this.EmpleadoId = EmpleadoId;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cargo = Cargo;
        this.Salario = Salario;
    }

    public int getEmpleadoId() {
        return EmpleadoId;
    }

    public void setEmpleadoId(int EmpleadoId) {
        this.EmpleadoId = EmpleadoId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
}
