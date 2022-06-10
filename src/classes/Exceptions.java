package classes;

public class Exceptions {
    
    public static class ExcluiClienteEx extends Exception  {
        
        //Exceção para tratar tentativas de ações em OS já fechadas.
        public static class OSFechadaEx extends Exception {
            public OSFechadaEx() {
                super("Esta OS não está aberta");
            }
        }
        
        public static class ClienteReferenciadoEx extends Exception {
            public ClienteReferenciadoEx() {
                super("O cliente está presente em ordens de serviço");
            }
        }
        
        public static class PecaReferenciadaEx extends Exception {
            public PecaReferenciadaEx() {
                super("A peça está presente em ordens de serviço");
            }
        }
        
        public static class SemEstoqueEx extends Exception {
            public SemEstoqueEx() {
                super("Quantidade insuficiente no estoque");
            }
        }
    }
}
