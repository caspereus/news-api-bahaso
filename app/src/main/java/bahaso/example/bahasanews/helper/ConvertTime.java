package bahaso.example.bahasanews.helper;

import java.text.DateFormatSymbols;
import java.time.Month;

public class ConvertTime {

    public String convert(String time)
    {
        String year,month,date;

        year  = time.substring(0,4);
        month = time.substring(6,7);
        date  = time.substring(8,10);

        return date+" , "+getMonth(Integer.parseInt(month))+" "+year;

    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }


}
