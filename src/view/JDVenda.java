package view;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fpag;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import repositorio.RepItemVenda;
import repositorio.RepPagamento;
import repositorio.RepProdutos;
import repositorio.RepVenda;
import utils.Utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class JDVenda extends javax.swing.JDialog {
    
    int idVenda,idFpag;
    RepVenda repVenda = new RepVenda();
    RepItemVenda repItemVenda = new RepItemVenda();
    RepPagamento repPag = new RepPagamento();
    RepProdutos repProd = new RepProdutos();
    Utils util = new Utils();
    double total;
     private String procurar = "";
     public static Produto teste;
    

    /**
     * Creates new form JDVenda
     */
    public JDVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        habilitarCampos(false);
        jLabelVenda.setText("INICIE UMA VENDA");
        
        
    }

    JDVenda() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void limparDadosVenda(){
       habilitarCampos(false);
       jTextFieldQtd.setText("");
       jLabelVenda.setText("INICIE UMA VENDA");
       limparJtableItens();
       total = 0;
       idFpag = 0;
       jTextFieldTroco.setText("");
       jTextFieldPago.setText("");
       jTextFieldDescricao.setText("");
       
        DefaultTableModel modelo = (DefaultTableModel) jTablePagamento.getModel();
        modelo.setNumRows(0);
        
        
        
        
    }
    
    public void prepararFinalizacao(){
        double troco = 0;
  
        if(!jTextFieldPago.getText().equals("")){
            double valorPago = Double.parseDouble(jTextFieldPago.getText());
            if(valorPago > total){
                troco = valorPago - total;
                jTextFieldTroco.setText(util.formatarMoeda(troco));

            }else if(valorPago == total){
                jTextFieldTroco.setText("0,00");
                
            }else{
                JOptionPane.showMessageDialog(null, "O valor pago deve ser maior ou igual ao total.");
                jTextFieldPago.requestFocus();
            }
        }else{
             JOptionPane.showMessageDialog(null, "Para prosseguir digite o valor que foi pago.");
             jTextFieldPago.requestFocus();
        }
    }
    
    public void finalizar(){
        
  
        
       if(!jTextFieldTroco.getText().equals("")){
            
            Venda venda = new Venda();
            venda.setId(idVenda);
            venda.setTotal(total);
            venda.setFpag_id(idFpag);
            
            if(repVenda.finalizar(venda)){
                limparDadosVenda();
            }
       }
        
        
    }
    
    public void preencherItens( List<ItemVenda> itens){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableItens.getModel();
        modelo.setNumRows(0);
           
        total = 0;
        
        for(ItemVenda i : itens){
            
            total += i.getValortotal();
            
            modelo.addRow(new Object[]{
                //aqui vao ficar as colunas
                i.getId(),
                i.getDescricao(),
                i.getQtd(),
                i.getValoruni(),
                i.getValortotal(),
               
            });
        }
        
        jLabelTotal.setText(util.formatarMoeda(total));
        
    }
        
        public void limparJtableItens(){
            DefaultTableModel modelo = (DefaultTableModel) jTableItens.getModel();
            modelo.setNumRows(0);
        }
        
        public void preencherPag( List<Fpag> pagamentos){
        
        DefaultTableModel modelo = (DefaultTableModel) jTablePagamento.getModel();
        modelo.setNumRows(0);
           
        
        for(Fpag f : pagamentos){
            modelo.addRow(new Object[]{
                //aqui vao ficar as colunas
                f.getId(),
                f.getDescricao(),
   
            });
        }
        
    }
    
    public void habilitarCampos(boolean valor){
        jTextFieldQtd.setEnabled(valor);
        jTextFieldDescricao.setEnabled(valor);
        jTextFieldIdCli.setEnabled(valor);
        jTextFieldNomeCli.setEnabled(valor);
        jTextFieldPago.setEnabled(valor);
        jTextFieldTroco.setEnabled(valor);
        
        jTableItens.setEnabled(valor);
        jTablePagamento.setEnabled(valor);
        
        jButtonCancelar.setEnabled(valor);
        jButtonFinalizar.setEnabled(valor);
        jButtonNovaVenda.setEnabled(!valor);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItens = new javax.swing.JTable();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomeCli = new javax.swing.JTextField();
        jTextFieldIdCli = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonNovaVenda = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldPago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTroco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePagamento = new javax.swing.JTable();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelVenda = new javax.swing.JLabel();
        jButtonNovaVendas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "DESCRICAO", "QTD", "VALOR", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableItens);
        if (jTableItens.getColumnModel().getColumnCount() > 0) {
            jTableItens.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableItens.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableItens.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTableItens.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        jTextFieldDescricao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("EAN / DESCRIÇÃO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CLIENTE");

        jTextFieldNomeCli.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTextFieldIdCli.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCancelar.setText("CANCELAR VENDA");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonNovaVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonNovaVenda.setText("NOVA VENDA");
        jButtonNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVendaActionPerformed(evt);
            }
        });

        jButtonFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFinalizar.setText("FINALIZAR VENDA");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("TOTAL:");

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTotal.setText("0,00");

        jTextFieldPago.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextFieldPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPagoKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("FORMA DE PAGAMENTO");

        jTextFieldTroco.setEditable(false);
        jTextFieldTroco.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("TROCO");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("VALOR PAGO");

        jTablePagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "PAGAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePagamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePagamento);
        if (jTablePagamento.getColumnModel().getColumnCount() > 0) {
            jTablePagamento.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTablePagamento.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jTextFieldQtd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("QTD");

        jLabelVenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelVenda.setText("VENDA: 000");

        jButtonNovaVendas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonNovaVendas.setText("VENDAS");
        jButtonNovaVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNomeCli))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7))
                                    .addComponent(jLabel8))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(206, 206, 206))
                                    .addComponent(jTextFieldDescricao)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldPago, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonNovaVendas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFinalizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonNovaVenda)))))
                        .addGap(32, 32, 32))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTotal)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelVenda)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelVenda)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelTotal))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(81, 81, 81)
                                .addComponent(jTextFieldNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(2, 2, 2)
                                .addComponent(jTextFieldIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonNovaVenda)
                            .addComponent(jButtonFinalizar)
                            .addComponent(jButtonNovaVendas))
                        .addGap(29, 29, 29))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaVendaActionPerformed
        habilitarCampos(true);
        jTextFieldQtd.setText("1");
        jTextFieldDescricao.requestFocus();
        
        idVenda = repVenda.inserir();
        total = 0;
        idFpag = 0;
        jLabelVenda.setText("VENDA: 00"+idVenda);
        preencherPag(repPag.retornar());
    }//GEN-LAST:event_jButtonNovaVendaActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        finalizar();
   
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
       repVenda.cancelar(idVenda);
       limparDadosVenda();
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyPressed
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           
              if(jTextFieldDescricao.getText().matches("[0-9]+")){
                  
              List<Produto> produtos = repProd.pesquisar(jTextFieldDescricao.getText(), "barras");
              if(produtos.size() == 0){
                  JOptionPane.showMessageDialog(null, "Produto não encontrado");
                  jTextFieldDescricao.setText("");
                  jTextFieldDescricao.requestFocus();
              }
              else if(produtos.size() == 1){
                
                  for(Produto p : produtos){
                      
                      ItemVenda i = new ItemVenda();
                      i.setProduto_id(p.getId());
                      i.setQtd(Double.parseDouble(jTextFieldQtd.getText()));
                      i.setValoruni(p.getValor());
                      i.setVenda_id(idVenda);
                      i.setValortotal(i.getQtd()*i.getValoruni());
                      
                      repItemVenda.inserir(i);
                      jTextFieldQtd.setText("1");
                      jTextFieldDescricao.setText("");
                      jTextFieldDescricao.requestFocus();
                      preencherItens(repItemVenda.retornar(String.valueOf(idVenda)));
                  }
              }
              }else{
                  chamarTelapesquisa();
                  
                  ItemVenda i = new ItemVenda();
                     i.setProduto_id(teste.getId());
                      i.setQtd(Double.parseDouble(jTextFieldQtd.getText()));
                      i.setValoruni(teste.getValor());
                      i.setVenda_id(idVenda);
                      i.setValortotal(i.getQtd()*i.getValoruni());
                      repItemVenda.inserir(i);
                    preencherItens(repItemVenda.retornar(String.valueOf(idVenda)));
                  }
              
          
          }
          
    }//GEN-LAST:event_jTextFieldDescricaoKeyPressed
         public void chamarTelapesquisa(){
        
          JDPesquisaVendas jDVenda = new JDPesquisaVendas(null, false,jTextFieldDescricao.getText());
        try{ 
            jDVenda.setModal(true);
            jDVenda.setVisible(true);
        }finally{
            jDVenda.dispose();
        }
    }
    
    
    
    private void jTextFieldPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPagoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             prepararFinalizacao();
         }
    }//GEN-LAST:event_jTextFieldPagoKeyPressed

    private void jButtonNovaVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaVendasActionPerformed
    JDListaVendas jdListaVendas = new JDListaVendas(null, false);
        try{
            jdListaVendas.setModal(true);
            jdListaVendas.setVisible(true);
        }finally{
            jdListaVendas.dispose();
        } 
    }//GEN-LAST:event_jButtonNovaVendasActionPerformed

    private void jTablePagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePagamentoMouseClicked
         if(jTablePagamento.getSelectedRow() != - 1){
            idFpag = Integer.parseInt(jTablePagamento.getValueAt(jTablePagamento.getSelectedRow(), 0).toString());
         }
    }//GEN-LAST:event_jTablePagamentoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDVenda dialog = new JDVenda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonNovaVenda;
    private javax.swing.JButton jButtonNovaVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableItens;
    private javax.swing.JTable jTablePagamento;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldIdCli;
    private javax.swing.JTextField jTextFieldNomeCli;
    private javax.swing.JTextField jTextFieldPago;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextField jTextFieldTroco;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the procurar
     */

}
