package pe.devpicon.android.myrxjavaapplication.datamodel;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import pe.devpicon.android.myrxjavaapplication.Language;
import rx.Observable;

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


    @NonNull
    @Override
    public Observable<List<Language>> getSupportedLanguages() {
        List<Language> languages = Arrays.asList(
                                new Language("English", "EN"),
                                new Language("Spanish", "ES"),
                                new Language("German", "DE")
        );
        return Observable.just(languages);
    }

    @NonNull
    @Override
    public Observable<String> getGreetingStream() {
        return Observable.just("Hello there");
    }
}
