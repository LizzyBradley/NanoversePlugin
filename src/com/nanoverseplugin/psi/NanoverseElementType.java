package com.nanoverseplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.nanoverseplugin.NanoverseLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class NanoverseElementType extends IElementType {
    public NanoverseElementType(@NotNull @NonNls String debugName) {
        super(debugName, NanoverseLanguage.INSTANCE);
    }
}
