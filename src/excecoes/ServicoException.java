/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author joovitor
 */
public class ServicoException extends Exception{
    
    public ServicoException()
    {
        super("Não é permitido excluir serviços que estejam cadastrados em alguma OS");
    }
    
}
