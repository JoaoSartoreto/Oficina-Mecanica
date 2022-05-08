package menus;

public class MenuPecas extends MenuItem{

    // Chama o método exibir() de MenuItem passando "Peças" como o tipo de item para exibir o menu de gerenciamento de peças.
    // Devolve a opção selecionada (int).
    public static int exibir() {
        return MenuItem.exibir("Peças");
    }
}
