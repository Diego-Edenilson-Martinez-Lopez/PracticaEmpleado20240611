/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import Entidades.Empleado;
import Entidades.Vacacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.List;
import java.sql.Statement;


/**
 *
 * @author MINEDUCYT
 */
public class VacacionDAL {
    
    public static int crear(Vacacion vacacion) {
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "INSERT INTO Vacaciones (EmpleadoID, FechaInicio, FechaFin, Motivo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, vacacion.getEmpleado().getEmpleadoId());
                statement.setDate(2, java.sql.Date.valueOf(vacacion.getFechaInicio()));
                statement.setDate(3, java.sql.Date.valueOf(vacacion.getFechaFin()));
                statement.setString(4, vacacion.getMotivo());
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        vacacion.setVacacionID(generatedKeys.getInt(1));
                    }
                }

                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear la vacacion", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int modificar(Vacacion vacacion) {
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "UPDATE Vacaciones SET FechaInicio=?, FechaFin=?, Motivo=?, EmpleadoID=? WHERE VacacionID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setDate(1, java.sql.Date.valueOf(vacacion.getFechaInicio()));
                statement.setDate(2, java.sql.Date.valueOf(vacacion.getFechaFin()));
                statement.setString(3, vacacion.getMotivo());
                statement.setInt(4, vacacion.getEmpleado().getEmpleadoId());
                statement.setInt(5, vacacion.getVacacionID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al modificar la vacacion", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int eliminar(Vacacion vacacion) {
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "DELETE FROM Vacaciones WHERE VacacionID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, vacacion.getVacacionID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al eliminar la vacacion", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static ArrayList<Vacacion> buscar(Vacacion vacacionSearch) {
        ArrayList<Vacacion> vacaciones = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT v.VacacionID, v.FechaInicio, v.FechaFin, v.Motivo, e.EmpleadoID, e.Nombre, e.Apellido, e.Cargo, e.Salario "
                    + "FROM Vacaciones v "
                    + "INNER JOIN Empleados e ON v.EmpleadoID = e.EmpleadoID "
                    + "WHERE e.Nombre LIKE ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + vacacionSearch.getEmpleado().getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Vacacion vacacion = new Vacacion();
                        vacacion.setVacacionID(resultSet.getInt("VacacionID"));
                        vacacion.setFechaInicio(resultSet.getDate("FechaInicio").toLocalDate());
                        vacacion.setFechaFin(resultSet.getDate("FechaFin").toLocalDate());
                        vacacion.setMotivo(resultSet.getString("Motivo"));

                        Empleado empleado = new Empleado();
                        empleado.setEmpleadoId(resultSet.getInt("EmpleadoID"));
                        empleado.setNombre(resultSet.getString("Nombre"));
                        empleado.setApellido(resultSet.getString("Apellido"));
                        empleado.setCargo(resultSet.getString("Cargo"));
                        empleado.setSalario(resultSet.getDouble("Salario"));
                        vacacion.setEmpleado(empleado);

                        vacaciones.add(vacacion);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar vacaciones", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return vacaciones;
    }
}

