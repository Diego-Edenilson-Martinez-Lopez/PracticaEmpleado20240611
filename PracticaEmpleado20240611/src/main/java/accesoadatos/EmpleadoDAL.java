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
    
    public static Empleado obtenerPorId(int empleadoId) {
        Empleado empleado = null;
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT EmpleadoID, Nombre, Apellido, Cargo, Salario FROM Empleados WHERE EmpleadoID = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, empleadoId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("Nombre");
                        String apellido = resultSet.getString("Apellido");
                        String cargo = resultSet.getString("Cargo");
                        double salario = resultSet.getDouble("Salario");
                        empleado = new Empleado(empleadoId, nombre, apellido, cargo, salario);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener el empleado", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return empleado;
    }
    
    public static void insertar(Empleado empleado) {
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "INSERT INTO Empleados (Nombre, Apellido, Cargo, Salario) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setString(3, empleado.getCargo());
                statement.setDouble(4, empleado.getSalario());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error al insertar el empleado", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static void actualizar(Empleado empleado) {
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "UPDATE Empleados SET Nombre = ?, Apellido = ?, Cargo = ?, Salario = ? WHERE EmpleadoID = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setString(3, empleado.getCargo());
                statement.setDouble(4, empleado.getSalario());
                statement.setInt(5, empleado.getEmpleadoId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error al actualizar el empleado", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static void eliminar(int empleadoId) {
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "DELETE FROM Empleados WHERE EmpleadoID = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, empleadoId);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error al eliminar el empleado", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
}
