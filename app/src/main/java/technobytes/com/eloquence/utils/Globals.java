package technobytes.com.eloquence.utils;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.UiThread;

import technobytes.com.eloquence.rest.models.Stay;

/**
 * Created by seisan on 4/7/16.
 */
@EApplication
public class Globals extends Application{

    String token;
    private AlertDialog alertDialog;
    ProgressDialog progressDialog;
    Stay[] checkins,checkouts, stayover;

    public Stay[] getCheckins() {
        return checkins;
    }

    public void setCheckins(Stay[] checkins) {
        this.checkins = checkins;
    }

    public Stay[] getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(Stay[] checkouts) {
        this.checkouts = checkouts;
    }

    public Stay[] getStayover() {
        return stayover;
    }

    public void setStayover(Stay[] stayover) {
        this.stayover = stayover;
    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void  showProgressDialog (Context context, String title, String message) {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void closeProgressDialog () {
        if(progressDialog != null){
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }


    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void showAlertDialog (Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
    builder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    });
    alertDialog = builder.create();
    alertDialog.show();
}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
