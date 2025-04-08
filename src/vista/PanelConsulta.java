/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.Empresa;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.MiModelo;
import modelo.Noticia;

/**
 *
 * @author dam
 */
public class PanelConsulta extends javax.swing.JPanel {

    Empresa empresa;
    int posLog;
    
    MiModelo modelo;
    
    public PanelConsulta(Empresa empresa,int posLog) {
        initComponents();
        this.empresa = empresa;
        this.posLog=posLog;
        
        configurarCuadricula();
        
        mostrarNoticias();
        
    }

    
    private void configurarCuadricula(){
        
        //DEFINICION DEL OBJETO MODELO
        modelo = new MiModelo();
        
        //ARRAY DE LOS TITULOS
        String[] titulos={"CODIGO","TITULO","FECHA","CATEGORIA"};
        
        //ESTABLECER TITULOS
        modelo.setColumnIdentifiers(titulos);
        
        //ESTABLECER NOTICIAS
        tblNoticias.setModel(modelo);
    }
    
    
    private void mostrarNoticias(){
        
        ArrayList<Noticia> noticias = empresa.getNoticias();
        
        for(Noticia n : noticias){
            
            Vector v = new Vector();
            
            //AÑADIR EN ORDEN PARA QUE SE AÑADAN EN ORDEN LAS COLUMNAS
            v.add(n.getCod());
            v.add(n.getTitulo());
            v.add(n.getFecha());
            v.add(n.getCategoria());
            
            
            //AÑADIMOS LA COLECCIÓN VECTOR PARA CARGAR CADA NOTICIAS
            modelo.addRow(v);
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNoticias = new javax.swing.JTable();
        btnEliminarNoticia = new javax.swing.JButton();

        tblNoticias.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNoticias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNoticiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNoticias);

        btnEliminarNoticia.setText("ELIMINAR NOTICIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btnEliminarNoticia)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnEliminarNoticia)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNoticiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNoticiasMouseClicked
       
        int fila=tblNoticias.rowAtPoint(evt.getPoint());
        int columna=tblNoticias.columnAtPoint(evt.getPoint());
        //JOptionPane.showMessageDialog(this, tblNoticias.getValueAt(fila, columna));
        
        //PARA MODIFICAR UNA NOTICIA SI ERES EL AUTOR DE LA MISMA
        //Ver el método comprobarNoticiaUsuario() de la clase Empresa
        int codigoNoticia = (int) tblNoticias.getValueAt(fila, 0);
        
        if(empresa.comprobarNoticiaUsuario(codigoNoticia, posLog)){
            
            /*
            YES_NO_OPTION
            
            0 = YES
            
            1 = NO
            */
            
            int opcion=JOptionPane.showConfirmDialog(this, "¿DESEA BORRAR ESTA NOTICIA?","ELIMINAR",JOptionPane.YES_NO_OPTION);
            
            if(opcion ==0){ 
            //LO BORRA ÚNICAMENTE DEL MODELO (DESAPERECE DE LA TABLA)
            modelo.removeRow(fila);
            
            //LO BORRA DEL ARRAYLIST DE DONDE ESTÁ ALMACENADO
            empresa.eliminarNoticia(codigoNoticia);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this,"NO ERES EL AUTOR DE LA NOTICIA");
        }
        
    }//GEN-LAST:event_tblNoticiasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarNoticia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNoticias;
    // End of variables declaration//GEN-END:variables
}
