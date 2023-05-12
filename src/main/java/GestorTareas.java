import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author JorgeRR 
 * @version 05
 */
public class GestorTareas {
    private ArrayList<Tarea> tareas;
    
    public GestorTareas() {
        tareas = new ArrayList<>();
    }
    
    /**
     * Metodo 'agregarTarea' que agrega una tarea al final de la lista.
     * Requiere un parametro de tipo String con el contenido de la tarea.
     */
    public void agregarTarea(String tarea) {
        tareas.add(new Tarea(tarea));
    }
    
    /**
     * Método 'devolverTareas' que devuelve un String con todas las tareas, una
     * en cada línea. Si no hay tareas, esa línea contiene la cadena
     * vacía. No requiere parametros.
     */
    public String devolverTareas() {
        String todasLasTareas = "";
            for(Tarea tarea : tareas) {
                todasLasTareas = todasLasTareas +  tarea + "\n";
            }
        return todasLasTareas;
    }
    
    /**
     * Metodo 'getNumeroTareas' que devuelve el numero de tareas pendientes
     * existentes. No requiere parámetros.
     */
    public int getNumeroTareas() {
        return tareas.size();
    }
    
    /**
     * Metodo 'getNumeroTareas2' que devuelve el numero de tareas pendientes
     * actuales y no requiere parámetros. No se puede usar el metodo size de la
     * clase ArrayList.
     */
    public int getNumeroTareas2() {
        int numTareas = 0;
        for(Tarea tarea : tareas) {
            numTareas++;
        }
        return numTareas;
    }
    
    /**
     * Metodo 'getTareaMasAntigua' que devuelve la primera tarea que se agrego 
     * al gestor de tareas; si no tareas devuelve la cadena vacia. No requiere
     * parametros.
     */
    public Tarea getTareaMasAntigua() {
        Tarea tareaMasAntigua;
        if(tareas.size() != 0) {
            tareaMasAntigua = tareas.get(0);
        } else {
            tareaMasAntigua = null;
        }
        return tareaMasAntigua;
    }
    
    /**
     * Metodo 'imprimirTareaMasAntigua' que imprime la primera tarea que se agrego
     * al gestor de tareas; si no hay tareas imprime una línea en blanco. No
     * requiere parametros.
     */
    public void imprimirTareaMasAntigua() {
        String tareaMasAntigua;
        if(tareas.size() == 0) {
            tareaMasAntigua = "";
        } else {
            tareaMasAntigua = tareas.get(0).getTextoTarea();
        }
        System.out.println(tareaMasAntigua);
    }
    
    /**
     * Metodo 'getListadoTareas' que devuelve un String con todas las tareas pendientes, 
     * una en cada línea, precedidas de su posicion (empezando en 1), un punto y un espacio 
     * (por ejemplo: "1. Hacer la cama"). Si no hay tareas devuelve la cadena vacía.
     * No requiere parametros.
     */
    public String getListadoTareas() {
        String listadoTareas = "";
        int indice = 1;
        for(Tarea tarea : tareas) {
            listadoTareas += indice + ". " + tarea.getTextoTarea() + "\n";
            indice++;
        }
        return listadoTareas;
    }
    
    /**
     * Metodo 'imprimirListadoTareas' que imprime por pantalla todas las tareas pendientes, 
     * una en cada línea, precedidas de su posicion (empezando en 1), un punto y un espacio 
     * (por ejemplo: "1. Hacer la cama"). Si no hay tareas imprime una línea en blanco. 
     * El método no devuelve nada. No requiere parametros.
     */
    public void imprimirListadoTareas() {
        System.out.println(getListadoTareas());
    }
    
    /**
     * Metodo 'getTareasEnUnaSolaLinea' que devuelve todas las tareas pendientes en una sola 
     * linea separadas por comas, y por un espacio y con dos corchetes al inicio y al final
     * del tipo "[tarea1, tarea2, tarea3]". Si no hay tareas devuelve la cadena "[]". 
     */
    public String getTareasEnUnaSolaLinea() {
        String listadoTareas = "";
        int contador = 0;
        for(Tarea tarea : tareas) {
            if(tareas.size() == 1) {
                listadoTareas = tarea.getTextoTarea();
            } else if(contador == (tareas.size() - 1)){
                listadoTareas += tarea;
            } else {
                listadoTareas += tarea + ", ";
            }
            contador++;
        }
        return "[" + listadoTareas + "]";
    }
    
    /**
     * Metodo 'imprimirTareasEnUnaSolaLinea' que imprime todas las tareas pendientes en una sola 
     * linea separadas por comas, y por un espacio y con dos corcehete al inicio y al final
     * del tipo "[tarea1, tarea2, tarea3]. Si no hay tareas imprime una línea con dos corchetes 
     * del tipo "[]". No requiere parametros.
     */
    public void imprimirTareasEnUnaSolaLinea() {
        System.out.println(getTareasEnUnaSolaLinea());
    }
    
