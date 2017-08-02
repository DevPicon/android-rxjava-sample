package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @NonNull
    private final CompositeSubscription suscription = new CompositeSubscription();

    @NonNull
    private MainViewModel mViewModel = MainViewModel.getInstance();

    @Nullable
    private TextView mGreetingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingView = (TextView) findViewById(R.id.greeting);
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
        suscription.add(mViewModel.getGreeting().subscribe(this::setGreeting));
    }

    public void setGreeting(@NonNull final String greeting) {
        this.mGreetingView.setText(greeting);
    }
}
