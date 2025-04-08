package controlador;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.Noticia;
import modelo.Usuario;
import utilidades.Encriptar;

/**
 *
 * @author dam
 */
public class Empresa {

    /*
    ********************************************
    <<<<<<<<<<DECLARACIÓN DE ARRAYLIST>>>>>>>>>>
    ********************************************
    Un arraylist tiene la ventaja de ser de tamaño variable (se pueden borrar y)
    añadir registros, pero tiene la desventaja de que hay que realizar busquedas
    en orden secuencial debido a estas modificaciones.
    
    Tiene la siguiente sintaxis:
    ArrayList <[tipo de dato o clase]> [nombre del ArrayList];
    */
    ArrayList<Usuario> usuarios;

    ArrayList<Categoria> categorias;

    private ArrayList<Noticia> noticias;

    public Empresa() {

        /*
        ************************************************
        <<<<<<<<<<INICIALIZACIÓN DEL ARRAYLIST>>>>>>>>>>
        ************************************************
        Para inicializar un ArrayList debemos usar la siguiente sintaxis:
        [nombre del Arraylist] = new ArrayList<>();
        */
        usuarios = new ArrayList<>();

        categorias = new ArrayList<>();

        noticias = new ArrayList<>();

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
        /*
        ***************************************************
        <<<<<<<<<<AÑADIR REGISTROS A UN ARRAYLIST>>>>>>>>>>
        ***************************************************
        Para poder añadir registros a un ArrayList debemos usar la siguiente
        sintaxis:
        
        [nombre del ArrayList].add(new [nombre del tipo de dato o de la clase]([campos a añadir]));
        
        */
        usuarios.add(new Usuario("pepe", "926e27eecdbc7a18858b3798ba99bddd"));
        usuarios.add(new Usuario("admin", "202cb962ac59075b964b07152d234b70"));

        categorias.add(new Categoria("a", "Deportes"));
        categorias.add(new Categoria("b", "Politica"));
        categorias.add(new Categoria("c", "Economia"));
        /*
        ******************************************
        <<<<PARA BORRAR UNA POSICIÓN DEL ARRAY>>>>
        ******************************************
        usuarios.remove([POSICIÓN DEL ARRAY]);
         */
        //usuarios.remove(2);

    }
    
    /*
    **********************************************
    <<<<<<<<<<MÉTODO BUSCAR SIMPLIFICADO>>>>>>>>>>
    **********************************************
    Con este método podemos cumplir con las funciones que nos dan los métodos
    "buscarUsuario2" y "obtenerUsuario", funciona de la siguiente manera:
    
     -Le pasamos en los argumentos el login y la contraseña.
     
     -Creamos la variable de tipo int "pos" le asignamos la función indexOf:
      
       *La función indexOf busca en todas las posiciones del ArrayList la información
        que se le ha pasado en los argumentos y en caso de encontrarla te devuelve la
        posición del Array en la que está, si no la encuentra te devuelve -1.
    
     -Cuando la función indexOf termine su búsqueda declararemos un if para 
      comprobar si la variable pos no es -1, si no lo es, usaremos la función
      equals para comparar la contraseña introducida con la almacenada en el Array,
      en caso de no ser igual nos devolverá -1.
    */
    public int buscar(String nombre, String contra){
        //buscamos en el array de usuarios el nuevo elemento
        int pos = usuarios.indexOf(new Usuario(nombre, contra));
        
        if(pos !=-1){
            //nos ubicamos en ese elemeneto de la coleccion,
            //y de ese elemento queremos la contra y comparamos y es distinta
            //a la contra que se introdujo devuelve -1
            if(!(usuarios.get(pos).getContra().equals(contra))){
                pos=-1;
            }
        }
        return pos;
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

    /*
    **********************************************************
    <<<<<<<<<<OBTENER UN ARRAYLIST COMPLETO (GETTER)>>>>>>>>>>
    **********************************************************
    Para que nos devuelva todo un ArrayList debemos usar el siguiente método:
    
    public ArrayList<[tipo de dato o nombre de la clase]> get[tipo de dato o nombre de la clase]() {
    
        return [nombre del ArrayList];
    
    }
    
    */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    /*
    ************************************************************************
    <<<<<<<<<<OBTENER LA INFORMACIÓN DE UNA POSICIÓN DEL ARRAYLIST>>>>>>>>>>
    ************************************************************************
    -Para obtener la información de una posición del ArrayList usaremos la siguiente sintaxis:
        
        [nombre del ArrayList].get([posición del ArrayList]);
    
    -Para obtener la información de un campo concreto de una posición del ArrayList
     usaremos la siguiente sintaxis:
    
        [nombre del ArrayList].get([posición del ArrayList]).get[nombre del campo]();
    */
    public String datosUsuario(int pos) {

        return usuarios.get(pos).getLogin();

    }
    
    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }
    
    public boolean comprobarNoticiaUsuario(int cod, int posLog){
        
        boolean resultado=false;
        
        int pos = noticias.indexOf(new Noticia(cod));
        
        
        if(pos!=-1){
            
            if(usuarios.get(posLog).getLogin().equals(noticias.get(pos).getUsuario())){
                resultado=true;
            }
            
        }
        return resultado;
    }
    
    public void eliminarNoticia(int codigoNoticia) {
        
        int pos = noticias.indexOf(new Noticia(codigoNoticia));
        
        noticias.remove(pos);
        
    }

    public boolean grabarNoticia(int codigo, String deno, String fecha, String codCate, int posLogin) {
        boolean resultado = false;
        resultado = noticias.contains(new Noticia(codigo));
        if(!resultado){
            Noticia n = new Noticia(codigo, deno, datosUsuario(posLogin), fecha, codCate);
            noticias.add(n);
        }
        return resultado;
    }

    

    

}
