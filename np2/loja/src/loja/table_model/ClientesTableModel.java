/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.table_model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import loja.banco.tabelas.clientes.ClienteBean;

/**
 *
 * @author mckatoo
 */
public class ClientesTableModel extends AbstractTableModel {
    
    private final List<ClienteBean> dados = new ArrayList<>();
    private final String[] colunas = {"CÓDIGO", "NOME", "ENDEREÇO", "ESTADO"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return dados.get(rowIndex).getCodCli();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getEndereco();
            case 3: 
                return "" + Arrays.toString(dados.get(rowIndex).getEstado()).charAt(1) + Arrays.toString(dados.get(rowIndex).getEstado()).charAt(4);
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setCodCli(Integer.parseInt((String) aValue));
                break;
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setEndereco((String) aValue);
                break;
            case 3: 
                dados.get(rowIndex).setEstado(((String) aValue).toCharArray());
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(ClienteBean cliente) {
        this.dados.add(cliente);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
