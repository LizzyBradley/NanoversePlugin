package com.nanoverseplugin.psi;

        import com.intellij.extapi.psi.PsiFileBase;
        import com.intellij.openapi.fileTypes.FileType;
        import com.intellij.psi.FileViewProvider;
        import com.nanoverseplugin.NanoverseFileType;
        import com.nanoverseplugin.NanoverseLanguage;
        import org.jetbrains.annotations.NotNull;

        import javax.swing.*;

public class NanoverseFile extends PsiFileBase {
    public NanoverseFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, NanoverseLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return NanoverseFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Nanoverse File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
