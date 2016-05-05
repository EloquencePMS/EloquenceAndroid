package technobytes.com.eloquence.fragments;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.rest.Data;
import technobytes.com.eloquence.rest.models.Market;
import technobytes.com.eloquence.rest.models.Rate;
import technobytes.com.eloquence.rest.models.RoomCollection;
import technobytes.com.eloquence.rest.models.RoomType;
import technobytes.com.eloquence.rest.models.Stay;
import technobytes.com.eloquence.utils.Globals;
import technobytes.com.eloquence.utils.eventbus.ContinueCheckin;
import technobytes.com.eloquence.utils.eventbus.EventsBus;

/**
 * Created by seisan on 5/5/16.
 */
@EFragment(R.layout.checkin)
public class CheckInFragment extends Fragment{

    Context context;


    Stay newStay;
    Rate [] rates;
    RoomType [] roomTypes;
    Market[] markets;
    RoomCollection[] rooms;

    int selectedRate, selectedRoom, selectedMarket, checkInDate, checkInMonth, checkInYear, checkOutDate, checkOutMonth, checkOutYear;
    String selectedRoomType;


    HashMap<String, ArrayList<RoomCollection>> Rooms = new HashMap<>();
    List<String> listRates = new ArrayList<>();
    List<String> listRoomTypes = new ArrayList<>();
    List<String> listRooms = new ArrayList<>();
    List<String> listMarkets = new ArrayList<>();

    @ViewById
    Spinner spnRate, spnRoomType, spnMarket, spnRoomNumber;

    @ViewById
    DatePicker dpCheckIn, dpCheckOut;

    @App
    Globals app;

    @Bean
    EventsBus bus;

    @RestService
    Data restService;


    @AfterInject
    void AfterInject(){
        context= this.getActivity();
    }

    @AfterViews
    void AfterViews(){
        app.showProgressDialog(context, "Loading", "Please wait");
        getRates();
        getMarkets();
        getRoomTypes();

    }

    @Background
    void getRates(){
        restService.setHeader("x-access-token", app.getToken());
        try{
            rates = restService.getAllRates();
        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }

        if (rates != null){
            listRates = new ArrayList<>();
            listRates.add("Please select");

            for (Rate thisRate:rates){
                listRates.add(thisRate.getName());
            }

            setSpinnerRates();
        }

    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setSpinnerRates(){
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listRates);


        spnRate.setAdapter(arrayAdapter);

        spnRate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spnRate.setSelection(position, true);

                for(Rate thisRate: rates){
                    if(thisRate.getName() == listRates.get(position)){
                        selectedRate = thisRate.getRateId();

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    @Background
    void getRooms(String roomTypes){
        app.showProgressDialog(context, "Loading", "Please wait...");
        restService.setHeader("x-access-token", app.getToken());
        try{
            rooms = restService.getAllRooms();
        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }

        if (rooms != null){
            ArrayList<RoomCollection> NQQ =  new ArrayList<>();
            ArrayList<RoomCollection> NQQS =  new ArrayList<>();
            ArrayList<RoomCollection> NK =  new ArrayList<>();
            ArrayList<RoomCollection> NKS =  new ArrayList<>();


            for (RoomCollection thisRoom: rooms){
                switch (thisRoom.getRoomType().getRoomType()){
                    case("NQQ"):
                        NQQ.add(thisRoom);
                        break;
                    case("NQQS"):
                        NQQS.add(thisRoom);
                        break;
                    case("NK"):
                        NK.add(thisRoom);
                        break;
                    case("NKS"):
                        NKS.add(thisRoom);
                        break;

                }

            }
            Rooms.put("NQQ", NQQ);
            Rooms.put("NQQS", NQQS);
            Rooms.put("NK", NK);
            Rooms.put("NKS", NKS);

            setSpinnerRooms(roomTypes);


        }

    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setSpinnerRooms(String roomType){
        listRooms.add("Please Select");
        for(RoomCollection thisRoom: Rooms.get(roomType)){
            if(thisRoom.getHouseKeepingStatusId() == 1 ){
                listRooms.add(String.valueOf(thisRoom.getRoomNumber()));
            }
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listRooms);

        app.closeProgressDialog();
        spnRoomNumber.setAdapter(arrayAdapter);

        spnRoomNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spnRoomNumber.setSelection(position, true);
                if(position !=0) {
                    selectedRoom = Integer.valueOf(listRooms.get(position));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Background
    void getMarkets(){
        restService.setHeader("x-access-token", app.getToken());
        try{
            markets = restService.getAllMarkets();
        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }

        if (markets != null){
            listMarkets = new ArrayList<>();
            listMarkets.add("Please select");
            for (Market thisMarket:markets){
                listMarkets.add(thisMarket.getTitle());
            }

            setSpinnerMarkets();
        }

    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setSpinnerMarkets() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listMarkets);


        spnMarket.setAdapter(arrayAdapter);

        spnMarket.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spnMarket.setSelection(position, true);

                for (Market thisMarket : markets) {
                    if (thisMarket.getTitle() == listMarkets.get(position)) {
                        selectedMarket = thisMarket.getMarketId();

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Background
    void getRoomTypes(){
        restService.setHeader("x-access-token", app.getToken());
        try{
            roomTypes = restService.getAllRoomTypes();
        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }


        listRoomTypes = new ArrayList<>();
        listRoomTypes.add("Please select");
        if (roomTypes != null){
            for (RoomType thisRoomType:roomTypes){
                listRoomTypes.add(thisRoomType.getRoomType());
            }

            setSpinnerRoomTypes();
        }

    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setSpinnerRoomTypes() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listRoomTypes);

        app.closeProgressDialog();
        spnRoomType.setAdapter(arrayAdapter);

        spnRoomType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spnRoomType.setSelection(position, true);

                for (RoomType thisRoomType : roomTypes) {
                    if (thisRoomType.getRoomType() == listRoomTypes.get(position)) {
                        selectedRoomType = thisRoomType.getRoomType();
                        getRooms(selectedRoomType);
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Click(R.id.btnContinue)
    void ClickedContinue(){
//        newStay = new Stay(-1, selectedRate, selectedMarket, -1, -1, app.getUserInfo().getUser().getUserId(), 0, )
        bus.post(new ContinueCheckin());

    }


}
