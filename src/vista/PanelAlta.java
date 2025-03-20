package vista;

import controlador.Empresa;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Categoria;
import utilidadesString.Fecha;

/**
 *
 * @author dam
 */
public class PanelAlta extends javax.swing.JPanel {

    Empresa empresa;
    int posLogin;
    DefaultComboBoxModel modelo;

    /**
     * ASIGNAR ELEMENTOS AL PANEL COMBOBOX(LISTA DESPLEGABLE)
     */
    public PanelAlta(Empresa empresa, int posLogin) {
        initComponents();
        this.empresa = empresa;
        this.posLogin = posLogin;
        modelo = new DefaultComboBoxModel();
        cmbCategoria.setModel(modelo);
        modelo.addElement("SLECCIONE UNA CATEGORIA");
        //NECESITAMOS ESTA LÍNEA O LÍNEAS PARA QUE NOS DE LA DENOMINACIÓN EN VEZ DE LA POSICIÓN DE MEMORIA
        //modelo.addElement(empresa.getCategorias().get(0).getDenominacion());
        modelo.addAll(empresa.getCategorias());
        //cmbCategoria.setSelectedIndex(0);
        /*
        modelo.addAll(empresa.getCategorias());
        SOLO CON ESTO AÑADE LA POSICION DE MEMORIA
         */
        txtFecha.setText(new Fecha().fechaEnLetra());
        txtUsuario.setText(empresa.datosUsuario(posLogin));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        jLabel1.setText("CATEGORIA");

        jLabel2.setText("TITULO");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("USUARIO");

        jLabel4.setText("FECHA");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtUsuario.setEditable(false);

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("ALTA DE NOTICIAS");

        jLabel6.setText("CODIGO NOTICIA");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbCategoria, 0, 156, Short.MAX_VALUE)
                            .addComponent(txtTitulo)
                            .addComponent(txtUsuario)
                            .addComponent(txtFecha)
                            .addComponent(txtCodigo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 221, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(btnAceptar)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        
    }//GEN-LAST:event_txtTituloActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        /*SE UTILIZA PARA DETECTAR UN CAMBIO EN EL METODO CORRESPONDIENTE
        JOptionPane.showMessageDialog(this,"HE SELECCIONADO");
         */

    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int posCate;
        int codigo = 0;
        String deno;
        String fecha;
        String titulo;

        try {
            codigo = Integer.parseInt(txtCodigo.getText());
            deno = txtTitulo.getText();
            fecha = txtFecha.getText();
            posCate = cmbCategoria.getSelectedIndex();
            //LA POSICION NOTIENE POR QUÉ COINCIDIR CON EL CODIGO DE LA CATEGORIA
            boolean resultado;
            if (posCate != 0) {
                /*CASTEAR*/
                String codCate = ((Categoria) (modelo.getElementAt(posCate))).getCodigo();
                resultado = empresa.grabarNoticia(codigo, deno, fecha, codCate, posLogin);
                if (!resultado) {
                    JOptionPane.showMessageDialog(this, "NOTICIA GRABADA");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "NOTICIA DUPLICADA");
                }
            } else {
                JOptionPane.showMessageDialog(this, "PRIMERO SELECCIONE UNA CATEGORIA");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "DEBE SER UN CODIGO NUMÉRICO");
        }

    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtTitulo.setText("");
        txtCodigo.setText("");
        cmbCategoria.setSelectedIndex(0);

    }
}
