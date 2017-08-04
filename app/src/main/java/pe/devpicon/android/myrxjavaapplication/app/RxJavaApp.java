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
    private final IDataModel dataModel;


    public RxJavaApp() {
        dataModel = new DataModel();
    }

    @NonNull
    public IDataModel getDataModel() {
        return dataModel;
    }
}
