package technobytes.com.eloquence.fragments;

import android.app.Fragment;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.rest.Data;
import technobytes.com.eloquence.rest.responses.LoadCalendarAvailability;
import technobytes.com.eloquence.utils.Globals;

/**
 * Created by seisan on 4/18/16.
 */
@EFragment(R.layout.calendar)
public class CalendarFragment extends Fragment{


    LoadCalendarAvailability loadCalendarAvailability;

    GregorianCalendar calendar;
    String month, year;
    List<RelativeLayout> listOfCells;
    @App
    Globals app;

    @RestService
    Data restClient;

    @ViewById
    ImageButton btnLeftArrow, btnRightArrow;

    @ViewById
    RelativeLayout calendarcell_01, calendarcell_02, calendarcell_03, calendarcell_04, calendarcell_05, calendarcell_06, calendarcell_07,
            calendarcell_08, calendarcell_09, calendarcell_10, calendarcell_11, calendarcell_12, calendarcell_13, calendarcell_14,
            calendarcell_15, calendarcell_16, calendarcell_17, calendarcell_18, calendarcell_19, calendarcell_20, calendarcell_21,
            calendarcell_22, calendarcell_23, calendarcell_24, calendarcell_25, calendarcell_26, calendarcell_27, calendarcell_28,
            calendarcell_29, calendarcell_30, calendarcell_31, calendarcell_32, calendarcell_33, calendarcell_34, calendarcell_35,
            calendarcell_36, calendarcell_37, calendarcell_38, calendarcell_39, calendarcell_40, calendarcell_41, calendarcell_42;
    @ViewById
    TextView tvMonth, tvYear;

    @AfterInject
    void AfterInject(){



        calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        month = getMonth(calendar.get(Calendar.MONTH));
        year = String.valueOf(calendar.get(Calendar.YEAR));
        Log.d("Date",""+ month);
    }

    @AfterViews
    void AfterViews(){
        listOfCells = new ArrayList<RelativeLayout>();
        listOfCells.add(calendarcell_01); listOfCells.add(calendarcell_02); listOfCells.add(calendarcell_03); listOfCells.add(calendarcell_04);
        listOfCells.add(calendarcell_05); listOfCells.add(calendarcell_06); listOfCells.add(calendarcell_07); listOfCells.add(calendarcell_08);
        listOfCells.add(calendarcell_09); listOfCells.add(calendarcell_10); listOfCells.add(calendarcell_11); listOfCells.add(calendarcell_12);
        listOfCells.add(calendarcell_13); listOfCells.add(calendarcell_14); listOfCells.add(calendarcell_15); listOfCells.add(calendarcell_16);
        listOfCells.add(calendarcell_17); listOfCells.add(calendarcell_18); listOfCells.add(calendarcell_19); listOfCells.add(calendarcell_20);
        listOfCells.add(calendarcell_21); listOfCells.add(calendarcell_22); listOfCells.add(calendarcell_23); listOfCells.add(calendarcell_24);
        listOfCells.add(calendarcell_25); listOfCells.add(calendarcell_26); listOfCells.add(calendarcell_27); listOfCells.add(calendarcell_28);
        listOfCells.add(calendarcell_29); listOfCells.add(calendarcell_30); listOfCells.add(calendarcell_31); listOfCells.add(calendarcell_32);
        listOfCells.add(calendarcell_33); listOfCells.add(calendarcell_34); listOfCells.add(calendarcell_35); listOfCells.add(calendarcell_36);
        listOfCells.add(calendarcell_37); listOfCells.add(calendarcell_38); listOfCells.add(calendarcell_39); listOfCells.add(calendarcell_40);
        listOfCells.add(calendarcell_41); listOfCells.add(calendarcell_42);

        setDates(calendar);

        tvMonth.setText(month);
        tvYear.setText(year);


    }
    public void setDates(GregorianCalendar calendar){


        Date date =calendar.getTime();
        GregorianCalendar day = new GregorianCalendar();
        day.setTime(date);

        day.set(Calendar.DAY_OF_WEEK, 1);



        Date newDate = day.getTime();

        for(RelativeLayout cell: listOfCells){
            TextView tvDate = (TextView)cell.findViewById(R.id.tvDate);
            TextView tvAvailability = (TextView)cell.findViewById(R.id.tvAvailability);
            tvDate.setText(String.valueOf(day.get(Calendar.DATE)));
            Log.d("checking dates", String.valueOf(day.get(Calendar.DATE)));
            getAvailability(String.valueOf(day.get(Calendar.YEAR)), getMonth(day.get(Calendar.MONTH)), String.valueOf(day.get(Calendar.DATE)), tvAvailability);
            day.add(Calendar.DATE, 1);


        }
    }

    @Background
    void getAvailability(String year, String month, String date, TextView tv){
        restClient.setHeader("x-access-token", app.getToken());
        try {
            loadCalendarAvailability = restClient.getCalendarAvailability(year, month, date);
        }catch (RestClientException e){
            Log.d("Calendar Error", e.getMessage());

        }
        if(loadCalendarAvailability != null){
            setAvailability("Availability: " + String.valueOf(loadCalendarAvailability.getAvailability()), tv);
        }

    }

    @Click(R.id.btnLeftArrow)
    void subtractMonth(){


        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
        month = getMonth(calendar.get(Calendar.MONTH));
        year = String.valueOf(calendar.get(Calendar.YEAR));
        setDates(calendar);
        tvMonth.setText(month);
        tvYear.setText(year);
    }
    @Click(R.id.btnRightArrow)
    void addMonth(){


        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
        month = getMonth(calendar.get(Calendar.MONTH));
        year = String.valueOf(calendar.get(Calendar.YEAR));
        setDates(calendar);

        tvMonth.setText(month);
        tvYear.setText(year);
    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setAvailability(String Availabilty, TextView tv){
        tv.setText(Availabilty);

    }

    public String getMonth(int month){
        String currentMonth;

        switch(month) {
            case 0:
                currentMonth = "January";
                break;
            case 1:
                currentMonth = "February";
                break;
            case 2:
                currentMonth = "March";
                break;
            case 3:
                currentMonth = "April";
                break;
            case 4:
                currentMonth = "May";
                break;
            case 5:
                currentMonth = "June";
                break;
            case 6:
                currentMonth = "July";
                break;
            case 7:
                currentMonth = "August";
                break;
            case 8:
                currentMonth = "September";
                break;
            case 9:
                currentMonth = "October";
                break;
            case 10:
                currentMonth = "November";
                break;
            case 11:
                currentMonth = "December";
                break;
            default:
                currentMonth = "Invalid Month";
                break;

        }
        return currentMonth;

    }

}
