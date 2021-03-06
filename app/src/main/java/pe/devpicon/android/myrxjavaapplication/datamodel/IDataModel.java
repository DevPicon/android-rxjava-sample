package pe.devpicon.android.myrxjavaapplication.datamodel;

import android.support.annotation.NonNull;

import java.util.List;

import pe.devpicon.android.myrxjavaapplication.model.Language;
import rx.Observable;

/**
 * Created by armando on 8/2/17.
 */

public interface IDataModel {

    @NonNull
    Observable<List<Language>> getSupportedLanguages();

    @NonNull
    Observable<String> getGreetingByLanguageCode(@NonNull final Language.LanguageCode code);
}
