
package interpretejlexcup.analisador;

import java.util.ArrayList;
import java.util.LinkedList;

public class nodoAST {
    private ArrayList<nodoAST> hijos;
    private String valor;
    
    public nodoAST(String valor){
        this.valor = valor;
        this.hijos = new ArrayList<nodoAST>();
    }
    
    public void setHijos(ArrayList<nodoAST> hijos){
        this.hijos = hijos;
    }

    public void addHijo(String nodo,nodoAST hijo){
        if(nodo != null){
            this.hijos.add(new nodoAST(nodo));
        }
        if(hijo != null){
            this.hijos.add(hijo);
        }
    }

    public void addHijos(ArrayList<nodoAST> hijos){
        for(nodoAST hijo:hijos){
            this.hijos.add(hijo);
        }
    }

    public void addFirstHijo(String nodo, nodoAST hijo){
        if(nodo != null){
            this.hijos.add(0,new nodoAST(nodo));
        } else if(hijo != null){
            this.hijos.add(0,hijo);
        }
    }

    public String getValor(){
        return this.valor;
    }

    public void setValor(String nodo) {
        this.valor = nodo;
    }

    public ArrayList<nodoAST> getHijos(){
        return this.hijos;
    }
}
