package pe.devpicon.android.myrxjavaapplication;

import android.support.annotation.NonNull;

/**
 * Created by armando on 8/2/17.
 */

public class Language {

    @NonNull
    private final String name;

    @NonNull
    private final String code;

    public Language(@NonNull final String name, @NonNull final String code) {
        this.name = name;
        this.code = code;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getCode() {
        return code;
    }
}
