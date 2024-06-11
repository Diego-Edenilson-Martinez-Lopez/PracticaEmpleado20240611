/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author MINEDUCYT
 */
public class Vacacion {

    private int vacacionID;
    private int empleadoID;
    private Empleado empleado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String motivo;

    public Vacacion() {
    }

    public Vacacion(int vacacionID, int empleadoID,  LocalDate fechaInicio, LocalDate fechaFin, String motivo) {
        this.vacacionID = vacacionID;
        this.empleadoID = empleadoID;
        this.fechaInicio = fechaInicio;        
        this.fechaFin = fechaFin;
        this.motivo = motivo;
       
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Vacacion(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getVacacionID() {
        return vacacionID;
    }

    public void setVacacionID(int vacacionID) {
        this.vacacionID = vacacionID;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
