package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;

import java.util.List;

import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;
import rx.Observable;

/**
 * Created by armando on 8/2/17.
 */

public class MainViewModel {

    @NonNull
    private final IDataModel mDataModel;

    public MainViewModel(@NonNull final IDataModel dataModel) {
        this.mDataModel = dataModel;
    }

    @NonNull
    public Observable<String> getGreeting(){
        return mDataModel.getGreetingStream();
    }

    @NonNull
    public Observable<List<String>> getSupportedLanguages(){
        return mDataModel.getSupportedLanguages()
                .flatMap(languages -> Observable.from(languages)
                        .map(Language::getName)
                        .toList());
    }
}
