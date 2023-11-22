
public class NodoCoseno extends NodoOperador {

    /**
     *
     * @param izq
     * @param der
     */
    public NodoCoseno(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence = 2;
    }

    /**
     * * La evaluación del nodo, resta la evaluación de los hijos izquierdo y derecho.
     * @return
     */
    @Override
    public double evalua() {
        return Math.cos(der.evalua());
    }
}