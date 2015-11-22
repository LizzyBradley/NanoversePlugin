// This is a generated file. Not intended for manual editing.
package com.nanoverseplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.nanoverseplugin.psi.impl.*;

public interface NanoverseTypes {

  IElementType COMMENT = new NanoverseElementType("COMMENT");
  IElementType ID = new NanoverseElementType("ID");
  IElementType LINE_COMMENT = new NanoverseElementType("LINE_COMMENT");
  IElementType PRIMITIVE = new NanoverseElementType("PRIMITIVE");

  IElementType COLON = new NanoverseTokenType(":");
  IElementType SEMI = new NanoverseTokenType(";");
  IElementType SPACE = new NanoverseTokenType("Space");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == COMMENT) {
        return new NanoverseCommentImpl(node);
      }
      else if (type == ID) {
        return new NanoverseIdImpl(node);
      }
      else if (type == LINE_COMMENT) {
        return new NanoverseLineCommentImpl(node);
      }
      else if (type == PRIMITIVE) {
        return new NanoversePrimitiveImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
