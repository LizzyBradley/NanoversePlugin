package com.nanoverseplugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class NanoverseLexerAdapter extends FlexAdapter {
    public NanoverseLexerAdapter() {
        super(new NanoverseLexer((Reader) null));
    }
}
