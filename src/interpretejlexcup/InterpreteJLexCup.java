
package interpretejlexcup;
import interpretejlexcup.analisador.GrafoAST;
import interpretejlexcup.analisador.Instruccion;
import java.io.FileInputStream;
import java.util.LinkedList;

public class InterpreteJLexCup {


    public static void main(String[] args) {
        interpretar("C:\\Users\\wilso\\Escritorio\\ejemplo\\interpreteJLexCup\\entrada.txt");
    }

    private static void interpretar(String path) {
        analizadores.Sintactico pars;
        LinkedList<Instruccion> AST_arbolSintaxisAbstracta=null;
        try {
            pars=new analizadores.Sintactico(new analizadores.Lexico(new FileInputStream(path)));
            pars.parse();        
            AST_arbolSintaxisAbstracta= pars.getAST();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
        } 
        ejecutarAST(AST_arbolSintaxisAbstracta);
    }
    
        private static void ejecutarAST(LinkedList<Instruccion> ast) {
        if(ast==null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        
        String codpython  = "def main():\n" +
                            "\tprint(\"***PYTHON  COMPI 1***!\")";
        String codgo  = "package main\n\n"+
                        "import(\n"+
                        "\t\"fmt\"\n"+
                        ")\n\n"+
                        "func main(){\n"+
                        "\tfmt.Print(\"***GOLANG COMPI 1***!\")";
        
        for(Instruccion ins:ast){
            if(ins!=null)
                codpython += ins.ejecutarPython("\t");
                codgo += ins.ejecutarGolang("\t");
        }
        
        codpython +=    "if __name__ == \"__main__\":\n" +
                        "\tmain()" ;
        codgo += "}";
        GrafoAST grafo = new GrafoAST();
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println(codpython);
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println(codgo);
        System.out.println("************************************");
        System.out.println(grafo.construir(ast));
        
    }
}
