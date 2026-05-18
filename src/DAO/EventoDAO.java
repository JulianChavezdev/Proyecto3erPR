package DAO;

import model.Asistente;
import model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventoDAO {

    private String url = "jdbc:mysql://localhost:3306/proyecto";
    private String usuario = "root";
    private String password = "1234";

    public void InsertarEvento(Evento evento){
        try(Connection conexion = DriverManager.getConnection(url,usuario,password)){
            String sql = "INSERT INTO eventos (nombre,ubicacion,fecha, precio) VALUES (?,?,?,?) ";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setString(1, evento.getNombre());
            pstm.setString(2, evento.getUbicacion());
            pstm.setString(3, evento.getFecha());
            pstm.setDouble(4, evento.getPrecio());
            pstm.executeUpdate();

        }catch ( SQLException e){
            System.out.println("Error al insertar evento "+e.getMessage());
        }
    }
    public void ActualizarEvento(Evento e, int id){
        try(Connection conexion = DriverManager.getConnection(url,usuario,password)){
            String sql = "Update eventos SET nombre=?, ubicacion=?,fecha=?,precio=? WHERE id=? ";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getUbicacion());
            pstm.setString(3, e.getFecha());
            pstm.setDouble(4, e.getPrecio());
            pstm.setInt(5, id);
            pstm.executeUpdate();

        }catch (SQLException ev){
            System.out.println("Error al actualizar evento "+ev.getMessage());

        }
    }

    public void BorrarEvento(int id){
        try(Connection conexion = DriverManager.getConnection(url,usuario,password)){
            String sql = "DELETE FROM eventos WHERE id=? ";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            System.out.println("Evento Borrado");
        }catch (SQLException e){
            System.out.println("Error al borrar evento "+e.getMessage());

        }
    }
    public Map<String, Integer> ObtenerEventoConTotalAsistentes(int id){
        Map<String, Integer> mapa = new HashMap<>();
        try (Connection cone = DriverManager.getConnection(url,usuario,password)){
            String sql = "SELECT e.nombre, COUNT(i.asistente_id) AS total_asistentes FROM eventos e LEFT JOIN inscripciones i ON e.id = i.evento_id GROUP BY e.nombre ORDER BY total_asistentes DESC" ;
            PreparedStatement pstm = cone.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                mapa.put(rs.getString("nombre"), rs.getInt("total_asistentes"));

            }
        } catch (SQLException e){
            System.out.println("Error al obtener evento con Asistentes "+e.getMessage());
        }
        return mapa;
    }

    public List<Asistente> ObtenerAsistenteDeEventos(int id){
        List<Asistente> lista = new ArrayList<>();
        try(Connection cone = DriverManager.getConnection(url,usuario,password)){
            PreparedStatement pstm = cone.prepareStatement("SELECT a.nombre FROM eventos e INNER JOIN inscripciones i ON e.id = i.evento_id INNER JOIN  asistentes a ON i.asistente_id = a.id WHERE evento_id = ?");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                lista.add(new Asistente(nombre, email, edad));
            }

        }catch (SQLException e){
            System.out.println("Error al asistentes"+e.getMessage());
        } return lista;
    }

    public Map<String, Integer> ObtenerEventoConMasDe2Asistentes(){
        Map<String, Integer> mapa = new HashMap<>();
        try (Connection cone = DriverManager.getConnection(url,usuario,password)){
            String sql = "SELECT e.nombre, COUNT(i.asistente_id) AS total_asistentes FROM eventos e LEFT JOIN inscripciones i ON e.id = i.evento_id WHERE COUNT(i.asistente_id) < 2 GROUP BY e.nombre ORDER BY total_asistentes DESC" ;
            PreparedStatement pstm = cone.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                mapa.put(rs.getString("nombre"), rs.getInt("total_asistentes"));

            }
        } catch (SQLException e){
            System.out.println("Error al obtener evento con Asistentes "+e.getMessage());
        }
        return mapa;
    }

}
