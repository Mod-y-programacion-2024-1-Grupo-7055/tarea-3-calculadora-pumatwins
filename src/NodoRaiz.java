import java.util.*;
/**
 * 
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class NodoRaiz extends NodoOperador {

    /**
     *
     * @param izq
     * @param der
     */
    public NodoRaiz(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence = 2;
    }

    /**
     * * La evaluación del nodo, resta la evaluación de los hijos izquierdo y derecho.
     * @return
     */
    @Override
    public double evalua() {
        return Math.sqrt(der.evalua());
    }
}


