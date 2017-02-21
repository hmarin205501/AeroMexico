import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;



public class CurrentDate {
    private String date;

    public CurrentDate() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
