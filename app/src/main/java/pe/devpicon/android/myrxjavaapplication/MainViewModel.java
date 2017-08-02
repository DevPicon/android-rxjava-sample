package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import pe.devpicon.android.myrxjavaapplication.datamodel.DataModel;
import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;

/**
 * Created by armando on 8/2/17.
 */

public class MainViewModel {

    @Nullable
    private static MainViewModel mInstance;

    @NonNull
    private final IDataModel mDataModel;

    public static MainViewModel getInstance(){
        if(mInstance == null){
            mInstance = new MainViewModel();
        }
        return mInstance;
    }

    private MainViewModel() {
        this.mDataModel = DataModel.getInstance();
    }

    public String getGreeting(){
        return mDataModel.getGreeting();
    }
}
