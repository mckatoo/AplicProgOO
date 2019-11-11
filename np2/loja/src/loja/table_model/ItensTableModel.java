/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.table_model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import loja.banco.tabelas.itens.ItemBean;
import loja.uteis.Sanitize;

/**
 *
 * @author mckatoo
 */
public class ItensTableModel extends AbstractTableModel {
    
    private final List<ItemBean> dados = new ArrayList<>();
    private final String[] colunas = {"NÚMERO", "SÉRIE", "ITEM", "CODPNEU", "QTDE", "PREÇO"};

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
                return Sanitize.sanitizar(dados.get(rowIndex).getNumero());
            case 1:
                return Sanitize.sanitizar(dados.get(rowIndex).getSerie());
            case 2:
                return dados.get(rowIndex).getItem();
            case 3: 
                return dados.get(rowIndex).getCodPneu();
            case 4: 
                return dados.get(rowIndex).getQtde();
            case 5: 
                return dados.get(rowIndex).getPreco();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setNumero(((String) aValue).toCharArray());
                break;
            case 1:
                dados.get(rowIndex).setSerie(((String) aValue).toCharArray());
                break;
            case 2:
                dados.get(rowIndex).setItem(((int) aValue));
                break;
            case 3: 
                dados.get(rowIndex).setCodPneu(((int) aValue));
                break;
            case 4: 
                dados.get(rowIndex).setQtde(((int) aValue));
                break;
            case 5: 
                dados.get(rowIndex).setPreco(((BigDecimal) aValue));
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(ItemBean item) {
        this.dados.add(item);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