    /**
     * Metodo 'existeTareaConElTexto' que devuelve true si hay al menos una tarea que contenga 
     * el texto indicado como parametro, false en caso contrario. Hay que hacerlo con bucle for-each.
     * Requiere de parametro de tipo String con el texto a buscar.
     */
    public boolean existeTareaConElTexto(String searchString) {
        boolean existe = false;
        for(Tarea tarea : tareas) {
            if(tarea.getTextoTarea().toLowerCase().contains(searchString.toLowerCase())) {
                existe = true;
            }
        }
        return existe;
    }
    
    /**
     * Metodo getTareasImportantes:
     * Devuelve un String con todas las tareas pendientes, una en cada línea,
     * precedidas de su posicion (empezando en 1), un punto y un espacio 
     * (por ejemplo: "1. Hacer la cama (importante)\n3. Estudiar (Importante)\n") 
     * siempre que la tarea contenga la palabra "importante" 
     * (que puede aparecer en mayúsculas o en minúsculas). 
     * Si no hay tareas de ese tipo devuelve la cadena vacía
     */
    public String getTareasImportantes() {
        String tareasImportantes = "";
        int indice = 1;
        for(Tarea tarea : tareas) {
            if(tarea.getTextoTarea().toLowerCase().contains("importante")) {
                tareasImportantes += + indice + ". " + tarea + "\n";
            }
            indice++;
        }
        return tareasImportantes;
    }
    
    /**
     * Metodo imprimirTareasImportantes:
     * Imprime por pantalla todas las tareas pendientes, una en cada línea,
     * precedidas de su posicion (empezando en 1), un punto y un espacio 
     * (por ejemplo: "1. Hacer la cama (importante)\n3. Estudiar (Importante)\n") 
     * siempre que la tarea contenga la palabra "importante"  
     * (que puede aparecer en mayúsculas o en minúsculas). 
     * Si no hay tareas de ese tipo imprime una línea en blanco.
     */
    public void imprimirTareasImportantes() {
        System.out.println(getTareasImportantes());
    }
    
    /**
     * Metodo getTareasImpares:
     * Devuelve un String con todas las tareas pendientes, una en cada línea,
     * precedidas de su posicion (empezando en 1), un punto y un espacio 
     * (por ejemplo: "1. Hacer la cama\n3.Estudiar\n") siempre que la tarea ocupe una posición
     * impar. Si no hay tareas de ese tipo devuelve la cadena vacía.
     */
    public String getTareasImpares() {
        String listadoTareas = "";
        int indice = 1;
        for(Tarea tarea : tareas) {
            if(indice % 2 != 0) {
               listadoTareas += + indice + ". " + tarea.getTextoTarea() + "\n";
            }
            indice++;
        }
        return listadoTareas;
    }
    
    /**
     * Metodo imprimirTareasImpares:
     * Imprime por pantalla todas las tareas pendientes, una en cada línea,
     * precedidas de su posicion (empeza4444444444451ndo en 1), un punto y un espacio 
     * (por ejemplo: "1. Hacer la cama") siempre que la tarea ocupe una posición
     * impar. Si no hay tareas de ese tipo imprime una línea en blanco.
     */
    public void imprimirTareasImpares() {
        System.out.println(getTareasImpares());
    }
    
    /**
     * Metodo 'eliminarTarea'
     * Elimina la tarea cuya numeración obtenida al listar las tareas coincide
     * con el parametro indicado.
     * Devuelve true si la tarea existe y se elimina y false en caso contrario
     */
    public boolean eliminarTarea(int indice) {
        boolean existe = false;
        if(indice < tareas.size() + 1) {
           tareas.remove(indice - 1);
           existe = true;
        }
        return existe;
    }
    
    /**
     * Metodo 'getPrimeraTareaConElTexto'
     * Devuelve un String conteniendo la primera tarea que contenga el texto
     * indicado como parametro. En caso de que no haya ninguna coincidencia
     * devuelve la cadena vacía. Hay que hacerlo con un bucle for-each.
     */
    public String getPrimeraTareaConElTexto(String searchString) {
        String primeraTareaConElTexto = "";
        for(Tarea tarea : tareas) {
            if(primeraTareaConElTexto.equals("")) {
                if(tarea.getTextoTarea().contains(searchString)) {
                    primeraTareaConElTexto = tarea.getTextoTarea();
                }
            }
        }
        return primeraTareaConElTexto;
    }
    
