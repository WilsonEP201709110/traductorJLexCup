
package interpretejlexcup.analisador;

public class Imprimir implements Instruccion {

    private Operacion operacion;
    
    public Imprimir(Operacion operacion){
        this.operacion = operacion;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        return t+"print("+this.operacion.ejecutarPython("")+")";
    }

    @Override
    public Object ejecutarGolang(String t) {
        return t+"fmt.Print("+this.operacion.ejecutarGolang("")+")";
    }

    @Override
    public nodoAST getNodo() {
        nodoAST nodo = new nodoAST("IMPRIMIR");
        nodo.addHijo("imprimir", null);
        nodo.addHijo(null, this.operacion.getNodo());
        return nodo;
    }
    
}
