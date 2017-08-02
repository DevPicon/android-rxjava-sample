package pe.devpicon.android.myrxjavaapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import pe.devpicon.android.myrxjavaapplication.app.RxJavaApp;
import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @NonNull
    private final CompositeSubscription suscription = new CompositeSubscription();

    @NonNull
    private MainViewModel mViewModel;

    @Nullable
    private TextView mGreetingView;

    @Nullable
    private Spinner languageSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new MainViewModel(getDataModel());

        mGreetingView = (TextView) findViewById(R.id.greeting);
        languageSpinner = (Spinner)findViewById(R.id.languages);
    }

    private IDataModel getDataModel() {
        return ((RxJavaApp)getApplication()).getDataModel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unBind();
    }

    private void unBind() {
        suscription.unsubscribe();
    }

    private void bind() {
        suscription.add(mViewModel.getGreeting()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setGreeting));

        suscription.add(mViewModel.getSupportedLanguages()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setLanguages));
    }

    public void setGreeting(@NonNull final String greeting) {
        assert this.mGreetingView != null;
        this.mGreetingView.setText(greeting);
    }

    private void setLanguages(@NonNull final List<Language> languages){
        assert this.languageSpinner != null;
        LanguageSpinnerAdapter adapter = new LanguageSpinnerAdapter(this, R.layout.language_item, languages);
        languageSpinner.setAdapter(adapter);
    }
}
