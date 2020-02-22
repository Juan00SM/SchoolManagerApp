package com.juansm.schoolmanager.View.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class ChooseDatePickerDialog {

    private String resultDate;
    public ChooseDatePickerDialog() {
    }

    public String getResultDate(){
        return this.resultDate;
    }

    public DatePickerDialog createAndShowDatePicker(Context context, String date){
        int yearValue, monthValue, dayValue;
        if (date!=null && !date.equals("")){
            resultDate = date;
            String[] dateSplit = date.split("[/-]");
            yearValue = Integer.valueOf(dateSplit[2]);
            monthValue = Integer.valueOf(dateSplit[1])-1;
            dayValue = Integer.valueOf(dateSplit[0]);
        }else{
            resultDate = "";
            Calendar c = Calendar.getInstance();
            yearValue = c.get(Calendar.YEAR);
            monthValue = c.get(Calendar.MONTH);
            dayValue = c.get(Calendar.DAY_OF_MONTH);
        }


        DatePickerDialog datepicker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                int monthCh = month+1;
                String monthChanged = monthCh<10?("0"+monthCh):String.valueOf(monthCh);
                String dayChanged = dayOfMonth<10?("0"+dayOfMonth):String.valueOf(dayOfMonth);

                resultDate = dayChanged+"/"+monthChanged+"/"+year;
            }
        }, yearValue, monthValue, dayValue);
        datepicker.show();
        return datepicker;
    }
}
