// This is a generated file. Not intended for manual editing.
package com.nanoverseplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.nanoverseplugin.psi.NanoverseTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NanoverseParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == ID) {
      r = id(b, 0);
    }
    else if (t == LINE_COMMENT) {
      r = lineComment(b, 0);
    }
    else if (t == PRIMITIVE) {
      r = primitive(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return nanoverseFile(b, l + 1);
  }

  /* ********************************************************** */
  // id colon Space? singleton
  //             | id block
  static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_0(b, l + 1);
    if (!r) r = assignment_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id colon Space? singleton
  private static boolean assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && assignment_0_2(b, l + 1);
    r = r && singleton(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Space?
  private static boolean assignment_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_0_2")) return false;
    consumeToken(b, SPACE);
    return true;
  }

  // id block
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment semi
  static boolean assignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' (statement_)* '}'
  static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (statement_)*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (statement_)
  private static boolean block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'True' | 'False'
  static boolean bool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "True");
    if (!r) r = consumeToken(b, "False");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bool
  static boolean boolPrimitive(PsiBuilder b, int l) {
    return bool(b, l + 1);
  }

  /* ********************************************************** */
  // 'regexp:/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/'
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<comment>");
    r = consumeToken(b, "regexp:/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/");
    exit_section_(b, l, m, COMMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'regexp:[Ee][+/-]?[1-9][0-9]*'
  static boolean exp(PsiBuilder b, int l) {
    return consumeToken(b, "regexp:[Ee][+/-]?[1-9][0-9]*");
  }

  /* ********************************************************** */
  // float_
  static boolean floatPrimitive(PsiBuilder b, int l) {
    return float_(b, l + 1);
  }

  /* ********************************************************** */
  // '-'? int_ '.' (('0')+ | int_)+ exp? | '-'? int_ exp
  static boolean float_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = float__0(b, l + 1);
    if (!r) r = float__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-'? int_ '.' (('0')+ | int_)+ exp?
  private static boolean float__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = float__0_0(b, l + 1);
    r = r && int_(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && float__0_3(b, l + 1);
    r = r && float__0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-'?
  private static boolean float__0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0_0")) return false;
    consumeToken(b, "-");
    return true;
  }

  // (('0')+ | int_)+
  private static boolean float__0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = float__0_3_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!float__0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "float__0_3", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ('0')+ | int_
  private static boolean float__0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = float__0_3_0_0(b, l + 1);
    if (!r) r = int_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('0')+
  private static boolean float__0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = float__0_3_0_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!float__0_3_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "float__0_3_0_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ('0')
  private static boolean float__0_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "0");
    exit_section_(b, m, null, r);
    return r;
  }

  // exp?
  private static boolean float__0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__0_4")) return false;
    exp(b, l + 1);
    return true;
  }

  // '-'? int_ exp
  private static boolean float__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = float__1_0(b, l + 1);
    r = r && int_(b, l + 1);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-'?
  private static boolean float__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float__1_0")) return false;
    consumeToken(b, "-");
    return true;
  }

  /* ********************************************************** */
  // 'regexp:[a-zA-Z][a-zA-Z0-9]*'
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<id>");
    r = consumeToken(b, "regexp:[a-zA-Z][a-zA-Z0-9]*");
    exit_section_(b, l, m, ID, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id semi
  static boolean idStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // integer
  static boolean intPrimitive(PsiBuilder b, int l) {
    return integer(b, l + 1);
  }

  /* ********************************************************** */
  // '0' | 'regexp:[1-9][0-9]*'
  static boolean int_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "0");
    if (!r) r = consumeToken(b, "regexp:[1-9][0-9]*");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-'? int_
  static boolean integer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_0(b, l + 1);
    r = r && int_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-'?
  private static boolean integer_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_0")) return false;
    consumeToken(b, "-");
    return true;
  }

  /* ********************************************************** */
  // 'regexp://.*'
  public static boolean lineComment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineComment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<line comment>");
    r = consumeToken(b, "regexp://.*");
    exit_section_(b, l, m, LINE_COMMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement_*
  static boolean nanoverseFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nanoverseFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nanoverseFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // stringPrimitive
  //             | floatPrimitive
  //             | intPrimitive
  //             | boolPrimitive
  public static boolean primitive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<primitive>");
    r = stringPrimitive(b, l + 1);
    if (!r) r = floatPrimitive(b, l + 1);
    if (!r) r = intPrimitive(b, l + 1);
    if (!r) r = boolPrimitive(b, l + 1);
    exit_section_(b, l, m, PRIMITIVE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primitive semi
  static boolean primitiveStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primitive(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment
  //             | id
  //             | primitive
  static boolean singleton(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleton")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment(b, l + 1);
    if (!r) r = id(b, l + 1);
    if (!r) r = primitive(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Space
  //             | lineComment
  //             | comment
  //             | assignmentStatement
  //             | idStatement
  //             | primitiveStatement
  static boolean statement_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPACE);
    if (!r) r = lineComment(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = assignmentStatement(b, l + 1);
    if (!r) r = idStatement(b, l + 1);
    if (!r) r = primitiveStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "regexp:('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")"
  static boolean string(PsiBuilder b, int l) {
    return consumeToken(b, "regexp:('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")");
  }

  /* ********************************************************** */
  // string
  static boolean stringPrimitive(PsiBuilder b, int l) {
    return string(b, l + 1);
  }

}
