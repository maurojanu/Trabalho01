/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.Classes.InterfaceUsuario;

import br.edu.ifnmg.tads.Trabalho01.DataAcess.DAOClientes;
import br.edu.ifnmg.tads.Trabalho01.Classes.Cliente;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
/**
 *
 * @author marcelosa
 */
public class frmListagemClientes extends javax.swing.JInternalFrame {

    DAOClientes dao ;
    /**
     * Creates new form frmListagemClientes
     */
    public frmListagemClientes() {
        initComponents();
        dao = new DAOClientes();
        List<Cliente> clientes = dao.listarTodos();
        
        preencheTabela(clientes);
    }
private void preencheTabela(List<Cliente> lista) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Rg");
        model.addColumn("Cpf");
        model.addColumn("D.Nascimento");
        
        for (Cliente c : lista) {
            Vector valores = new Vector();
            valores.add(0,c.getId());
            valores.add(1,c.getNome());
            valores.add(2,c.getRg());
            valores.add(3,c.getCpf());
            valores.add(4,c.getNascimento());
            model.addRow(valores);
        }
        tblListar.setModel(model);
        tblListar.repaint();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFiltro = new javax.swing.JButton();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListar = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listagem Clientes");

        btnFiltro.setText("Filtrar");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        tblListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltro)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltro)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
        Cliente c = new Cliente();
        c.setNome(txtFiltro.getText());
        
        List<Cliente> lista = dao.buscar(c);
        
        preencheTabela(lista);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void tblListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListarMouseClicked
        // TODO add your handling code here:
        Object valor = tblListar.getValueAt( tblListar.getSelectedRow(), 0);
        Cliente c = dao.Abrir((int)valor);
        frmEditarClientes janela = new frmEditarClientes(c, dao);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tblListarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListar;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
