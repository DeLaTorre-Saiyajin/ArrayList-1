/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.Usuario;
import utilidades.Encriptar;

/**
 *
 * @author dam
 */
public class Empresa {

    ArrayList<Usuario> usuarios;

    ArrayList<Categoria> categorias;

    public Empresa() {

        usuarios = new ArrayList<>();

        categorias = new ArrayList<>();

    }

    public void anadir() {
        /*
        ******************************************
        <<<<PARA ENCRIPTAR CADA CONTRASEÑA>>>>
        ******************************************
        Primero guardamos la contraseña sin encriptar en una variable y le asignamos
        el método de encriptación MD5, mediante un breakpoint y depuración copiamos
        la contraseña encriptada y la pegamos en el campo de "contra" dentro de la
        inserción del usuario al que le corresponde esa contraseña.
         */
        String contra = "123";
        String encriptado = Encriptar.getMD5(contra);
        usuarios.add(new Usuario("pepe", "926e27eecdbc7a18858b3798ba99bddd"));
        usuarios.add(new Usuario("admin", "202cb962ac59075b964b07152d234b70"));

        categorias.add(new Categoria("1", "Deportes"));
        categorias.add(new Categoria("2", "Politica"));
        categorias.add(new Categoria("3", "Economia"));
        /*
        ******************************************
        <<<<PARA BORRAR UNA POSICIÓN DEL ARRAY>>>>
        ******************************************
        usuarios.remove([POSICIÓN DEL ARRAY]);
         */
        //usuarios.remove(2);

    }

    /*
    *************************************************
    <<<<<<<<<BUSCAR POSICIÓN EN UN ARRAYLIST>>>>>>>>>
    *************************************************
    Buscar usuario y devolver la posición en la lista:
    
    -Le pasamos en los argumentos del método el campo String de login.
    
    -Declaramos un bucle for indicando que se repita mientras "pos" sea más pequeño
     que el tamaño del ArrayList "usuarios.size()".
    
    -Dentro del bucle for comaparamos el login introducido con cada uno de los login
     almacenados en el ArrayList con la siguiente sintaxis:
    
     usuarios.get(pos) ----> PARA INDICAR LA POSICIÓN DE ESPACIO DEL ARRAY
     .getLogin()       ----> PARA QUE NOS DE EL CAMPO DE "Login" ALMACENADO EN EL ARRAY
     .equals([login introducido]) ----> PARA COMPARARLO CON EL LOGIN QUE INTRODUZCA EL USUARIO
    
    */
    public int buscarUsuario2(String login) {
        for (int pos = 0; pos < usuarios.size(); pos++) {
            if (usuarios.get(pos).getLogin().equals(login)) {
                return pos; // Devuelve la posición si lo encuentra
            }
        }
        return -1; // Devuelve -1 si no se encuentra
    }

    
    
    /*
    ********************************************************
    <<<<<<<<<<OBTENER LA INFORMACIÓN DEL ARRAYLIST>>>>>>>>>>
    ********************************************************
    Una vez hayamos obtenido mediante el método anterior la posición del Array 
    desado se lo pasaremos como argumento a este método:
    
    -Declararemos un if en el cuál comprobaremos que la posición sea superior o
     igual a 0 y que sea inferior al número de elementos del array.
     (COMPROBAR QUE LA POSICIÓN DEL ARRAY NO SEA UNA POSICIÓN NULA)
    
    -Si cumple con la condición de if asignaremos un return devolviendo el dato
     de tipo usuario con la siguiente sintaxis:
     usuarios.get(pos) ----> Nos devuelve un dato del tipo de la clase de la que
                             se ha declarado el ARRAYLIST (dato de tipo Usuario)
    */
    public Usuario obtenerUsuario(int posicion) {
        if (posicion >= 0 && posicion < usuarios.size()) {
            return usuarios.get(posicion);
        } else {
            return null; // Devuelve null si la posición es inválida
        }
    }

}
