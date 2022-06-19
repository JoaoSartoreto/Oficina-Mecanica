/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author joovitor
 */
public class ItemOSException extends Exception{
    
    public ItemOSException()
    {
        super("Só é permitido adicionar itens a Ordens de Serviços abertas");
    }
    
}
