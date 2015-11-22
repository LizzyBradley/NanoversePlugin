// This is a generated file. Not intended for manual editing.
package com.nanoverseplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class NanoverseVisitor extends PsiElementVisitor {

  public void visitComment(@NotNull NanoverseComment o) {
    visitPsiElement(o);
  }

  public void visitId(@NotNull NanoverseId o) {
    visitPsiElement(o);
  }

  public void visitLineComment(@NotNull NanoverseLineComment o) {
    visitPsiElement(o);
  }

  public void visitPrimitive(@NotNull NanoversePrimitive o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
