package pe.devpicon.android.myrxjavaapplication.datamodel;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import pe.devpicon.android.myrxjavaapplication.model.Language;
import rx.Observable;

import static pe.devpicon.android.myrxjavaapplication.model.Language.LanguageCode.DE;
import static pe.devpicon.android.myrxjavaapplication.model.Language.LanguageCode.EN;
import static pe.devpicon.android.myrxjavaapplication.model.Language.LanguageCode.ES;
import static pe.devpicon.android.myrxjavaapplication.model.Language.LanguageCode.FR;

/**
 * Created by armando on 8/2/17.
 */

public class DataModel implements IDataModel {

    @NonNull
    @Override
    public Observable<List<Language>> getSupportedLanguages() {
        List<Language> languages = Arrays.asList(
                                new Language("English", EN),
                                new Language("Spanish", ES),
                                new Language("French", FR),
                                new Language("German", DE)
        );
        return Observable.just(languages);
    }

    @NonNull
    @Override
    public Observable<String> getGreetingByLanguageCode(@NonNull final Language.LanguageCode code) {
        switch (code){
            case DE:
                return Observable.just("Guten Tag!");
            case EN:
                return Observable.just("Hello!");
            case FR:
                return Observable.just("Bonjour!");
            case ES:
                return Observable.just("Hola!");
            default:
                return Observable.never();
        }
    }


}
