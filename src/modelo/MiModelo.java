/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dam
 */
public class MiModelo extends DefaultTableModel{

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        
    }
    
    
    
}
