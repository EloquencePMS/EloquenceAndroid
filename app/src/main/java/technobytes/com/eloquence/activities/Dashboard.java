package technobytes.com.eloquence.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.fragments.CalendarFragment;
import technobytes.com.eloquence.fragments.CalendarFragment_;
import technobytes.com.eloquence.fragments.DashboardMainFragment;
import technobytes.com.eloquence.fragments.DashboardMainFragment_;

/**
 * Created by seisan on 4/18/16.
 */
@EActivity(R.layout.dashboard)
public class Dashboard extends FragmentActivity {

    FragmentTransaction ft;
    CalendarFragment calendarFragment;
    DashboardMainFragment dashboardMainFragment;





    @ViewById
    LinearLayout container1, container2;

    @AfterInject
    void AfterInject(){
        calendarFragment = new CalendarFragment_();
        dashboardMainFragment= new DashboardMainFragment_();
    }

    @AfterViews
    void AfterViews(){
        FragmentManager fm = getFragmentManager();

        ft= fm.beginTransaction().add(R.id.container1, dashboardMainFragment);
        ft.replace(R.id.container1, dashboardMainFragment).commit();

        ft = fm.beginTransaction().add(R.id.container2, calendarFragment);
        ft.replace(R.id.container2,calendarFragment).commit();

    }



}
