package classes;

public class Exceptions {
    
    public static class ExcluiClienteEx extends Exception  {
        public ExcluiClienteEx() {
        super("Teste");
        }
        
        public static class ExcluirOSAbertaEx extends Exception {
            public ExcluirOSAbertaEx () {
                super("Esta OS não está aberta");
            }
        }
    }
}
