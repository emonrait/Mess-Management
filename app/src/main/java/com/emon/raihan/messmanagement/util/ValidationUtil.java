package com.emon.raihan.messmanagement.util;

import android.util.Log;
import android.widget.EditText;


import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import java.util.regex.Pattern;


public class ValidationUtil {

    public static String commaSeparateAmount(String str) {
        String rValue = "";

        double amount = 0.00;


        try {
            str = str.replaceAll(",", "");


            if (str != null) {
                amount = Double.parseDouble(str);
            }

            Format f = DecimalFormat.getNumberInstance(new Locale("en", "IN"));
            ((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
            ((DecimalFormat) f).setMinimumFractionDigits(2);

            rValue = f.format(amount);
            // Log.e("rValue-->", rValue);

        } catch (Exception e) {
            rValue = "";
            e.printStackTrace();
        }

        return rValue;
    }

    public static String replacecomma(String str) {
        String rValue = "";
        try {
            str = str.replaceAll(",", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getNullCheck(String str) {
        String rValue = "";
        if (null == str || str.isEmpty() || str == "") {
            rValue = "    ";
        } else {
            rValue = str;
        }
        return rValue;

    }

    public static boolean isNumeric(String str) {
        boolean b = false;
        try {
            if (str != "") {
                Double.parseDouble(str);
                b = true;
            }

        } catch (NumberFormatException e) {
            b = false;
        }
        return b;
    }

    public static String getRetrofit_NullCheck(String s) {
        String rValue = "";
        if (null == s || s.isEmpty() || s.endsWith("null") || s == "") {
            rValue = "";
        } else {
            rValue = s;
        }
        return rValue;
    }

    public static int printNumbers(int min, int max) {
        int digit = 0;
        if (min <= max) {
//            System.out.print(num + " ");
//            printNumbers(num + 1);
            digit = min;
            Log.e("digit", String.valueOf(digit));
        }
        return digit;
    }
/*
    public static LoginModel passwordValidaton(String password) {
        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        LoginModel model = new LoginModel();
        if (password.length() < 8) {
            model.setOut_code("1");
            model.setOut_message("Password must have at least 8 character !!");


        } else if (!specailCharPatten.matcher(password).find()) {
            model.setOut_code("1");
            model.setOut_message("Password must have at least one special character !!");

        } else if (!UpperCasePatten.matcher(password).find()) {

            model.setOut_code("1");
            model.setOut_message("Password must have at least one uppercase character !!");
        } else if (!lowerCasePatten.matcher(password).find()) {
            model.setOut_code("1");
            model.setOut_message("Password must have at least one lowercase character !!");

        } else if (!digitCasePatten.matcher(password).find()) {
            model.setOut_code("1");
            model.setOut_message("Password must have at least one digit character !!");
        } else {
            model.setOut_code("0");
            model.setOut_message("password matched success");

        }

        return model;
    }

*/
}
