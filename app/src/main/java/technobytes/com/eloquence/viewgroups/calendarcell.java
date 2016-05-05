package technobytes.com.eloquence.viewgroups;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.web.client.RestClientException;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.rest.Data;
import technobytes.com.eloquence.rest.responses.LoadCalendarAvailability;
import technobytes.com.eloquence.utils.Globals;

/**
 * Created by seisan on 5/5/16.
 */
@EViewGroup(R.layout.calendarcell)
public class calendarcell extends RelativeLayout{

    Context context;

    LoadCalendarAvailability loadCalendarAvailability;

    @App
    Globals app;

    @ViewById
    TextView tvCheckouts, tvCheckins, tvAvailability, tvDate;

    @RestService
    Data restClient;


    @Background
    public void getAvailability(String year, String month, String date){
        restClient.setHeader("x-access-token", app.getToken());
        try {
            loadCalendarAvailability = restClient.getCalendarAvailability(year, month, date);
        }catch (RestClientException e){
            Log.d("Calendar Error", e.getMessage());

        }
        if(loadCalendarAvailability != null){
            setAvailabilityAndDate(date);
        }

    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setAvailabilityAndDate(String date){
        tvDate.setText(date);
        tvAvailability.setText("Availability: " + String.valueOf(loadCalendarAvailability.getAvailability()));

    }


    public calendarcell(Context context) {
        super(context);
        this.context = context;
    }

    public calendarcell(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

    }

    public calendarcell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

    }

    public calendarcell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;

    }
}
