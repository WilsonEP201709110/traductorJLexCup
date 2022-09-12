package interpretejlexcup.analisador;

public class Comentario implements Instruccion{

    private Tipo_comentario tipo;
    private String comentario;
    
    public Comentario(String c,Tipo_comentario tipo){
        this.tipo = tipo;
        this.comentario = c;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        if(this.tipo == Tipo_comentario.SALTO){
            return "\n";
        }
        if(this.tipo == Tipo_comentario.LINE){
            return t+"#"+this.comentario.substring(2);
        }
        if(this.tipo == Tipo_comentario.MULTILINE){
            return t+"\'\'\'"+this.comentario.substring(2, this.comentario.length()-2)+"\'\'\'";
        }
         return null; 
    }

    @Override
    public Object ejecutarGolang(String t) {
        if(this.tipo == Tipo_comentario.SALTO){
            return "\n";
        }
        if(this.tipo == Tipo_comentario.LINE){
            return t+this.comentario;
        }
        if(this.tipo == Tipo_comentario.MULTILINE){
            return t+this.comentario;
        }
         return null;  
    }

    @Override
    public nodoAST getNodo() {
        nodoAST nodo = new nodoAST("COMENTARIO");
        if(this.tipo == Tipo_comentario.SALTO){
            return null;
        }
        nodo.addHijo(this.comentario,null);
        return nodo;
    }
    
}
