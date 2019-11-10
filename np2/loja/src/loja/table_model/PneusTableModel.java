/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.table_model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import loja.banco.tabelas.pneus.PneuBean;

/**
 *
 * @author mckatoo
 */
public class PneusTableModel extends AbstractTableModel {
    
    private final List<PneuBean> dados = new ArrayList<>();
    private final String[] colunas = {"CÓDIGO", "DESCRIÇÃO", "MEDIDAS", "PREÇO", "ATIVO"};

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
                return dados.get(rowIndex).getCodPneu();
            case 1:
                return dados.get(rowIndex).getDescricao();
            case 2:
                return dados.get(rowIndex).getMedidas();
            case 3: 
                return dados.get(rowIndex).getPreco();
            case 4: 
                return "" + Arrays.toString(dados.get(rowIndex).getAtivo()).charAt(1);
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setCodPneu(Integer.parseInt((String) aValue));
                break;
            case 1:
                dados.get(rowIndex).setDescricao((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setMedidas((String) aValue);
                break;
            case 3: 
                dados.get(rowIndex).setPreco((BigDecimal) aValue);
                break;
            case 4: 
                dados.get(rowIndex).setAtivo(((String) aValue).toCharArray());
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(PneuBean pneu) {
        this.dados.add(pneu);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
