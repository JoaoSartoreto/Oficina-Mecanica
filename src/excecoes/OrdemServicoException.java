/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author joovitor
 */
public class OrdemServicoException extends Exception{
    
    public OrdemServicoException()
    {
        super("Essa operação só é permitida em OS que estejam abertas");
    }
    
}
