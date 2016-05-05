package technobytes.com.eloquence.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.squareup.otto.Subscribe;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.fragments.AddGuestFragment;
import technobytes.com.eloquence.fragments.AddGuestFragment_;
import technobytes.com.eloquence.fragments.CalendarFragment;
import technobytes.com.eloquence.fragments.CalendarFragment_;
import technobytes.com.eloquence.fragments.CheckInFragment;
import technobytes.com.eloquence.fragments.CheckInFragment_;
import technobytes.com.eloquence.fragments.DashboardMainFragment;
import technobytes.com.eloquence.fragments.DashboardMainFragment_;
import technobytes.com.eloquence.utils.eventbus.ClickedCheckIn;
import technobytes.com.eloquence.utils.eventbus.ContinueCheckin;
import technobytes.com.eloquence.utils.eventbus.EventsBus;

/**
 * Created by seisan on 4/18/16.
 */
@EActivity(R.layout.dashboard)
public class Dashboard extends AppCompatActivity {

    FragmentTransaction ft;
    CalendarFragment calendarFragment;
    DashboardMainFragment dashboardMainFragment;
    AddGuestFragment addGuestFragment;
    CheckInFragment checkInFragment;

    android.support.v7.app.ActionBar ab;


    @Bean
    EventsBus bus;


    @ViewById
    LinearLayout container1, container2;

    @AfterInject
    void AfterInject(){
        calendarFragment = new CalendarFragment_();
        dashboardMainFragment= new DashboardMainFragment_();
        addGuestFragment = new AddGuestFragment_();
        checkInFragment = new CheckInFragment_();

    }

    @AfterViews
    void AfterViews(){

        ab = getSupportActionBar();
        FragmentManager fm = getFragmentManager();

        ft= fm.beginTransaction().add(R.id.container1, dashboardMainFragment);

        ft.replace(R.id.container1, dashboardMainFragment).commit();

        ft = fm.beginTransaction().add(R.id.container2, calendarFragment);
        ft.replace(R.id.container2,calendarFragment).commit();

    }
    @Override
    public void onStart(){
        bus.register(this);
        super.onStart();
    }
    @Override
    public void onStop(){

        bus.unregister(this);
        super.onStop();

    }

    @Subscribe
    public void clickedCheckin(ClickedCheckIn event){
        FragmentManager fm = getFragmentManager();


        ft = fm.beginTransaction().remove(calendarFragment);
        ft.remove(calendarFragment).commit();

        ft = fm.beginTransaction().remove(dashboardMainFragment);
        ft.remove(dashboardMainFragment).commit();

        ft = fm.beginTransaction().add(R.id.container1, addGuestFragment);


        ft.setCustomAnimations(R.animator.enter_left, R.animator.exit_right).replace(R.id.container1, addGuestFragment).commit();

        ft = fm.beginTransaction().add(R.id.container2, checkInFragment);
        ft.setCustomAnimations(R.animator.enter_left, R.animator.exit_right).replace(R.id.container2, checkInFragment).commit();


    }



    @Subscribe
    public void clickedContinue(ContinueCheckin checkin){
        FragmentManager fm = getFragmentManager();

        ft = fm.beginTransaction().remove(addGuestFragment);
        ft.remove(addGuestFragment).commit();

        ft = fm.beginTransaction().remove(checkInFragment);
        ft.remove(checkInFragment).commit();

        ft= fm.beginTransaction().add(R.id.container1, dashboardMainFragment);

        ft.replace(R.id.container1, dashboardMainFragment).commit();

        ft = fm.beginTransaction().add(R.id.container2, calendarFragment);
        ft.replace(R.id.container2,calendarFragment).commit();

    }

}
