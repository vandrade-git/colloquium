/*
 * This file is generated by jOOQ.
 */
package org.vandrade.colloquium.generated;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import org.vandrade.colloquium.generated.tables.LifelineTemplate;
import org.vandrade.colloquium.generated.tables.QuestionTemplate;
import org.vandrade.colloquium.generated.tables.Quiz;
import org.vandrade.colloquium.generated.tables.QuizLifeline;
import org.vandrade.colloquium.generated.tables.QuizQuestion;
import org.vandrade.colloquium.generated.tables.SqliteSequence;
import org.vandrade.colloquium.generated.tables.Statistics;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>lifeline_template</code>.
     */
    public final LifelineTemplate LIFELINE_TEMPLATE = LifelineTemplate.LIFELINE_TEMPLATE;

    /**
     * The table <code>question_template</code>.
     */
    public final QuestionTemplate QUESTION_TEMPLATE = QuestionTemplate.QUESTION_TEMPLATE;

    /**
     * The table <code>quiz</code>.
     */
    public final Quiz QUIZ = Quiz.QUIZ;

    /**
     * The table <code>quiz_lifeline</code>.
     */
    public final QuizLifeline QUIZ_LIFELINE = QuizLifeline.QUIZ_LIFELINE;

    /**
     * The table <code>quiz_question</code>.
     */
    public final QuizQuestion QUIZ_QUESTION = QuizQuestion.QUIZ_QUESTION;

    /**
     * The table <code>sqlite_sequence</code>.
     */
    public final SqliteSequence SQLITE_SEQUENCE = SqliteSequence.SQLITE_SEQUENCE;

    /**
     * The table <code>statistics</code>.
     */
    public final Statistics STATISTICS = Statistics.STATISTICS;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            LifelineTemplate.LIFELINE_TEMPLATE,
            QuestionTemplate.QUESTION_TEMPLATE,
            Quiz.QUIZ,
            QuizLifeline.QUIZ_LIFELINE,
            QuizQuestion.QUIZ_QUESTION,
            SqliteSequence.SQLITE_SEQUENCE,
            Statistics.STATISTICS);
    }
}