    /**
     * Metodo 'getListadoTareasWhile'
     * Devuelve un String con todas las tareas pendientes, una en cada línea, ç
     * precedidas de su posicion (empezando en 1), un punto y un
     * espacio (por ejemplo: "1. Hacer la cama"). Si no hay tareas devuelve la
     * cadena vacía. Hay que hacerlo con un bucle while.
     */
    public String getListadoTareasWhile() {
        String listadoTareas = "";
        int contador = 0;
        while(contador < tareas.size()) {
            listadoTareas = listadoTareas + (contador + 1) + ". " + tareas.get(contador) + "\n";
            contador++;
        }
        return listadoTareas;
    }
    
    /**
     * Metodo 'imprimirListadoTareasWhile'
     * Imprime por pantalla todas las tareas
     * pendientes, una en cada línea, precedidas de su posicion (empezando en 1), un
     * punto y un espacio (por ejemplo: "1. Hacer la cama"). Si no hay tareas
     * imprime una línea en blanco. El método no devuelve nada.
     */
    public void imprimirListadoTareasWhile() {
        System.out.println(getListadoTareasWhile());
    }
    
    /**
     * Metodo 'getPrimeraTareaConElTextoWhile'
     * Devuelve un String conteniendo la primera
     * tarea que contenga el texto indicado como parametro. En caso de que no haya
     * ninguna coincidencia devuelve la cadena vacía. Hay que hacerlo con un bucle
     * while. La coincidencia tiene que ser case-sensitive.
     */
    public String getPrimeraTareaConElTextoWhile(String searchString) {
        String primeraTareaConElTexto = "";
        boolean encontrado = false;
        int contador = 0;
        if(getNumeroTareas() > 0) {
            while(!encontrado && contador < getNumeroTareas()) {
                if(tareas.get(contador).getTextoTarea().contains(searchString)) {
                    primeraTareaConElTexto = tareas.get(contador).getTextoTarea();
                    encontrado = true;
                }
                contador++;
            }
        }
        return primeraTareaConElTexto;
    }
    
    /**
     * Metodo 'imprimePrimeraTareaConTextoWhile'
     * Imprime por pantalla la primera tarea
     * que contenga el texto indicado como parametro. En caso de que no haya ninguna
     * coincidencia imprime una línea en blanco. La coincidencia tiene que ser
     * case-sensitive.
     */
    public void imprimirPrimeraTareaConTextoWhile(String searchString) {
        System.out.println(getPrimeraTareaConElTextoWhile(searchString));
    }
    
    /**
     * Metodo 'getPrimerasTareas'
     * Devuelve un String conteniendo las primeras n tareas
     * (siendo n el parametro del metodo), una en cada linea con su número delante.
     * En caso de que no haya suficientes se devuelven solo las que haya. En caso de
     * no haber tareas se devuelve la cadena vacía.
     */
    public String getPrimerasTareas(int n) {
        String primerasNTareas = "";
        int contador = 0;
        if(n > getNumeroTareas()) {
            while(contador < getNumeroTareas()) {
                primerasNTareas = primerasNTareas + (contador + 1) + ". " + tareas.get(contador) + "\n";
                contador++;
            } 
        } else if(n > 0) {
            while(contador < n) {
                primerasNTareas = primerasNTareas + (contador + 1) + ". " + tareas.get(contador) + "\n";
                contador++;
            }
        }
        return primerasNTareas;
    }
    
    /**
     * Metodo 'imprimePrimerasTareas'
     * Imprime por pantalla las primeras n tareas (siendo
     * n el parametro del metodo), una en cada linea con su número delante. En caso
     * de que no haya suficientes se imprimen solo las que haya. En caso de no haber
     * tareas se imprime una linea en blanco. El metodo no devuelve nada y debe usar
     * el método anterior
     */
    public void imprimePrimerasTareas(int n) {
        System.out.println(getPrimerasTareas(n));
    }
    
