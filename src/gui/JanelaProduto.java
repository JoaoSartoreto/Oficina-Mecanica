/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import classes.Peca;
import classes.Produto;
import classes.Servico;
import excecoes.ClienteNaoEncontradoException;
import excecoes.ClienteReferenciadoException;
import excecoes.PecaNaoEncontradaException;
import excecoes.PecaReferenciadaException;
import excecoes.PrecoInvalidoException;
import excecoes.QuantidadeEstoqueInvalidaException;
import excecoes.ServicoNaoEncontradoException;
import excecoes.ServicoReferenciadoException;
import interfaces.Interface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oficina.Oficina;

/**
 *
 * @author joovitor
 */
public class JanelaProduto extends javax.swing.JFrame {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Peca> pecas;
    private ArrayList<Servico> servicos;
    
    public JanelaProduto(ArrayList<Peca> pecas, ArrayList<Servico> servicos) {
        initComponents();
        this.pecas = pecas;
        this.servicos = servicos;
        
        recuperarProdutos(pecas, servicos);
        atualizarTabela();
        jDuracao.setVisible(false);
        jDia.setVisible(false);
        jHora.setVisible(false);
        jMinuto.setVisible(false);
        jSegundos.setVisible(false);
        tDia.setVisible(false);
        tHora.setVisible(false);
        tMinuto.setVisible(false);
        tSegundos.setVisible(false);
        
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        bEditar = new javax.swing.JButton();
        bApagar = new javax.swing.JButton();
        bProcurar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tPreco = new javax.swing.JTextField();
        jEstoque = new javax.swing.JLabel();
        tEstoque = new javax.swing.JTextField();
        jDuracao = new javax.swing.JLabel();
        jDia = new javax.swing.JLabel();
        tHora = new javax.swing.JTextField();
        jHora = new javax.swing.JLabel();
        tDia = new javax.swing.JTextField();
        jMinuto = new javax.swing.JLabel();
        tMinuto = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        rPeca = new javax.swing.JRadioButton();
        rServico = new javax.swing.JRadioButton();
        jSegundos = new javax.swing.JLabel();
        tSegundos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Código", "Descrição", "Preço", "Estoque", "Duração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabelaProdutos);

        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        bApagar.setText("Apagar");
        bApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bApagarActionPerformed(evt);
            }
        });

        bProcurar.setText("Procurar");
        bProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar produto"));

        jLabel1.setText("Tipo:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Preço:");

        jEstoque.setText("Estoque:");

        jDuracao.setText("Duração");

        jDia.setText("Dia:");

        jHora.setText("Horas:");

        jMinuto.setText("Minutos:");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rPeca);
        rPeca.setSelected(true);
        rPeca.setText("Peça");
        rPeca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rPecaItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rServico);
        rServico.setText("Serviço");

        jSegundos.setText("Segundos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rPeca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rServico))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDuracao)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jEstoque)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tEstoque))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jMinuto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSegundos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCadastrar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rPeca)
                    .addComponent(rServico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEstoque)
                    .addComponent(tEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDuracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDia)
                    .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHora)
                    .addComponent(jMinuto)
                    .addComponent(tDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSegundos)
                    .addComponent(tSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bCadastrar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bEditar)
                            .addComponent(bApagar)
                            .addComponent(bProcurar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(bEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bApagar)
                        .addGap(18, 18, 18)
                        .addComponent(bProcurar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        String titulo = "Editar Peça";
        int linha = tabelaProdutos.getSelectedRow();
        
        int codigo = Integer.parseInt((String) tabelaProdutos.getValueAt(linha, 1));
        String tipo = (String)tabelaProdutos.getValueAt(linha, 0);
        if(tipo == "Peça")
        {
            Peca peca = Oficina.buscarPeca(codigo);
            new EdicaoPeca(peca, this);
        }
        else if (tipo == "Serviço")
        {
            Servico servico = Oficina.buscarServico(codigo);
            new EdicaoServico(servico, this);
        }
    }//GEN-LAST:event_bEditarActionPerformed

    private void bApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bApagarActionPerformed
        String titulo = "Excluir Cliente";
        int linha = this.tabelaProdutos.getSelectedRow();
        int codigo = Integer.parseInt((String) this.tabelaProdutos.getValueAt(linha, 1));
        
        try {
                if(this.tabelaProdutos.getValueAt(linha, 0) == "Peça")
                {
                    Oficina.excluirPeca(codigo);
                    Interface.exibirMensagem(titulo, "Peça excluída com sucesso");

                }
                else if(this.tabelaProdutos.getValueAt(linha, 0) == "Serviço")
                {
                    Oficina.excluirServico(codigo);
                    Interface.exibirMensagem(titulo, "Serviço excluído com sucesso");
                }
                this.atualizarTabela();
                
            } catch (PecaReferenciadaException ex) {
                Interface.exibirMensagemErro(titulo, ex.getMessage());
            } catch (PecaNaoEncontradaException ex) {
                 Interface.exibirMensagemErro(titulo, ex.getMessage());
            } catch (ServicoReferenciadoException ex) {
                Interface.exibirMensagemErro(titulo, ex.getMessage());
            } catch (ServicoNaoEncontradoException ex) {
                Interface.exibirMensagemErro(titulo, ex.getMessage());
            }
        
    }//GEN-LAST:event_bApagarActionPerformed

    private void bProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarActionPerformed
        new ProdutoEncontrado(produtos);
    }//GEN-LAST:event_bProcurarActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        String titulo = "Cadastro de Produto";
        
        String tipo;
        String descricao;
        double preco;
        int estoque;
        int dia,hora,minuto,segundo;
        
        descricao = tDescricao.getText();
        preco = Double.parseDouble(tPreco.getText());
        if(rPeca.isSelected())
        {
            try {
                tipo = "Peça";
                estoque = Integer.parseInt(tEstoque.getText());
                Peca peca = new Peca(estoque, descricao, preco);
                pecas.add(peca);
                produtos.add(peca);
                
            } catch (PrecoInvalidoException ex) {
                Interface.exibirMensagemErro(titulo, ex.getMessage());
            } catch (QuantidadeEstoqueInvalidaException ex) {
                Interface.exibirMensagemErro(titulo, ex.getMessage());
            }
        }
        else
        {
            tipo = "Serviço";
            dia = Integer.parseInt(tDia.getText());
            hora = Integer.parseInt(tHora.getText());
            minuto = Integer.parseInt(tMinuto.getText());
            segundo = Integer.parseInt(tSegundos.getText());
            try {
                Servico servico = new Servico(descricao, preco, dia, hora, minuto, segundo);
                servicos.add(servico);
                produtos.add(servico);
            } catch (PrecoInvalidoException ex) {
                Interface.exibirMensagemErro(titulo, ex.getMessage());
            }
        }
        atualizarTabela();
        
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void rPecaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rPecaItemStateChanged
        if(rPeca.isSelected())
        {
           jDuracao.setVisible(false);
           jDia.setVisible(false);
           jHora.setVisible(false);
           jMinuto.setVisible(false);
           jSegundos.setVisible(false);
           tDia.setVisible(false);
           tHora.setVisible(false);
           tMinuto.setVisible(false);
           tSegundos.setVisible(false);
           
           jEstoque.setVisible(true);
           tEstoque.setVisible(true);
        }
        else
        {
            jEstoque.setVisible(false);
            tEstoque.setVisible(false);
            
            jDuracao.setVisible(true);
            jDia.setVisible(true);
            jHora.setVisible(true);
            jMinuto.setVisible(true);
            jSegundos.setVisible(true);
            tDia.setVisible(true);
            tHora.setVisible(true);
            tMinuto.setVisible(true);
            tSegundos.setVisible(true);
        }
    }//GEN-LAST:event_rPecaItemStateChanged

    /**
     * @param args the command line arguments
     */
    
    public void recuperarProdutos(ArrayList<Peca> pecas, ArrayList<Servico> servicos)
    {
        for (Peca peca : pecas) {
            this.produtos.add(peca);
        }
        for (Servico servico : servicos) {
            this.produtos.add(servico);
        }
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }
    
    public void atualizarTabela()
    {
        produtos.clear();
        recuperarProdutos(pecas, servicos);
        DefaultTableModel tabela = (DefaultTableModel)this.tabelaProdutos.getModel();
        
        while(tabela.getRowCount() > 0)
        {
            tabela.removeRow(0);
        }
        
        String tipo;
        String codigo;
        String preco;
        String descricao;
        Collections.sort(produtos);
        for (Produto produto : this.produtos) {
            
            codigo = String.valueOf(produto.getCodigo());
            preco = String.valueOf(produto.getPreco());
            descricao = produto.getDescricao();
            String qtdEstoque = "";
            String tempoDuracao = "";
            if(produto instanceof Peca)
            {
                tipo = "Peça";
                qtdEstoque = String.valueOf(((Peca) produto).getQtdeEstoque());
                
                Object [] dado = {tipo,codigo,descricao,preco,qtdEstoque,tempoDuracao};
                tabela.addRow(dado);
            }
            else if(produto instanceof Servico)
            {
                tipo = "Serviço";
                tempoDuracao = ((Servico)produto).getTempoExecucaoString();
                
                Object [] dado = {tipo,codigo,descricao,preco,qtdEstoque,tempoDuracao};
                tabela.addRow(dado);
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bApagar;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bProcurar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jDia;
    private javax.swing.JLabel jDuracao;
    private javax.swing.JLabel jEstoque;
    private javax.swing.JLabel jHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jMinuto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSegundos;
    private javax.swing.JRadioButton rPeca;
    private javax.swing.JRadioButton rServico;
    private javax.swing.JTextField tDescricao;
    private javax.swing.JTextField tDia;
    private javax.swing.JTextField tEstoque;
    private javax.swing.JTextField tHora;
    private javax.swing.JTextField tMinuto;
    private javax.swing.JTextField tPreco;
    private javax.swing.JTextField tSegundos;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
