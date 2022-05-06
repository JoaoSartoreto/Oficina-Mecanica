import java.util.ArrayList;

import classes.Cliente;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import menus.MenuClientes;
import menus.MenuOS;
import menus.MenuPecas;
import menus.MenuPrincipal;
import menus.MenuServicos;

public class Oficina {

    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private static ArrayList<OrdemServico> listaOS = new ArrayList<OrdemServico>();
    private static ArrayList<Peca> listaPecas = new ArrayList<Peca>();
    private static ArrayList<Servico> listaServicos = new ArrayList<Servico>();

    public static void main(String[] args) {
        int opcao;
        boolean sair = false;

        do {
            opcao = MenuPrincipal.exibir();

            switch (opcao) {
                case 1:
                    opcao = MenuClientes.exibir();
                    break;
            
                case 2:
                    opcao = MenuPecas.exibir();
                    break;

                case 3:
                    opcao = MenuServicos.exibir();
                    break;

                case 4:
                    gerenciarOS();
                    break;

                case 5:
                    
                    break;

                case 6:
                    sair = true;
                    break;
            }
        } while (!sair);
    }

    private static void gerenciarClientes()
    {
        
    }

    private static void gerenciarOS()
    {
        int opcao = MenuOS.exibir();
        switch (opcao) {
            case 2: 
                opcao = MenuOS.gerenciarItens();
                break;
        }
    }
}
