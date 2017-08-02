package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import pe.devpicon.android.myrxjavaapplication.datamodel.DataModel;
import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;
import rx.Observable;

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

    @NonNull
    public Observable<String> getGreeting(){
        return mDataModel.getGreetingStream();
    }

    @NonNull
    public Observable<List<String>> getSupportedLanguages(){
        return mDataModel.getSupportedLanguages()
                .map(languages -> Observable.from(languages)
                        .map(Language::getName)
                        .toList()
                        .toBlocking()
                        .single());
    }
}
