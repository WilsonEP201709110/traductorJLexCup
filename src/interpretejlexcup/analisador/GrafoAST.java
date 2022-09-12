
package interpretejlexcup.analisador;

import java.util.LinkedList;

public class GrafoAST {
    private nodoAST raiz;
    private nodoAST init = new nodoAST("RAIZ");
    private nodoAST instruc = new nodoAST("INSTRCUCIONES");

    public String construir(LinkedList<Instruccion> tree){
        for(Instruccion m:tree){
            this.instruc.addHijo(null,m.getNodo());
        }

        this.init.addHijo(null, this.instruc);
        this.raiz = this.init; 

        return this.getDot(this.raiz);
    }

    private int c;
    private String grafoCosnt;

    private String getDot(nodoAST raiz){
        this.grafoCosnt = "";
        this.grafoCosnt += "digraph {\n";
        this.grafoCosnt += "n0[label=\"" + raiz.getValor().replace("\"", "\\\"") + "\"];\n";
        this.c = 1;
        this.recorrerTreeST("n0",raiz);
        this.grafoCosnt += "}";
        return this.grafoCosnt;
    }

    private void recorrerTreeST(String padre,nodoAST nodoPadre){
        for(nodoAST hijo:nodoPadre.getHijos()){
            String nombreHijo = "n" + this.c;
            this.grafoCosnt += nombreHijo + "[label=\"" + hijo.getValor().replace("\"", "\\\"") + "\"];\n";
            this.grafoCosnt += padre + "->" + nombreHijo + ";\n";
            this.c++;
            this.recorrerTreeST(nombreHijo,hijo);
        }
    }
}
