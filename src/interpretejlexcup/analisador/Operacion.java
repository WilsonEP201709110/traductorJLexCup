
package interpretejlexcup.analisador;

public class Operacion implements Instruccion {
    
    private final Tipo_operacion tipo;
    private Operacion derecha;
    private Operacion izquierda;
    private Primitivo unico;
    
    public Operacion(Operacion derecha,Operacion izquierda,Tipo_operacion tipo){
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.tipo = tipo;
    }
    
    public Operacion(Primitivo p,Tipo_operacion tipo){
        this.unico = p;
        this.tipo = tipo;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        if(this.tipo == Tipo_operacion.PRIMITIVO){
            return String.valueOf(this.unico.ejecutarPython(""));
        }
        
        if(this.tipo == Tipo_operacion.SUMA){
            return String.valueOf(this.derecha.ejecutarPython(""))+" + "+String.valueOf(this.izquierda.ejecutarPython(""));
        }else if(this.tipo == Tipo_operacion.RESTA){
            return String.valueOf(this.derecha.ejecutarPython(""))+" - "+String.valueOf(this.izquierda.ejecutarPython(""));
        }else if(this.tipo == Tipo_operacion.MULTI){
            return String.valueOf(this.derecha.ejecutarPython(""))+" * "+String.valueOf(this.izquierda.ejecutarPython(""));
        }else if(this.tipo == Tipo_operacion.DIVISION){
            return String.valueOf(this.derecha.ejecutarPython(""))+" / "+String.valueOf(this.izquierda.ejecutarPython(""));
        }else if(this.tipo == Tipo_operacion.MODULO){
            return String.valueOf(this.derecha.ejecutarPython(""))+" % "+String.valueOf(this.izquierda.ejecutarPython(""));
        }else if(this.tipo == Tipo_operacion.POTENCIA){
            return String.valueOf(this.derecha.ejecutarPython(""))+" ** "+String.valueOf(this.izquierda.ejecutarPython(""));
        }
        
        if(this.tipo == Tipo_operacion.MENOR){
            return String.valueOf(this.derecha.ejecutarPython(""))+" < "+String.valueOf(this.izquierda.ejecutarPython(""));
        }else if(this.tipo == Tipo_operacion.MAYOR){
            return String.valueOf(this.derecha.ejecutarPython(""))+" > "+String.valueOf(this.izquierda.ejecutarPython(""));
        }
        
        if(this.tipo == Tipo_operacion.AGRUPACION1){
            return "(" + String.valueOf(this.derecha.ejecutarPython(""))+")";
        }
        
        return null;
    }

    @Override
    public Object ejecutarGolang(String t) {
    if(this.tipo == Tipo_operacion.PRIMITIVO){
            return String.valueOf(this.unico.ejecutarGolang(""));
        }
        
        if(this.tipo == Tipo_operacion.SUMA){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" + "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }else if(this.tipo == Tipo_operacion.RESTA){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" - "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }else if(this.tipo == Tipo_operacion.MULTI){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" * "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }else if(this.tipo == Tipo_operacion.DIVISION){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" / "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }else if(this.tipo == Tipo_operacion.MODULO){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" % "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }else if(this.tipo == Tipo_operacion.POTENCIA){
            return "math.Pow(float64("+String.valueOf(this.derecha.ejecutarGolang(""))+"),float64("+String.valueOf(this.izquierda.ejecutarGolang(""))+"))";
        }
        
        if(this.tipo == Tipo_operacion.MENOR){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" < "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }else if(this.tipo == Tipo_operacion.MAYOR){
            return String.valueOf(this.derecha.ejecutarGolang(""))+" > "+String.valueOf(this.izquierda.ejecutarGolang(""));
        }
        
        if(this.tipo == Tipo_operacion.AGRUPACION1){
            return "(" + String.valueOf(this.derecha.ejecutarGolang(""))+")";
        }
        
        return null;    
    }

    @Override
    public nodoAST getNodo() {
        nodoAST nodo = new nodoAST("OPERACION");
        if(this.unico != null){
            nodo.addHijo(null,this.unico.getNodo());
        }else if(this.tipo == Tipo_operacion.AGRUPACION1){
            nodo.addHijo("(",null);
            nodo.addHijo(null,this.derecha.getNodo());
            nodo.addHijo(")",null);
        }else{
            nodo.addHijo(null,this.derecha.getNodo());
            nodo.addHijo(typeoperacion(),null);
            nodo.addHijo(null,this.izquierda.getNodo());   
        }
        return nodo;
    }
    
    private String typeoperacion(){
        if(this.tipo == Tipo_operacion.SUMA) return "+"; 
        if(this.tipo == Tipo_operacion.RESTA) return "-"; 
        if(this.tipo == Tipo_operacion.MULTI) return "*"; 
        if(this.tipo == Tipo_operacion.DIVISION) return "/";
        if(this.tipo == Tipo_operacion.MODULO) return "mod";
        if(this.tipo == Tipo_operacion.POTENCIA) return "potencia"; 
 
        return "Op";
    }
}
