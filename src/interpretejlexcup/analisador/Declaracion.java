package interpretejlexcup.analisador;

public class Declaracion implements Instruccion{

    private final Tipo_dato tipo;
    private String Identificador;
    private Operacion valor;
    
    public Declaracion(String Identificador,Tipo_dato tipo,Operacion operacion){
        this.Identificador = Identificador;
        this.tipo = tipo;
        this.valor = operacion;
    }
    
    @Override
    public Object ejecutarPython(String t) {
        return t+this.Identificador+" = " +String.valueOf(this.valor.ejecutarPython(""));
    }

    @Override
    public Object ejecutarGolang(String t) {
        return t+"var "+this.Identificador+" "+getTipo()+" = "+String.valueOf(this.valor.ejecutarGolang(""));
    }

    @Override
    public nodoAST getNodo() {
        nodoAST nodo = new nodoAST("DECLARACION");
        nodo.addHijo("Ingresar", null);
        nodo.addHijo(this.Identificador,null);
        nodo.addHijo("Como",null);
        nodo.addHijo(getComo(),null);
        nodo.addHijo("Con_valor",null);
        nodo.addHijo(null,this.valor.getNodo());
        return nodo;
    }
    
    private String getTipo(){
        if(this.tipo == Tipo_dato.NUMERO){
            return "int";
        }
        if(this.tipo == Tipo_dato.BOOLEANO){
            return "bool";
        }if(this.tipo == Tipo_dato.CADENA){
            return "string";
        }
        if(this.tipo == Tipo_dato.CARACTER){
            return "byte";
        }
        if(this.tipo == Tipo_dato.DECIMAL){
            return "float64";
        }
        return "tipo";
    }
    
    private String getComo(){
        if(this.tipo == Tipo_dato.NUMERO){
            return "numero";
        }
        if(this.tipo == Tipo_dato.BOOLEANO){
            return "booleano";
        }if(this.tipo == Tipo_dato.CADENA){
            return "cadena";
        }
        if(this.tipo == Tipo_dato.CARACTER){
            return "catacter";
        }
        
        return "tipo";
    }
    
}
