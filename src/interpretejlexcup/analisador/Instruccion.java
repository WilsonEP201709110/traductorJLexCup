package interpretejlexcup.analisador;

public interface Instruccion {
    public Object ejecutarPython(String t);
    public Object ejecutarGolang(String t);
    public nodoAST getNodo();
}
