package com.nanoverseplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.nanoverseplugin.NanoverseLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class NanoverseTokenType extends IElementType {
    public NanoverseTokenType(@NotNull @NonNls String debugName) {
        super(debugName, NanoverseLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SimpleTokenType." + super.toString();
    }
}
