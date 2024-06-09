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
   private int VacacionID;
   private LocalDate FechaInicio;
   private LocalDate FechaFin;
   private String Motivo;
   private Empleado empleado;

    public Vacacion() {
    }

    public Vacacion(int VacacionID, LocalDate FechaInicio, LocalDate FechaFin, String Motivo, Empleado empleado) {
        this.VacacionID = VacacionID;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Motivo = Motivo;
        this.empleado = empleado;
    }

    public int getVacacionID() {
        return VacacionID;
    }

    public void setVacacionID(int VacacionID) {
        this.VacacionID = VacacionID;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate FechaFin) {
        this.FechaFin = FechaFin;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
   
           
}
