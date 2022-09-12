package interpretejlexcup.analisador;

import java.util.ArrayList;
import java.util.LinkedList;


public class While implements Instruccion {

    private LinkedList<Instruccion> instrucciones;
    private nodoAST hijos;
    private Operacion condicion;
    
    public While(Operacion condicion,LinkedList<Instruccion> instrucciones){
        this.instrucciones = instrucciones;
        this.hijos = new nodoAST("INSTRUCCIONES");
        this.condicion = condicion;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        String listinstrucciones = "";    
        for(Instruccion ins:this.instrucciones){
            if(ins!=null)
                listinstrucciones += ins.ejecutarPython(t+"\t");
        }
        return t+"while "+String.valueOf(this.condicion.ejecutarPython(""))+":"+listinstrucciones;
    }

    @Override
    public Object ejecutarGolang(String t) {
        String listinstrucciones = "";    
        for(Instruccion ins:this.instrucciones){
            if(ins!=null)
                listinstrucciones += ins.ejecutarGolang(t+"\t");
        }
        return t+"for true{\n"+
                t+"\tif !("+String.valueOf(this.condicion.ejecutarGolang(""))+"){\n"+
                t+"\t\tbreak\n"+
                t+"\t}\n"+
                t+listinstrucciones+
                t+"}";
    }

    @Override
    public nodoAST getNodo() {
        for(Instruccion ins:this.instrucciones){
            if(ins!=null)
                this.hijos.addHijo(null,ins.getNodo());
        }
        
        nodoAST nodo = new nodoAST("WHILE");
        nodo.addHijo("mientras", null);
        nodo.addHijo(null, this.condicion.getNodo());
        nodo.addHijo("hacer", null);
        nodo.addHijo(null,this.hijos);
        nodo.addHijo("fin_mientras", null);
        
        return nodo;
    }
    
}
