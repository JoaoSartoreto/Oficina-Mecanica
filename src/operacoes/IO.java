/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacoes;

import classes.Cliente;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joovitor
 */
public class IO {
    
    public static File verificarDiretorio()
    {
        File diretorio = new File("./dados");
        if(!diretorio.exists())
        {
            diretorio.mkdir();
        }
        return diretorio;
    }
    
    
    //GRAVAÇÃO DOS DADOS
    
    public static void gravarClientes(ArrayList<Cliente> clientes)
    {
        String arquivo = "/clientes.txt";
        File diretorio = verificarDiretorio();
        
        ObjectOutputStream file = null;
        
        try
        {
            file = new ObjectOutputStream(new FileOutputStream(diretorio+arquivo));
            file.writeObject(clientes);
            System.out.println("Clientes gravados com sucesso");
        } catch (IOException ex) {
        }finally{
            try
            {
                file.close();
            }catch(IOException ex){                
            }catch(NullPointerException ex){               
            }
        }
    }
    
    public static void gravarOS(ArrayList<OrdemServico> ordemServico)
    {
        String arquivo = "/ordemServico.txt";
        File diretorio = verificarDiretorio();
        
        ObjectOutputStream file = null;
        
        try
        {
            file = new ObjectOutputStream(new FileOutputStream(diretorio+arquivo));
            file.writeObject(ordemServico);
            System.out.println("Ordens de Serviços gravadas com sucesso");
        } catch (IOException ex) {
        }finally{
            try
            {
                file.close();
            }catch(IOException ex){                
            }catch(NullPointerException ex){               
            }
        }
    }
    
    public static void gravarPecas(ArrayList<Peca> pecas)
    {
        String arquivo = "/pecas.txt";
        File diretorio = verificarDiretorio();
        
        ObjectOutputStream file = null;
        
        try
        {
            file = new ObjectOutputStream(new FileOutputStream(diretorio+arquivo));
            file.writeObject(pecas);
            System.out.println("Peças gravadas com sucesso");
        } catch (IOException ex) {
        }finally{
            try
            {
                file.close();
            }catch(IOException ex){                
            }catch(NullPointerException ex){               
            }
        }
    }
    
    public static void gravarServicos(ArrayList<Servico> servicos)
    {
        String arquivo = "/servicos.txt";
        File diretorio = verificarDiretorio();
        
        ObjectOutputStream file = null;
        
        try
        {
            file = new ObjectOutputStream(new FileOutputStream(diretorio+arquivo));
            file.writeObject(servicos);
            System.out.println("Serviços gravados com sucesso");
        } catch (IOException ex) {
        }finally{
            try
            {
                file.close();
            }catch(IOException ex){                
            }catch(NullPointerException ex){               
            }
        }
    }
    
    //LEITURA DE DADOS
    
    public static ArrayList<Cliente> leituraClientes()
    {
        ArrayList<Cliente> clientes = null;
        
        String arq = "/clientes.txt";
        File arquivo = new File(verificarDiretorio() + arq);
        
        if(!arquivo.exists())
        {
            return new ArrayList<Cliente>();
        }
        
        ObjectInputStream file = null;
        try
        {
            file = new ObjectInputStream(new FileInputStream(arquivo));
            clientes = (ArrayList<Cliente>) file.readObject();
            System.out.println("Clientes recuperados com sucesso!");
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return clientes;
    }
    
    public static ArrayList<OrdemServico> leituraOS()
    {
        ArrayList<OrdemServico> ordemServico = null;
        
        String arq = "/ordemServico.txt";
        File arquivo = new File(verificarDiretorio() + arq);
        
        if(!arquivo.exists())
        {
            return new ArrayList<OrdemServico>();
        }
        
        ObjectInputStream file = null;
        try
        {
            file = new ObjectInputStream(new FileInputStream(arquivo));
            ordemServico = (ArrayList<OrdemServico>) file.readObject();
            System.out.println("Ordens de Serviço recuperadas com sucesso!");
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return ordemServico;
    }
    
    public static ArrayList<Peca> leituraPecas()
    {
        ArrayList<Peca> pecas = null;
        
        String arq = "/pecas.txt";
        File arquivo = new File(verificarDiretorio() + arq);
        
        if(!arquivo.exists())
        {
            return new ArrayList<Peca>();
        }
        
        ObjectInputStream file = null;
        try
        {
            file = new ObjectInputStream(new FileInputStream(arquivo));
            pecas = (ArrayList<Peca>) file.readObject();
            System.out.println("Peças recuperados com sucesso!");
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return pecas;
    }
    
    public static ArrayList<Servico> leituraServicos()
    {
        ArrayList<Servico> servicos = null;
        
        String arq = "/servicos.txt";
        File arquivo = new File(verificarDiretorio() + arq);
        
        if(!arquivo.exists())
        {
            return new ArrayList<Servico>();
        }
        
        ObjectInputStream file = null;
        try
        {
            file = new ObjectInputStream(new FileInputStream(arquivo));
            servicos = (ArrayList<Servico>) file.readObject();
            System.out.println("Serviços recuperados com sucesso!");
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return servicos;
    }
}
