package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;

/**
 * Created by armando on 8/2/17.
 */

public class Language {

    public enum LanguageCode {
        EN, DE, FR, ES
    }

    @NonNull
    private final String name;

    @NonNull
    private final LanguageCode languageCode;

    public Language(@NonNull final String name, @NonNull final LanguageCode languageCode) {
        this.name = name;
        this.languageCode = languageCode;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public LanguageCode getLanguageCode() {
        return languageCode;
    }
}
