
package interpretejlexcup.analisador;

public class Primitivo implements Instruccion{

    private String primitivo;
    
    public Primitivo(String s){
        this.primitivo = s;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        return t+this.primitivo;
    }

    @Override
    public Object ejecutarGolang(String t) {
        return t+this.primitivo;
    }

    @Override
    public nodoAST getNodo() {
        nodoAST nodo = new nodoAST(this.primitivo);
        return nodo;
    }
    
}
