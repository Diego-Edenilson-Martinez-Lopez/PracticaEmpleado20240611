/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import Entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
public class EmpleadoDAL {
    public static ArrayList<Empleado> obtenerTodos() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT EmpleadoID, Nombre, Apellido, Cargo, Salario FROM Empleados";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {                              
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int empleadoId = resultSet.getInt("EmpleadoID");
                        String nombre = resultSet.getString("Nombre");
                        String apellido = resultSet.getString("Apellido");
                        String cargo = resultSet.getString("Cargo");
                        double salario = resultSet.getDouble("Salario");                       
                        Empleado empleado = new Empleado(empleadoId, nombre, apellido, cargo, salario);
                        empleados.add(empleado);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener los empleados", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return empleados;
    }
}
