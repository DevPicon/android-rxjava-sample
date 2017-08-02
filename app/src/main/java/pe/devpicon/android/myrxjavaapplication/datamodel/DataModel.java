package pe.devpicon.android.myrxjavaapplication.datamodel;

import android.support.annotation.NonNull;

/**
 * Created by armando on 8/2/17.
 */

public class DataModel implements IDataModel {

    @NonNull
    private static IDataModel mInstance;

    public static IDataModel getInstance(){
        if(mInstance == null){
            mInstance = new DataModel();
        }
        return mInstance;
    }

    private DataModel() {
    }

    @Override
    public String getGreeting() {
        return "Hello there!";
    }
}
