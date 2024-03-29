/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.uteis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 *
 * @author mckatoo
 */
public class FormataData {

    final static DateTimeFormatter FORMATO_LOCAL = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final static DateTimeFormatter FORMATO_ISO = DateTimeFormatter.ISO_DATE;

    public static String UStoBR(String data) {
        String dataBR = "";
        if (data.length() == 10) {
            TemporalAccessor dataUS = LocalDate.parse(data, FORMATO_ISO);
            dataBR = FORMATO_LOCAL.format(dataUS);
        }
        return dataBR;
    }

    public static String BRtoUS(String data) {
        String dataUS = "";
        if (data.length() == 10) {
            TemporalAccessor dataBR = LocalDate.parse(data, FORMATO_LOCAL);
            dataUS = FORMATO_ISO.format(dataBR);
        }
        return dataUS;
    }

}
