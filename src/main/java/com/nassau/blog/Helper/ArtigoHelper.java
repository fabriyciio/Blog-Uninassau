package com.nassau.blog.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ArtigoHelper {

    public static Date converterStringParaDate(String data) {
        SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (Objects.isNull(data)){
                return new Date();
            }
            return formato.parse(data);
        } catch (ParseException | NumberFormatException e) {
           return new Date();
        }
    }
    
}
