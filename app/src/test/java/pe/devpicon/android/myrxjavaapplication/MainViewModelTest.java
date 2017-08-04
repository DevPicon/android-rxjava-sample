package pe.devpicon.android.myrxjavaapplication;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import pe.devpicon.android.myrxjavaapplication.datamodel.IDataModel;
import pe.devpicon.android.myrxjavaapplication.model.Language;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by armando on 8/2/17.
 */

public class MainViewModelTest {

    @Mock
    private IDataModel dataModel;

    private MainViewModel mainViewModel;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mainViewModel = new MainViewModel(dataModel);
    }

    @Test
    public void testGetSupportedLanguages_emitsCorrectLanguages(){
        Language de = new Language("German", Language.LanguageCode.DE);
        Language es = new Language("Spanish", Language.LanguageCode.ES);
        List<Language> languages = Arrays.asList(de, es);

        Mockito.when(dataModel.getSupportedLanguages()).thenReturn(Observable.just(languages));

        TestSubscriber<List<Language>> testSubscriber = new TestSubscriber<>();
        mainViewModel.getSupportedLanguages().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(languages);
    }

    @Test
    public void testGetGreeting_doesNotEmit_whenNoLanguagesSet(){
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        mainViewModel.getGreeting().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertNoValues();
    }

    @Test
    public void testGetGreeting_emitsCorrectGreeting_whenLanguageSet(){
        String enGreeting = "Hello";
        Language en = new Language("English", Language.LanguageCode.EN);
        Mockito.when(dataModel.getGreetingByLanguageCode(Language.LanguageCode.EN))
                .thenReturn(Observable.just(enGreeting));

        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        mainViewModel.getGreeting().subscribe(testSubscriber);
        mainViewModel.selectedLanguage(en);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(enGreeting);


    }
}