    /**
     * Metodo 'hayTareaConElTextoEficiente'
     * Devuelve true si hay al menos una tarea que
     * contenga el texto indicado como parámetro y false en caso contrario. El
     * metodo se debe ejecutar de la forma mas rapida posible
     */
    public boolean hayTareaConElTextoEficiente(String searchString) {
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < getNumeroTareas()) {
            if(tareas.get(contador).getTextoTarea().contains(searchString)) {
                encontrado = true;
            }
            contador++;
        }
        return encontrado;
    }
    
    /**
     * Metodo 'getTareasConElTexto'
     * Devuelve un String conteniendo todas las tareas que
     * contienen el texto indicado como parametro, una en cada linea (sin número
     * asociado). El String devuelto contiene una ultima linea adicional que indica
     * el numero de tareas encontradas o el texto "No se encontraron coincidencias".
     * La coincidencia tiene que ser case-sensitive.
     */
    public String getTareasConElTexto(String searchString) {
        String tareasConElTexto = "";
        int contador = 0;
        for(Tarea tarea : tareas) {
            if(tarea.getTextoTarea().contains(searchString)) {
                tareasConElTexto += tarea.getTextoTarea() + "\n";
                contador++;
            }
        }
        if(contador == 0) {
            tareasConElTexto = "No se encontraron coincidencias";
        } else {
            tareasConElTexto += contador;
        }
        return tareasConElTexto;
    }
    
    /**
     * Metodo 'imprimirTareasConElTexto'
     * Muestra por pantalla todas las tareas que
     * contienen el texto indicado como parametro, una en cada linea. Se imprime una
     * ultima linea adicional que indica el numero de tareas encontradas o el texto
     * "No se encontraron coincidencias" si no hay ninguna que contenga el texto. La
     * coincidencia tiene que ser case-sensitive.
     */
    public void imprimirTareasConElTexto(String searchString) {
        System.out.println(getTareasConElTexto(searchString));
    }
    
    /**
     * Metodo 'eliminaPrimeraTareaConElTexto'
     * Elimina la primera tarea que contiene el
     * texto indicado por parámetro. Devuelve true si se eliminó una tarea o false
     * en caso contrario. Hay que hacerlo lo mas eficiente posible
     */
    public boolean eliminaPrimeraTareaConElTexto(String searchString) {
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < getNumeroTareas()) {
            if(tareas.get(contador).getTextoTarea().contains(searchString)) {
                tareas.remove(contador);
                encontrado = true;
            }
            contador++;
        }
        return encontrado;
    }
    
    /**
     * Metodo 'eliminaTodasLasTareasConElTexto'
     * Elimina todas las tareas que contienen un
     * texto pasado como parametro. Devuelve el numero de tareas eliminadas. Hay que
     * hacerlo con un bucle while.
     */
    public int eliminaTodasLasTareasConElTexto(String searchString) {
        int cantidadTareasEliminadas = 0;
        Iterator<Tarea> it = tareas.iterator();
        while(it.hasNext()) {
            String tarea = it.next().getTextoTarea();
            if(tarea.contains(searchString)) {
                it.remove();
                cantidadTareasEliminadas++;
            }
        }
        return cantidadTareasEliminadas;
    }
    
    /**
     * Metodo 'editarTarea'
     * Modifica el texto de la tarea indicada cuyo numero al
     * listarla coincide con el pasado como primer parametro dejando el texto
     * indicado en el segundo parámetro. Si la operación tiene exito devuelve
     * true; false en caso contrario.
     */
    public boolean editarTarea(int indice, String edicion) {
        boolean exito = false;
        if(indice > 0 && indice <= getNumeroTareas()) {
            tareas.get(indice - 1).setTextoTarea(edicion);
            exito = true;
        }
        return exito;
    }
    
    /**
     * Metodo 'marcarComoCompletada'
     * Marca como completada la tarea cuyo numero al
     * listarla coincide con el pasado como parametro y devuelve true si pudo
     * realizar la operacion o false en caso contrario (se entiende que una tarea
     * que ya esta completada no se puede volver a marcar como completada)
     * No se pueden agregar nuevas clases al proyecto. Tampoco se puede cambiar
     * el texto de una tarea (el resto de método anteriores deben seguir
     * funcionando tal y como estan ahora mismo)
     */
    public boolean marcarComoCompletada(int indice) {
        boolean exito = false;
        if(indice - 1 >= 0 && indice - 1 < getNumeroTareas()) {
            if(tareas.get(indice - 1).getCompletada() == false) {
                tareas.get(indice - 1).setCompletada();
                exito = true;
            }
        }
        return exito;
    }
    
    /**
     * Metodo 'getListaTareasCompletadasYNoCompletadas'
     * Devuelve un String  con todas las
     * tareas una en cada línea, precedidas de su posicion (empezando en 1), un
     * punto un espacio y, si estan completadas, un corchete, una x y otro corchete,
     * y luego el texto de la tarea. Ejemplo de tarea terminada sería
     * "1. [x] Hacer la cama". Ejemplo de tarea no terminada sería "1. Hacer la cama".
     * Si no hay tareas devuelve la cadena vacía. Se asume que las tareas cuando
     * se insertan en el gestor no están completadas. No se pueden agregar nuevas
     * clases al proyecto.
     */
    public String getListaTareasCompletadasYNoCompletadas() {
        String listaCompletasYNo = "";
        int contador = 0;
        for(Tarea tarea : tareas) {
            if(tarea.getCompletada() == true) {
                listaCompletasYNo += (contador + 1) + ". [x] " + tarea.getTextoTarea() + "\n";
            } else {
                listaCompletasYNo += (contador + 1) + ". " + tarea.getTextoTarea() + "\n";
            }
            contador++;
        }
        return listaCompletasYNo;
    }
}