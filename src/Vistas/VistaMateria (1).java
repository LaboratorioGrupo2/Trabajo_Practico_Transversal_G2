/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.logging.Level;
import java.util.logging.Logger;
import Controlador.Conexion;
import Modelo.Materia;
import Controlador.MateriaData;
import javax.swing.JOptionPane;

/**
 *
 * @author Grpo2
 */
public class VistaMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaMateria
     */
    private MateriaData materiaData;
    private Conexion conexion;
    
    public VistaMateria() {
        initComponents();
        try {
            initComponents();
            conexion= new Conexion();
            materiaData= new MateriaData(conexion);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo crear la MateriaData");
            Logger.getLogger(VistaMateria.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tIdMateria = new javax.swing.JTextField();
        tNombreMateria = new javax.swing.JTextField();
        bBuscarMateria = new javax.swing.JButton();
        bGuardarMateria = new javax.swing.JButton();
        bBorrarMateria = new javax.swing.JButton();
        bActualizarMateria = new javax.swing.JButton();
        bLimpiarMateria = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tAño = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCActiva = new javax.swing.JCheckBox();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("-MATERIAS-");

        jLabel3.setText("ID");

        jLabel4.setText("NOMBRE:");

        bBuscarMateria.setText("Buscar");
        bBuscarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarMateriaActionPerformed(evt);
            }
        });

        bGuardarMateria.setText("Guardar");
        bGuardarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarMateriaActionPerformed(evt);
            }
        });

        bBorrarMateria.setText("Borrar");
        bBorrarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarMateriaActionPerformed(evt);
            }
        });

        bActualizarMateria.setText("Actualizar");
        bActualizarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarMateriaActionPerformed(evt);
            }
        });

        bLimpiarMateria.setText("Limpiar");
        bLimpiarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarMateriaActionPerformed(evt);
            }
        });

        jLabel5.setText("AÑO:");

        jLabel6.setText("ACTIVA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bGuardarMateria)
                                        .addGap(45, 45, 45)
                                        .addComponent(bBorrarMateria)
                                        .addGap(45, 45, 45)
                                        .addComponent(bActualizarMateria)
                                        .addGap(45, 45, 45)
                                        .addComponent(bLimpiarMateria))
                                    .addComponent(jLabel5))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCActiva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tNombreMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(tIdMateria)
                                    .addComponent(tAño, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bBuscarMateria)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarMateria))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCActiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardarMateria)
                    .addComponent(bBorrarMateria)
                    .addComponent(bActualizarMateria)
                    .addComponent(bLimpiarMateria))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarMateriaActionPerformed
       String nombre;
        int año;
        boolean activa;
        
        Materia m;
        
        nombre = tNombreMateria.getText();
            año = Integer.parseInt(tAño.getText().trim());
            activa = jCActiva.isSelected(); 
        m = new Materia(nombre,año,activa);
        materiaData.guardarMateria(m);
       
        tIdMateria.setText(m.getId_materia() + "");                                                                         
    
    }//GEN-LAST:event_bGuardarMateriaActionPerformed

    private void bBorrarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarMateriaActionPerformed
        
        
        
        
        /*int id = Integer.parseInt(tIdMateria.getText());
        materiaData.borrarMateria(id);*/
    }//GEN-LAST:event_bBorrarMateriaActionPerformed

    private void bActualizarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarMateriaActionPerformed
        if(tIdMateria.getText() != null){
        
        Materia m = new Materia();
        int idMateria = Integer.parseInt(tIdMateria.getText());
        m = materiaData.buscarMateria(idMateria);
        
        m.setNombre_materia(tNombreMateria.getText());
        m.setAño(Integer.parseInt(tAño.getText().trim()));
        m.setEstado(jCActiva.isEnabled());
        
        materiaData.actualizarMateria(m);
        JOptionPane.showMessageDialog(null, "Materia actualizada");
        }else{
            JOptionPane.showMessageDialog(null, "Falta ingresar el ID de la materia");
        }
        
    }//GEN-LAST:event_bActualizarMateriaActionPerformed

    private void bLimpiarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarMateriaActionPerformed
       tIdMateria.setText("");
        tAño.setText("");
        tNombreMateria.setText("");
        jCActiva.setSelected(false);
    }//GEN-LAST:event_bLimpiarMateriaActionPerformed

    private void bBuscarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarMateriaActionPerformed
        
        String nombre;
        int año;
        boolean estado;
        Materia m = new Materia();
       int idMateria = Integer.parseInt(tIdMateria.getText());
        m = materiaData.buscarMateria(idMateria);
        
        nombre = m.getNombre_Materia();
        año = m.getAño();
        estado = m.isEstado();
        
        tNombreMateria.setText(nombre);
        tAño.setText(String.valueOf(año));
        jCActiva.setSelected(estado);
        
    }//GEN-LAST:event_bBuscarMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizarMateria;
    private javax.swing.JButton bBorrarMateria;
    private javax.swing.JButton bBuscarMateria;
    private javax.swing.JButton bGuardarMateria;
    private javax.swing.JButton bLimpiarMateria;
    private javax.swing.JCheckBox jCActiva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tAño;
    private javax.swing.JTextField tIdMateria;
    private javax.swing.JTextField tNombreMateria;
    // End of variables declaration//GEN-END:variables
}
