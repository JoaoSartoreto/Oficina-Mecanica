package gui.os;

import classes.OrdemServico;
import excecoes.os.OSNaoAbertaException;
import excecoes.os.OSNaoEncontradaException;
import gui.Mensagem;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import oficina.Oficina;

public class JanelaOS extends javax.swing.JFrame {

    private ArrayList<OrdemServico> ordensServico;
    
    public JanelaOS(ArrayList<OrdemServico> ordensServico) {
        initComponents();
        this.ordensServico = ordensServico;
        atualizarTabela();
        
        ListSelectionModel selectionModel = tableOS.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int linha = tableOS.getSelectedRow();
                String situacao = "";
                if(linha >= 0) {
                    situacao = (String) tableOS.getValueAt(linha, 5);
                    System.out.println(linha);
                    if (situacao == "Aberta") {
                        botaoExcluir.setEnabled(true);
                    }else {
                        botaoExcluir.setEnabled(false);
                    }
                    botaoGerenciar.setEnabled(true);
                }
            }
        });
        
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

        scrollPaneTable = new javax.swing.JScrollPane();
        tableOS = new javax.swing.JTable();
        labelNumero = new javax.swing.JLabel();
        textLocalizar = new javax.swing.JTextField();
        botaoLocalizar = new javax.swing.JButton();
        botaoGerenciar = new javax.swing.JButton();
        botaoAbrirOS = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordens de Serviço - Controle de Oficina");

        tableOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Data", "Previsão de Término", "Término", "Placa", "Situação", "Preço", "Proprietário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTable.setViewportView(tableOS);

        labelNumero.setText("Número:");

        botaoLocalizar.setText("Localizar");
        botaoLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLocalizarActionPerformed(evt);
            }
        });

        botaoGerenciar.setText("Gerenciar OS");
        botaoGerenciar.setEnabled(false);
        botaoGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerenciarActionPerformed(evt);
            }
        });

        botaoAbrirOS.setText("Abrir Nova OS");
        botaoAbrirOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAbrirOSActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLocalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLocalizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoGerenciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAbrirOS)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(textLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGerenciar)
                    .addComponent(botaoAbrirOS)
                    .addComponent(botaoExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLocalizarActionPerformed
        String titulo = "Localizar OS";
        String numero = textLocalizar.getText();
        boolean encontrado = false;
           
        for(int i = 0; i < tableOS.getRowCount() && !encontrado; i++){
            if(tableOS.getValueAt(i, 0).equals(numero)){
                tableOS.setRowSelectionInterval(i, i);
                tableOS.scrollRectToVisible(new Rectangle(tableOS.getCellRect(i, 0, true)));
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            Mensagem.exibirMensagemErro(titulo, new OSNaoEncontradaException().getMessage());
        }
    }//GEN-LAST:event_botaoLocalizarActionPerformed

    private void botaoGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerenciarActionPerformed
        String titulo = "Gerenciar OS";
        
        int linha = tableOS.getSelectedRow();
        int numOS = Integer.parseInt((String) tableOS.getValueAt(linha, 0));
        try
        {
            OrdemServico os = Oficina.buscarOS(numOS);
            new JanelaGerenciarOS(os,this);
        }catch(OSNaoEncontradaException ex){
            Mensagem.exibirMensagemErro(titulo, ex.getMessage());
        }
    }//GEN-LAST:event_botaoGerenciarActionPerformed

    private void botaoAbrirOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAbrirOSActionPerformed
        new JanelaAbrirOS(ordensServico, this);
    }//GEN-LAST:event_botaoAbrirOSActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        String titulo = "Excluir OS";

        int linha = tableOS.getSelectedRow();
        int numOS = Integer.parseInt((String) tableOS.getValueAt(linha, 0));
        try
        {
            Oficina.excluirOS(numOS);
            atualizarTabela();
            Mensagem.exibirMensagem(titulo, "OS excluída com sucesso!");
            botaoExcluir.setEnabled(false);
            botaoGerenciar.setEnabled(false);
        }catch(OSNaoAbertaException | OSNaoEncontradaException ex){
            Mensagem.exibirMensagemErro(titulo, ex.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    public void atualizarTabela()
    {
        DefaultTableModel tableModel = (DefaultTableModel)this.tableOS.getModel();
        tableModel.setRowCount(0);
        
        String numOS;
        String dataOS;
        String dataPrev;
        String dataTermino;
        String placa;
        String situacao = "";
        String valor;
        String proprietario;
    
        for (OrdemServico OS : ordensServico) {
            numOS = OS.getNumeroOS()+"";
            dataOS = OS.getDataOS().toString();
            dataPrev = OS.getDataPrevTermino().toString();
            if(OS.getDataTermino() == null)
            {
                dataTermino = "";
            }else{
                dataTermino = OS.getDataTermino().toString();
            }  
            placa = OS.getPlacaCarro();
            switch (OS.getSituacao()) {
                case 'A' -> {
                    situacao = "Aberta";
                }
                case 'C' -> {
                    situacao = "Cancelada";
                }
                case 'F' -> {
                    situacao = "Finalizada";
                }
                default -> {
                }
            }
            
            valor = OS.getValorOS() + "";
            
            proprietario = OS.getCliente().getNome();
            
            Object[] dados = {numOS,dataOS,dataPrev,dataTermino,placa,situacao,
                valor,proprietario};
            tableModel.addRow(dados);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAbrirOS;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoGerenciar;
    private javax.swing.JButton botaoLocalizar;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JTable tableOS;
    private javax.swing.JTextField textLocalizar;
    // End of variables declaration//GEN-END:variables
}
