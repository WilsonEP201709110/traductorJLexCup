package interpretejlexcup.analisador;


public class Asignacion implements Instruccion {

    private String identificador;
    private Operacion operacion;
    
    public Asignacion(String identificador,Operacion operacion){
        this.identificador = identificador;
        this.operacion = operacion;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        return t+this.identificador+ " = " + this.operacion.ejecutarPython("");
    }

    @Override
    public Object ejecutarGolang(String t) {
        return t+this.identificador+ " = " + this.operacion.ejecutarGolang("");
    }

    @Override
    public nodoAST getNodo() {
        nodoAST nodo = new nodoAST("ASIGNACION");
        nodo.addHijo(this.identificador,null);
        nodo.addHijo("->",null);
        nodo.addHijo(null,this.operacion.getNodo());
        return nodo;
    }
    
}
