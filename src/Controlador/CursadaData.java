/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Cursada;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo2
 */
public class CursadaData {
    private Conexion conexion;
    private Connection connection = null;

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public CursadaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            mensaje("Error al cargar los drivers: " + ex.getMessage());
        }
    }
public Alumno buscarAlumno(int id){
    
        AlumnoData ad=new AlumnoData(conexion);
        
        return ad.buscarAlumno(id);
        
    }
    
    public Materia buscarMateria(int id){
    
        MateriaData md=new MateriaData(conexion);
        return md.buscarMateria(id);
    
    }
    public void guardarCursada(Cursada cursada) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cursada VALUES (NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursada.getAlumno().getId_alumno());
            ps.setInt(2, cursada.getMateria().getId_materia());
            ps.setDouble(3, cursada.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cursada.setId(rs.getInt(1));
                mensaje("Se ha guardado correctamente la nota del alumno");
            } else {
                mensaje("No se ha guardado correctamente la nota del alumno");
            }
        } catch (SQLException ex) {
            mensaje("Error al guardar la nota del alumno: " + ex.getMessage());
        }
    }

    public ArrayList<Cursada> obtenerCursadas() {
        ArrayList<Cursada> lista = new ArrayList<>();
        Cursada cursada;
        Alumno a;
        
        try {
            String sql = "SELECT * FROM cursada;";
            PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    cursada = new Cursada();
                    a = new Alumno();
                    cursada.setId(resultSet.getInt("id_cursada"));
                    
                    a= buscarAlumno(resultSet.getInt("id_alumno"));
                    cursada.setAlumno(a);
                    
                    Materia m=buscarMateria(resultSet.getInt("id_materia"));
                    cursada.setMateria(m);
                    cursada.setNota(resultSet.getInt("nota"));
                    
                    
                    lista.add(cursada);
                }
            
            statement.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener las cursadas: " + ex.getMessage());
        }
        if (lista.isEmpty()) {
            mensaje("La base de datos se encuentra vacia");
        }
        return lista;
    }

    public ArrayList<Cursada> obtenerCursadasXAlumno(int id_alumno) {
        ArrayList<Cursada> lista = new ArrayList<>();
        Cursada cursada;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cursada WHERE id_alumno = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cursada = new Cursada();
                cursada.setId(rs.getInt("id_cursada"));
                //cursada.getAlumno().setId_alumno(rs.getInt("id_alumno"));
                Alumno a=buscarAlumno(rs.getInt("id_alumno"));
                cursada.setAlumno(a);
                //cursada.getMateria().setId_Materia(rs.getInt("id_materia"));
                Materia m=buscarMateria(rs.getInt("id_materia"));
                cursada.setMateria(m);
                cursada.setNota(rs.getInt("nota"));
                lista.add(cursada);
            }
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al buscar al alumno con la id ingresada: " + ex.getMessage());
        }
        if (lista.isEmpty()) {
            mensaje("La base de datos se encuentra vacia");
        }
        return lista;
    }

    public ArrayList<Materia> obtenerMateriasCursadas(int id_alumno) {
        ArrayList<Materia> lista = new ArrayList<>();
        Materia m;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cursada, materia WHERE cursada.id_materia = materia.id_materia and cursada.id_alumno = ?");
                    //"SELECT id_materia, nombre_materia, año, estado FROM materia, cursada WHERE materia.id_materia = cursada.id_materia and cursada.id_alumno = ?;");
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setId_Materia(rs.getInt("id_materia"));
                m.setNombre_materia(rs.getString("nombre_materia"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                lista.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al buscar al alumno con la id ingresada: " + ex.getMessage());
        }
        if (lista.isEmpty()) {
            mensaje("La base de datos se encuentra vacia");
        }
        return lista;
    }

    public ArrayList<Materia> obtenerMateriasNOCursadas(int id_materia) {
        ArrayList<Materia> noCursada = new ArrayList<>();
        Materia m;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM materia WHERE id_materia NOT IN(SELECT materia.id_materia FROM materia, cursada WHERE materia.id_materia = cursada.id_materia AND cursada.id_alumno = ?);");
            ps.setInt(1, id_materia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setId_Materia(rs.getInt("id_materia"));
                m.setNombre_materia(rs.getString("nombre_materia"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                noCursada.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al consultar la tabla: " + ex.getMessage());
        }
        if (noCursada.isEmpty()) {
            mensaje("La lista esta vacia.");
        }
        return noCursada;
    }

    public void borrarCursadaDeUnaMateriaDeunAlumno(int id_alumno, int id_materia) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM cursada WHERE id_alumno = ? AND id_materia = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_alumno);
            ps.setInt(2, id_materia);
            if (ps.executeUpdate() == 1) {
                mensaje("La nota del alumno ha sido borrada correctamente");
            } else {
                mensaje("La nota del alumno no ha sido borrada.");
            }
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al borrar la nota del alumno: " + ex.getMessage());
        }
    }

    public void actualizarNotaCursada(int id_alumno, int id_materia, double nota) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cursada SET nota = ? WHERE id_alumno = ? AND id_materia = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, id_alumno);
            ps.setInt(3, id_materia);
            if (ps.executeUpdate() == 1) {
                mensaje("La nota del alumno ha sido actualizada correctamente.");
            } else {
                mensaje("La nota del alumno ha podido ser actualizada correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la nota de un alumno: " + ex.getMessage());
        }
    }

    private void JOptionPane(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
