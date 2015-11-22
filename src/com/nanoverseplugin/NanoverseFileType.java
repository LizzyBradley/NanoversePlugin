package com.nanoverseplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NanoverseFileType extends LanguageFileType {
    public static final NanoverseFileType INSTANCE = new NanoverseFileType();

    private NanoverseFileType() {
        super(NanoverseLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Nanoverse file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Nanoverse language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "nano";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SimpleIcons.FILE;
    }
}
