/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Modelo.Alumno;
import Controlador.AlumnoData;
import Controlador.Conexion;
import Modelo.Cursada;
import Controlador.CursadaData;
import Modelo.Materia;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Grpo2
 */
public class VistaCargaNotas extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private ArrayList<Cursada> listaCursada;
    private CursadaData cursadaData;
    private AlumnoData alumnoData;
    private ArrayList<Alumno> listaAlumnos;
    private Conexion conexion;
    /**
     * Creates new form VistaCargaNotas
     */
   
    public VistaCargaNotas() {
        initComponents();
        try {
            conexion = new Conexion();
            modelo=new DefaultTableModel();
            cursadaData = new CursadaData(conexion);
            listaCursada = (ArrayList) cursadaData.obtenerCursadas();
            alumnoData=new AlumnoData(conexion);
            listaAlumnos=(ArrayList)alumnoData.obtenerAlumnos();
            
            
            for (Alumno it:listaAlumnos){
                jcAlumno.addItem(it);
            }
            
            armarCabeceraTabla();
            borrarFilas();
            cargaDatos();
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaCargaNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCursada = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jtNota = new javax.swing.JTextField();
        jbActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("CARGA DE NOTAS");

        jLabel2.setText("Alumnos:");

        jcAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAlumnoActionPerformed(evt);
            }
        });

        jtCursada.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtCursada);

        jLabel3.setText("Nota:");

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbActualizar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAlumnoActionPerformed
        borrarFilas();
        cargaDatos();
    }//GEN-LAST:event_jcAlumnoActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        try{
            double nota = Double.parseDouble(jtNota.getText());            
            int filaSeleccionada = jtCursada.getSelectedRow();      
            
            if(filaSeleccionada != -1){
                Alumno a = (Alumno)jcAlumno.getSelectedItem();

                int idMateria = (int)modelo.getValueAt(filaSeleccionada, 0);
                
                Materia m = cursadaData.buscarMateria(idMateria);
                               
                cursadaData.actualizarNotaCursada(a.getId_alumno(), m.getId_materia(), nota);
                borrarFilas();
                
            }
            jtNota.setText("");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Ingrese un numero");
            jtNota.setText("");
            jtNota.requestFocus();
        }


    }//GEN-LAST:event_jbActualizarActionPerformed
    
    public void armarCabeceraTabla(){
        List<Object> columnas = new ArrayList<>();
                
        columnas.add("ID");
        columnas.add("Materia");
        columnas.add("Año");
        columnas.add("Nota");
        
        for(Object columna : columnas){
            modelo.addColumn(columna);
        }
        
        jtCursada.setModel(modelo);
    }
             
        public void borrarFilas(){
         int nFilas = modelo.getRowCount() - 1;
        
        for(int i = nFilas; i >= 0; i--){
            modelo.removeRow(i);
        }
    }
        
        public void cargaDatos(){
            borrarFilas();
        
        Alumno seleccionado = (Alumno)jcAlumno.getSelectedItem();
        listaCursada= (ArrayList)cursadaData.obtenerCursadasXAlumno(seleccionado.getId_alumno());
               
        for(Cursada c : listaCursada){
        modelo.addRow(new Object[]{c.getMateria().getId_materia(), c.getMateria().getNombre_Materia(), c.getMateria().getAño() ,c.getNota()});
        }
        
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JComboBox<Alumno> jcAlumno;
    private javax.swing.JTable jtCursada;
    private javax.swing.JTextField jtNota;
    // End of variables declaration//GEN-END:variables
}
