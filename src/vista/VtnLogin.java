package vista;

import controlador.Empresa;
import javax.swing.JOptionPane;
import modelo.Usuario;
import utilidades.Encriptar;

/**
 *
 * @author dam
 */
public class VtnLogin extends javax.swing.JFrame {

    Empresa empresa;
    /**
     * Creates new form VtnLogin
     */
    public VtnLogin() {
        initComponents();
        /*
        Creamos el objeto de tipo Empresa para poder comenzar a trabajar con los
        ArrayList y métodos de la clase Empresa
        */
        empresa = new Empresa();
        //llamamos al metodo anadir()
        empresa.anadir();
        
        //Establecemos este login predefinido para facilitar las pruebas
        txtLogin.setText("pepe");
        pwdContra.setText("pepe");
    }
    
    /*
    *********************************************************
    <<<<<<<<<<TRANSFERENCIA DE DATOS ENTRE VENTANAS>>>>>>>>>>
    *********************************************************
    Cuando cambiemos de ventana y se realicen cambios de los datos en la misma,
    a la hora de volver a esta ventana debemos asegurar que los datos modificados
    también vuelvan.
    
    Crearemos un segundo constructor al que llamaremos en otras clases y al cuál
    le pasaremos los datos modificados en los argumentos del constructor
    */
    public VtnLogin(Empresa empresa) {
        initComponents();
        this.empresa = empresa;
        //VUELVE A CARGAR TODO POR SI EL PROGRAMA NO LO HA DETECTADO
        pack();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        pwdContra = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("USUARIO");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("CONTRASEÑA");

        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogin)
                            .addComponent(pwdContra, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwdContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    *********************************
    <<<<<<<<<<BOTÓN ACEPTAR>>>>>>>>>>
    *********************************
    Obtenemos el login y la contraseña introducidas y lo almacenamos en variables.
    La contraseña la ciframos y la almacenamos en otra variable, ya que será la que
    introduciremos en el método "buscar" porque la contraseña almacenada en el ArrayList
    está también encriptada.
    
     -En caso de que el resultado no sea -1, el login será correcto, realizaremos
      un dispose() para eliminar la ventana "VtnLogin" y llamaremos al constructor
      de la clase "VtnMenu" para caragar su ventana y establecer su visibilidad en
      verdadero gracias al método de Java setVisible(true). Para asegurarnos de que
      se carga la ventana correctamente realizaremos un pack().
    
    
    */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        String login = txtLogin.getText();
        String password = new String(pwdContra.getPassword()); // Obtener contraseña ingresada
        String passwordEncriptada = Encriptar.getMD5(password); // Cifrar en MD5

        int resultado = empresa.buscar(login, passwordEncriptada);
        
        if (resultado != -1) {
            JOptionPane.showMessageDialog(this, "Usuario existente", "INFO", JOptionPane.INFORMATION_MESSAGE);         
            //ELIMINA TODO EL CONTENIDO DE LA VENTANA PARA LIBERAR MEMORIA
            dispose();
            //el menu necesita la empresa y el usuario(su posicion)
            //new VtnMenu(empresa, empresa.getUsuarios().get(resultado)).setVisible(true);
            new VtnMenu(empresa, resultado).setVisible(true);
            //VUELVE A CARGAR TODO POR SI EL PROGRAMA NO LO HA DETECTADO
            pack();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario inexistente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
    
    }//GEN-LAST:event_btnAceptarActionPerformed

    /*
    **********************************
    <<<<<<<<<<BOTÓN CANCELAR>>>>>>>>>>
    **********************************
    Para que al pulsar el botón CANCELAR se borre la información introducida
    para volverla a introducir sólo debemos asignarle a los campos "txtLogin"
    y "pwdContra" un valor vacío, de esta forma se borrará la información introducida.
    */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtLogin.setText("");
        pwdContra.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pwdContra;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
