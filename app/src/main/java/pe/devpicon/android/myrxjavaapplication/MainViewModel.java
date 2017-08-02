package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;

import java.util.List;

import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by armando on 8/2/17.
 */

public class MainViewModel {

    private final BehaviorSubject<Language> selectedLanguage = BehaviorSubject.create();

    @NonNull
    private final IDataModel mDataModel;

    public MainViewModel(@NonNull final IDataModel dataModel) {
        this.mDataModel = dataModel;
    }

    @NonNull
    public Observable<String> getGreeting(){
        return selectedLanguage.map(Language::getLanguageCode).flatMap(mDataModel::getGreetingByLanguage);
    }

    @NonNull
    public Observable<List<Language>> getSupportedLanguages(){
        return mDataModel.getSupportedLanguages();
    }

    public void selectedLanguage(Language selectedLanguage) {
        this.selectedLanguage.onNext(selectedLanguage);
    }
}
