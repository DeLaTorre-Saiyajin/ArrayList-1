/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import utilidadesString.Fecha;

/**
 *
 * @author dam
 */
public class Noticia {
    
    private int cod;
    private String titulo;
    private String usuario;
    private String fecha;
    private String categoria;

    public Noticia(int cod, String titulo, String usuario, String fecha, String categoria) {
        this.cod = cod;
        this.titulo = titulo;
        this.usuario = usuario;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public Noticia(int cod) {
        this.cod = cod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cod;
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
        final Noticia other = (Noticia) obj;
        return this.cod == other.cod;
    }

    public int getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCategoria() {
        return categoria;
    }
    
    
    
    
}
