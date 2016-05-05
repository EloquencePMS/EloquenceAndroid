package technobytes.com.eloquence.fragments;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.squareup.otto.Subscribe;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.rest.Data;
import technobytes.com.eloquence.rest.eventbus.EventBus;
import technobytes.com.eloquence.rest.models.Company;
import technobytes.com.eloquence.rest.models.Guest;
import technobytes.com.eloquence.utils.Globals;
import technobytes.com.eloquence.utils.eventbus.ContinueCheckin;

/**
 * Created by seisan on 5/5/16.
 */
@EFragment(R.layout.add_guest)
public class AddGuestFragment extends Fragment {

    Context context;
    Guest newGuest;
    Company[] companies;
    int selectedCompany;

    Guest guest;
    List<String> listCompanies;

    @App
    Globals app;

    @RestService
    Data restService;

    @Bean
    EventBus bus;

    @ViewById
    EditText etFirstName, etLastName, etStreet, etCity, etState, etZip, etPhone, etEmail;
    @ViewById
    Spinner spnCompany;

    @AfterInject
    void AfterInject(){
        context = this.getActivity();
    }

    @AfterViews
    void AfterViews(){
        getCompanies();
    }

    @Subscribe
    public void clickedContinue(ContinueCheckin event){
        guest = new Guest(etFirstName.getText().toString(), etLastName.getText().toString(), etStreet.getText().toString(), etCity.getText().toString(), etState.getText().toString(), etZip.getText().toString(), etEmail.getText().toString(),etPhone.getText().toString(), selectedCompany);


        LinkedMultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();

        formData.add("fName", guest.getfName() );
        formData.add("lName", guest.getfName() );
        formData.add("street", guest.getfName() );
        formData.add("phoneNum", guest.getfName() );
        formData.add("email", guest.getfName() );
        formData.add("city", guest.getfName() );
        formData.add("state", guest.getfName() );
        formData.add("zipcode", guest.getfName() );
        formData.add("compId", String.valueOf(guest.getCompId()));






    }



    @Background
    void postGuest(LinkedMultiValueMap<String, String> formData){
        restService.setHeader("x-access-token", app.getToken());
        try{
            newGuest = restService.postNewGuest(formData);

        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }

        if (companies != null){
            listCompanies = new ArrayList<>();
            listCompanies.add("Please select");

            for (Company thisCompany:companies){
                listCompanies.add(thisCompany.getCompanyName());
            }

            setSpinnerCompanies();
        }

    }

    @Background
    void getCompanies(){
        restService.setHeader("x-access-token", app.getToken());
        try{
            companies = restService.getAllCompanies();
        }catch (RestClientException e){
            Log.d("DashboardMain Error", e.getMessage());
        }

        if (companies != null){
            listCompanies = new ArrayList<>();
            listCompanies.add("Please select");

            for (Company thisCompany:companies){
                listCompanies.add(thisCompany.getCompanyName());
            }

            setSpinnerCompanies();
        }

    }




    @UiThread(propagation = UiThread.Propagation.REUSE)
    void setSpinnerCompanies(){
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listCompanies);


        spnCompany.setAdapter(arrayAdapter);

        spnCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spnCompany.setSelection(position, true);

                for(Company thisCompany: companies){
                    if(thisCompany.getCompanyName() == listCompanies.get(position)){
                        selectedCompany = thisCompany.getCompanyId();

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

}
