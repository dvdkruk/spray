/*
 * generated by Xtext
 */
package org.eclipselabs.spray.shapes.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipselabs.spray.shapes.services.ShapeGrammarAccess;

import com.google.inject.Inject;

/**
 * This class contains custom formatting description.
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class ShapeFormatter extends AbstractDeclarativeFormatter {
    @Inject
    private ShapeGrammarAccess grammar;

    @Override
    protected void configureFormatting(FormattingConfig c) {
        c.setLinewrap(0, 1, 2).before(grammar.getSL_COMMENTRule());
        c.setLinewrap(0, 1, 2).before(grammar.getML_COMMENTRule());
        c.setLinewrap(0, 1, 1).after(grammar.getML_COMMENTRule());

        c.setAutoLinewrap(120);

        for (Pair<Keyword, Keyword> kw : grammar.findKeywordPairs("{", "}")) {
            c.setLinewrap().after(kw.getFirst());
            c.setLinewrap().around(kw.getSecond());
            c.setIndentation(kw.getFirst(), kw.getSecond());
        }
        for (Pair<Keyword, Keyword> kw : grammar.findKeywordPairs("(", ")")) {
            c.setSpace(" ").before(kw.getFirst());
            c.setNoSpace().after(kw.getFirst());
            c.setSpace(" ").after(kw.getSecond());
            c.setNoSpace().before(kw.getSecond());
        }
        // no space around =, except for text value assignment
        for (Keyword kw : grammar.findKeywords("=")) {
            c.setNoSpace().around(kw);
        }
        c.setSpace(" ").around(grammar.getTextBodyAccess().getEqualsSignKeyword_1());

        // no space befor comma, one space after
        for (Keyword kw : grammar.findKeywords(",")) {
            c.setNoSpace().before(kw);
            c.setSpace(" ").after(kw);
        }

        // linewraps
        // TODO: 1) Complement list 2) replace by using GrammarAccess getters
        for (Keyword kw : grammar.findKeywords("position", "point", "value", "size")) {
            c.setLinewrap().before(kw);
        }

        c.setLinewrap().before(grammar.getShapeRule());
        c.setLinewrap().before(grammar.getPointRule());
    }

}
