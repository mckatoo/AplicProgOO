/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.table_model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import loja.banco.tabelas.notas.NotaFiscalBean;

/**
 *
 * @author mckatoo
 */
public class NotasTableModel extends AbstractTableModel {
    
    private final List<NotaFiscalBean> dados = new ArrayList<>();
    private final String[] colunas = {"NÚMERO", "SÉRIE", "CLIENTE", "DATA", "CANCELADA"};

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
                return Arrays.toString(dados.get(rowIndex).getNumero()).charAt(1);
            case 1:
                String serieSanitizada = Arrays.toString(dados.get(rowIndex).getSerie()).replace("[", "");
                serieSanitizada = serieSanitizada.replace(", ", "");
                serieSanitizada = serieSanitizada.replace("]", "");
                return serieSanitizada;
            case 2:
                return dados.get(rowIndex).getCodCli();
            case 3: 
                return dados.get(rowIndex).getData();
            case 4: 
                return Arrays.toString(dados.get(rowIndex).getCancelada()).charAt(1);
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
                dados.get(rowIndex).setCodCli(((int) aValue));
                break;
            case 3: 
                dados.get(rowIndex).setData(((Date) aValue));
                break;
            case 4: 
                dados.get(rowIndex).setCancelada(((String) aValue).toCharArray());
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(NotaFiscalBean nota) {
        this.dados.add(nota);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
