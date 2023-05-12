public class Tarea {

    private String textoTarea;
    private boolean completada;

    public Tarea(String textoTarea) {
        this.textoTarea = textoTarea;
        completada = false;
    }

    public String getTextoTarea() {
        return textoTarea;
    }

    public boolean getCompletada() {
        return completada;
    }

    public void setTextoTarea(String texto) {
        textoTarea = texto;
    }

    public void setCompletada() {
        completada = !completada;
    }

    public String toString() {
        return getTextoTarea() + " - " + getCompletada() + "\n";
    }
}
