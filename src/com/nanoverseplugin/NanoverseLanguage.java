package com.nanoverseplugin;

import com.intellij.lang.Language;

public class NanoverseLanguage extends Language {
    public static final NanoverseLanguage INSTANCE = new NanoverseLanguage();

    private NanoverseLanguage() {
        super("Nanoverse");
    }
}
