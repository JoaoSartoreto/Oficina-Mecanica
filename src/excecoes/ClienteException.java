/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author joovitor
 */
public class ClienteException extends Exception{
    
    public ClienteException()
    {
        super("Não é permitido excluir clientes que estejam cadastrados em alguma OS");
    }
    
}
