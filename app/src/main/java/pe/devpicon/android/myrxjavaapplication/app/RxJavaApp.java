package pe.devpicon.android.myrxjavaapplication.app;

import android.app.Application;
import android.support.annotation.NonNull;

import pe.devpicon.android.myrxjavaapplication.datamodel.DataModel;
import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;

/**
 * Created by armando on 8/2/17.
 */

public class RxJavaApp extends Application {

    @NonNull
    private IDataModel dataModel;

    @Override
    public void onCreate() {
        super.onCreate();
        initInstance();
    }

    private void initInstance() {
        dataModel = new DataModel();
    }

    @NonNull
    public IDataModel getDataModel() {
        return dataModel;
    }
}
