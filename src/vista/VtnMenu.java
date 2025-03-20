/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Empresa;

/**
 *
 * @author dam
 */
public class VtnMenu extends javax.swing.JFrame {

    /*
    **********************************
    <<<<<<<<<<OBJETO EMPRESA>>>>>>>>>>
    **********************************
    Crearemos un objeto de tipo empresa para que le pasemos la información 
    de los usuarios de la clase VtnLogin mediante el constructor de esta clase
    */
    Empresa empresa;
    
    /*
    Definiremos una variable de tipo int para poder almacenar la posición del
    ArrayList del usuario que se ha logueado
    */
    int posLog;
    
    /*
    ********************************************************
    <<<<<<<<<<OBJETOS DE LAS CLASES DE LOS PANELES>>>>>>>>>>
    ********************************************************
    Crearemos un objeto de cada clase de cada panel al que vayamos a acceder desde
    este menú, para que podamos añadir el panel cuando sea seleccionado.
    */
    PanelAlta altaNoticia;
    VtnConsultaNoticia consultaNoticia;
    
    
    /*
    **************************************
    <<<<<<<<<<CONSTRUCTOR VTNMENU>>>>>>>>>
    **************************************
    Dentro de los argumentos del constructor le pasaremos en los argumentos el
    objeto de tipo Empresa y la posición del usuario logeado, de esta forma podremos
    pasar la información del usuario a través de las diferentes ventanas del proyecto.
    */
    public VtnMenu(Empresa empresa, int pos) {
        initComponents();
        this.empresa = empresa;
        posLog = pos;
        pack();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuDesconectar = new javax.swing.JMenuItem();
        mnuApagar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAlta = new javax.swing.JMenuItem();
        mnuConsulta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Salir");

        mnuDesconectar.setText("Desconectar");
        mnuDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDesconectarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDesconectar);

        mnuApagar.setText("Apagar");
        mnuApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuApagarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuApagar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Noticias");

        mnuAlta.setText("Alta Noticias");
        mnuAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAlta);

        mnuConsulta.setText("Consulta Noticias");
        mnuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuConsulta);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    ********************************************
    <<<<<<<<<<VOLVER A LA VENTANA LOGIN>>>>>>>>>
    ********************************************
    A través del botón desconectar volveremos a VtnLogin, para ello realizaremos
    un dispose() para eliminar todo el contenido ya cargado, llamaremos al constructor
    de la clase VtnLogin pasandole como argumento el objeto Empresa con la información
    actualizada y realizaremos un pack() para asegurarnos de que cargue el contenido.
    */
    private void mnuDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDesconectarActionPerformed
        dispose();
        new VtnLogin(empresa).setVisible(true);
        pack();  
    }//GEN-LAST:event_mnuDesconectarActionPerformed

    /*
    *************************************
    <<<<<<<<<<APAGAR EL SISTEMA>>>>>>>>>>
    *************************************
    A través de la opción de menu apagar saldremos del programa finalizando la
    ejecución, para ello realizaremos un dispose() para eliminar el contenido ya
    cargado, un pack() para asegurarnos de que se cumple la eliminación y finalizaremos
    la ejecución con la orden:
        System.exit(0;)
    */
    private void mnuApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuApagarActionPerformed
        //ELIMINA TODO EL CONTENIDO DE LA VENTANA PARA LIBERAR MEMORIA
        dispose();
        pack();
        System.exit(0);
    }//GEN-LAST:event_mnuApagarActionPerformed

    /*
    **********************************
    <<<<<<<<<<CARGAR PANELES>>>>>>>>>>
    **********************************
    Para cargar cualquier panel seguiremos la siguiente estructura:
    
     -Primero cargaremos el método eliminarPaneles() que está explicado al final
      de esta clase.
     
     -A continuación cargaremos el objeto creado de la clase de ese panel, pasandole
      como argumento el objeto Empresa para no perder la información del usuario.
    
     -Una vez hayamos caragado el objeto mediante new, usaremos el método
      getContentPane().add([nombre del objeto del panel]) para cargar el panel
      en pantalla.
    
     -Para finalizar realixaremos un pack() para asegurarnos de que los elementos
      se cargan correctamente.
    
     NOTA IMPORTANTE: Las ventanas deben de tener el LayOut BorederLayout ç
     mientras que los paneles pueden tener el LayOut Free Design.
    */
    private void mnuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaActionPerformed
        eliminarPaneles();
        consultaNoticia = new VtnConsultaNoticia(empresa);
        getContentPane().add(consultaNoticia);
        pack();
    }//GEN-LAST:event_mnuConsultaActionPerformed

    private void mnuAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltaActionPerformed
        eliminarPaneles();
        altaNoticia = new PanelAlta(empresa, posLog);
        getContentPane().add(altaNoticia);
        //VUELVE A CARGAR TODO POR SI EL PROGRAMA NO LO HA DETECTADO
        pack();
    }//GEN-LAST:event_mnuAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAlta;
    private javax.swing.JMenuItem mnuApagar;
    private javax.swing.JMenuItem mnuConsulta;
    private javax.swing.JMenuItem mnuDesconectar;
    // End of variables declaration//GEN-END:variables

    /*
    ************************************
    <<<<<<<<<<ELIMINAR PANELES>>>>>>>>>>
    ************************************
    Para poder eliminar las ventanas que hay para poner en pantalla el panel,
    debemos emplear este método en el cuál mediante la orden 
    this.remove([nombre del objeto del panel]); eliminaremos todo lo anterior 
    para poder cargar el panel correctamente, además, encapsularemos esta orden
    dentro de try-catch para evitar errores en tiempo de ejecución.
    
    */
    private void eliminarPaneles() {
        try{
        this.remove(altaNoticia);
        }catch(NullPointerException ex){}
        try{
        this.remove(consultaNoticia);
        }catch(NullPointerException ex){}
    }
}
