public class NodoSeno extends NodoOperador {

    /**
     *
     * @param izq
     * @param der
     */
    public NodoSeno(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence = 2;
    }

    /**
     * * La evaluación del nodo, resta la evaluación de los hijos izquierdo y derecho.
     * @return
     */
    @Override
    public double evalua() {
        return Math.sin(der.evalua());
    }
}

