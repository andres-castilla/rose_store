
package Clases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class C_FechaAjustarFormato {
    public String FechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }
    public String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString=null;
        dateString = df.format(date);
        return dateString;
    }
    public Date dateToDate(String stringDate) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date = df.parse(stringDate);
        return date;
    }
}
