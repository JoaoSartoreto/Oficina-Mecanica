package classes;

public class Exceptions {
    
    public static class ExcluiClienteEx extends Exception  {
        public ExcluiClienteEx() {
        super("Teste");
        }
        
        public static class OSFechadaEx extends Exception {
            public OSFechadaEx() {
                super("Esta OS não está aberta");
            }
        }
        
        public static class ExcluirServicoEmOSEx extends Exception {
            public ExcluirServicoEmOSEx() {
                super("");
            }
        }
    }
}
