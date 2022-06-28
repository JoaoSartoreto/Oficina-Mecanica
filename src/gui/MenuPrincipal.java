package gui;

import gui.os.JanelaOS;
import gui.produto.JanelaProdutos;
import gui.cliente.JanelaClientes;
import classes.Cliente;
import classes.OrdemServico;
import classes.Peca;
import classes.Servico;
import java.util.ArrayList;
import oficina.Oficina;
import operacoes.IO;

public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    private ArrayList<Cliente> listaClientes; 
    private ArrayList<OrdemServico> listaOS;
    private ArrayList<Peca> listaPecas; 
    private ArrayList<Servico> listaServicos;
    
    public MenuPrincipal(ArrayList<Cliente> listaClientes, ArrayList<OrdemServico> listaOS,
            ArrayList<Peca> listaPecas, ArrayList<Servico> listaServicos) {
        initComponents();
        setMinimumSize(getSize());
        this.listaClientes = listaClientes;
        this.listaOS = listaOS;
        this.listaPecas = listaPecas;
        this.listaServicos = listaServicos;
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

        botaoSair = new javax.swing.JButton();
        botaoClientes = new javax.swing.JButton();
        botaoProdutos = new javax.swing.JButton();
        botaoOS = new javax.swing.JButton();
        botaoTotalPeriodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal - Controle de Oficina");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        botaoSair.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        botaoSair.setText("Sair do programa");
        botaoSair.setActionCommand("Gerênciar Ordens de Serviço");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoClientes.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        botaoClientes.setText("Gerenciar clientes");
        botaoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoClientesActionPerformed(evt);
            }
        });

        botaoProdutos.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        botaoProdutos.setText("Gerenciar produtos");
        botaoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProdutosActionPerformed(evt);
            }
        });

        botaoOS.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        botaoOS.setText("Gerenciar ordens de serviço");
        botaoOS.setActionCommand("Gerenciar ordens de serviço");
        botaoOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOSActionPerformed(evt);
            }
        });

        botaoTotalPeriodo.setFont(new java.awt.Font("Fira Sans", 0, 18)); // NOI18N
        botaoTotalPeriodo.setText("Consultar total vendido em um período");
        botaoTotalPeriodo.setActionCommand("Gerênciar Ordens de Serviço");
        botaoTotalPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTotalPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoOS, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(botaoTotalPeriodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoOS, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoTotalPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoClientesActionPerformed
        new JanelaClientes(listaClientes);
    }//GEN-LAST:event_botaoClientesActionPerformed

    private void botaoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProdutosActionPerformed
        new JanelaProdutos(listaPecas, listaServicos);
    }//GEN-LAST:event_botaoProdutosActionPerformed

    private void botaoOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOSActionPerformed
        new JanelaOS(listaOS);
    }//GEN-LAST:event_botaoOSActionPerformed

    private void botaoTotalPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTotalPeriodoActionPerformed
        new JanelaVendidoEmPeriodo();
    }//GEN-LAST:event_botaoTotalPeriodoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        Oficina.gravarDados();
        System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Oficina.gravarDados();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoClientes;
    private javax.swing.JButton botaoOS;
    private javax.swing.JButton botaoProdutos;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoTotalPeriodo;
    // End of variables declaration//GEN-END:variables
}
