/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author dam
 */
public class Usuario {
    
    private String login;
    private String contra;

    public Usuario(String login, String contra) {
        this.login = login;
        this.contra = contra;
    }

    public Usuario(String login) {
        this.login = login;
    }
    
    

    public String getLogin() {
        return login;
    }

    public String getContra() {
        return contra;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.login, other.login);
    }
    
    
    
}
