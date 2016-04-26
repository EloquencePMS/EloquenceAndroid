package technobytes.com.eloquence.fragments;

import android.app.Fragment;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.web.client.RestClientException;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.rest.Data;
import technobytes.com.eloquence.rest.models.Room;
import technobytes.com.eloquence.rest.models.Stay;
import technobytes.com.eloquence.rest.responses.LoadInitialData;
import technobytes.com.eloquence.rest.weather.Weather;
import technobytes.com.eloquence.rest.weather.models.getCurrentWeather;
import technobytes.com.eloquence.utils.Globals;

/**
 * Created by seisan on 4/18/16.
 */
@EFragment(R.layout.dashboard_main)
public class DashboardMainFragment extends Fragment{

    getCurrentWeather weather;
    LoadInitialData loadInitialData;

    int clean, dirty, rfi, reclean, checkIns, checkOuts, NQQS, NKS, NQQ, NK;


    @App
    Globals app;

    @RestService
    Weather weatherService;
    @RestService
    Data restService;
    RelativeLayout[] cells;

    @ViewById
    RelativeLayout weathercell_01, weathercell_02, weathercell_03, weathercell_04, weathercell_05;
    @ViewById
    TextView tvClean, tvDirty, tvRFI, tvReclean, tvADR, tvCheckins, tvCheckouts, tvStayOvers;
    @ViewById
    Button btnNQQS, btnNKS, btnNQQ, btnNK;

    @AfterInject
    void AfterInject(){

    }
    @AfterViews
    void AfterViews(){
        cells = new RelativeLayout [5];
        cells[0]=weathercell_01;
        cells[1]=weathercell_02;
        cells[2]=weathercell_03;
        cells[3]=weathercell_04;
        cells[4]=weathercell_05;

        loadInitialData();
    }

    @Background
    void loadInitialData(){
        restService.setHeader("x-access-token", app.getToken());
        try{
            loadInitialData = restService.loadInitialData();
        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }
        if (loadInitialData != null){
            app.setCheckins(loadInitialData.getCheckIns());
            app.setCheckouts(loadInitialData.getCheckOuts());
            app.setStayover(loadInitialData.getStayOver());

            weather();
        }

    }

    @Background
    void weather(){
        try{
            weather = weatherService.GetCurrentWeather("17745");

        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());

        }
        if (weather != null && loadInitialData != null){
            Log.d("weather not null", weather.toString());

            setViews();
        }
    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setViews(){
        for(Room room : loadInitialData.getRooms()){


            switch (room.getHouseKeepingStatusId()){
                case 1: clean++;
                    break;
                case 2: dirty++;
                    break;
                case 3: rfi++;
                    break;
                case 4: reclean++;
                    break;
            }


            switch(room.getRoomType()){
                case "NQQS": NQQS++;
                    break;
                case "NKS": NKS++;
                    break;
                case "NQQ": NQQ++;
                    break;
                case "NK": NK++;
                    break;
            }
        }
        for(Stay checkin: loadInitialData.getCheckIns()){
            switch(checkin.getRoomType()){
                case "NQQS": NQQS--;
                    break;
                case "NKS": NKS--;
                    break;
                case "NQQ": NQQ--;
                    break;
                case "NK": NK--;
                    break;
            }
        }
        for(Stay stayover: loadInitialData.getStayOver()){
            switch(stayover.getRoomType()){
                case "NQQS": NQQS--;
                    break;
                case "NKS": NKS--;
                    break;
                case "NQQ": NQQ--;
                    break;
                case "NK": NK--;
                    break;
            }
        }

        tvCheckins.setText(String.valueOf(loadInitialData.getCheckIns().length));
        tvCheckouts.setText(String.valueOf(loadInitialData.getCheckOuts().length));
        tvStayOvers.setText(String.valueOf(loadInitialData.getStayOver().length));
        tvClean.setText(String.valueOf( clean));
        tvDirty.setText(String.valueOf(dirty));
        tvReclean.setText(String.valueOf(reclean));
        tvRFI.setText(String.valueOf(rfi));
        btnNK.setText("NK: ("+String.valueOf(NK)+")");
        btnNKS.setText("NKS: ("+String.valueOf(NKS)+")");
        btnNQQ.setText("NQQ: ("+String.valueOf(NQQ)+")");
        btnNQQS.setText("NQQS: ("+String.valueOf(NQQS)+")");


        for(int i = 0; i < 5; i++){
            ImageView view = (ImageView) cells[i].findViewById(R.id.ivDay);
            TextView date = (TextView) cells[i].findViewById(R.id.tvDate);
            TextView day = (TextView) cells[i].findViewById(R.id.tvDay);
            TextView tempHigh = (TextView) cells[i].findViewById(R.id.tvTempHigh);
            TextView tempLow = (TextView) cells[i].findViewById(R.id.tvTempLow);

            TextView condition= (TextView) cells[i].findViewById(R.id.tvCondition);

            setImage(view, weather.getForecast().getSimpleforecast().getForecastday()[i].getIcon());
            day.setText(weather.getForecast().getSimpleforecast().getForecastday()[i].getDate().getWeekday());
            date.setText(String.valueOf(weather.getForecast().getSimpleforecast().getForecastday()[i].getDate().getDay()));
            tempHigh.setText("High: " + weather.getForecast().getSimpleforecast().getForecastday()[i].getHigh().getFahrenheit());
            tempLow.setText("Low: "+ weather.getForecast().getSimpleforecast().getForecastday()[i].getLow().getFahrenheit());
            condition.setText(weather.getForecast().getSimpleforecast().getForecastday()[i].getConditions());

        }

    }

    public void setImage(ImageView view, String weather){
        switch (weather){
            case "chancerain":
                view.setImageResource(R.drawable.chancerain);
                break;
            case "chancesnow":
                view.setImageResource(R.drawable.chancesnow);

                break;
            case "chancetstorms":
                view.setImageResource(R.drawable.chancetstorms);

                break;
            case "clear":
                view.setImageResource(R.drawable.clear);

                break;
            case "cloudy":
                view.setImageResource(R.drawable.cloudy);

                break;
            case "fog":
                view.setImageResource(R.drawable.fog);
                break;
            case "mostlycloudy":
                view.setImageResource(R.drawable.mostlycloudy);
                break;
            case "mostlysunny":
                view.setImageResource(R.drawable.mostlysunny);
                break;
            case "partlycloudy":
                view.setImageResource(R.drawable.partialycloudy);
                break;
            case "partlysunny":
                view.setImageResource(R.drawable.partialysunny);
                break;
            case "rain":
                view.setImageResource(R.drawable.rain);
                break;
            case "sleet":
                view.setImageResource(R.drawable.sleet);
                break;
            case "snow":
                view.setImageResource(R.drawable.snow);
                break;
            case "tstorms":
                view.setImageResource(R.drawable.tstorms);
                break;
            default:
                break;
        }


    }

}
