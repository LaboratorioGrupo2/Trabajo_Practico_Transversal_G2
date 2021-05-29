/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Controlador.AlumnoData;
import Controlador.Conexion;
import Controlador.CursadaData;
import Controlador.MateriaData;
import Modelo.Alumno;
import Modelo.Cursada;
import Modelo.Materia;


/**
 *
 * @author Grupo2
 */
public class VistaAlumnosMaterias extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ArrayList<Cursada> listaCursadas;
    private ArrayList<Materia> listaMaterias;
    private CursadaData cd;
    private MateriaData md;
    private AlumnoData ad;
    private ArrayList<Alumno> listaAlumnos;
    private Conexion conexion;
//    private Connection connection;
    
    /**
     * Creates new form vistaAlumnoMaterias
     */
    public VistaAlumnosMaterias() {
        initComponents();
        try {
            conexion = new Conexion();
//            connection = conexion.getConexion();


            modelo = new DefaultTableModel();
        
            cd = new CursadaData(conexion);
            md = new MateriaData(conexion);
            ad = new AlumnoData(conexion);
            
            listaCursadas = (ArrayList)cd.obtenerCursadas();
            listaMaterias = (ArrayList)md.obtenerMaterias();
            listaAlumnos = (ArrayList)ad.obtenerAlumnos();
            
            cargarMaterias();
            armarCabeceraTabla();
            cargarDatos();
            
        } 
//        catch (SQLException ex) {
//            System.out.println("Error al obtener la conexion");
//            Logger.getLogger(vistaAlumnoMaterias.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaAlumnosMaterias.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlumnos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setText("Materia:");

        cbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriasActionPerformed(evt);
            }
        });

        tAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriasActionPerformed
        cargarDatos();
    }//GEN-LAST:event_cbMateriasActionPerformed

    public void cargarMaterias(){
        for(Materia m : listaMaterias){
            cbMaterias.addItem(m);
        }
    }
    
    public void armarCabeceraTabla(){
        ArrayList<Object> columnas = new ArrayList<>();
        
        columnas.add("Id");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("Nota");
        
        for(Object columna : columnas){
            modelo.addColumn(columna);
        }
        
        tAlumnos.setModel(modelo);
    }
    
    public void borrarFilasTabla(){
        int nFilas = modelo.getRowCount() - 1;
        
        for(int i = nFilas; i >= 0; i--){
            modelo.removeRow(i);
        }
        
    }
    
    public void cargarDatos(){
        borrarFilasTabla();
        
        Materia materia = (Materia)cbMaterias.getSelectedItem();
        
        for(Cursada cur : listaCursadas){
            if(cur.getMateria().getId_materia() == materia.getId_materia()){
                modelo.addRow(new Object[]{cur.getAlumno().getId_alumno(), cur.getAlumno().getNombre(), cur.getAlumno().getApellido(),
                    cur.getNota()});
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> cbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAlumnos;
    // End of variables declaration//GEN-END:variables
}