/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author joovitor
 */
public class PecaEstoqueException extends Exception{
    
    public PecaEstoqueException()
    {
        super("Não ha peças suficientes no estoque");
    }
    
}
