/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author joovitor
 */
public class PecaException extends Exception{
    
    public PecaException()
    {
        super("Não é permitido excluir peças que estejam cadastradas em alguma OS");
    }
    
}
