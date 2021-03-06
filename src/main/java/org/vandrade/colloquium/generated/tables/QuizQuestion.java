/*
 * This file is generated by jOOQ.
 */
package org.vandrade.colloquium.generated.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.vandrade.colloquium.generated.DefaultSchema;
import org.vandrade.colloquium.generated.Keys;
import org.vandrade.colloquium.generated.tables.records.QuizQuestionRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuizQuestion extends TableImpl<QuizQuestionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>quiz_question</code>
     */
    public static final QuizQuestion QUIZ_QUESTION = new QuizQuestion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QuizQuestionRecord> getRecordType() {
        return QuizQuestionRecord.class;
    }

    /**
     * The column <code>quiz_question.id</code>.
     */
    public final TableField<QuizQuestionRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>quiz_question.created_at</code>.
     */
    public final TableField<QuizQuestionRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>quiz_question.updated_at</code>.
     */
    public final TableField<QuizQuestionRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>quiz_question.question_template_id</code>.
     */
    public final TableField<QuizQuestionRecord, Integer> QUESTION_TEMPLATE_ID = createField(DSL.name("question_template_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>quiz_question.quiz_id</code>.
     */
    public final TableField<QuizQuestionRecord, Integer> QUIZ_ID = createField(DSL.name("quiz_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>quiz_question.answer</code>.
     */
    public final TableField<QuizQuestionRecord, Integer> ANSWER = createField(DSL.name("answer"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>quiz_question.time_remaining</code>.
     */
    public final TableField<QuizQuestionRecord, Integer> TIME_REMAINING = createField(DSL.name("time_remaining"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("15", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>quiz_question.answered</code>.
     */
    public final TableField<QuizQuestionRecord, Boolean> ANSWERED = createField(DSL.name("answered"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    private QuizQuestion(Name alias, Table<QuizQuestionRecord> aliased) {
        this(alias, aliased, null);
    }

    private QuizQuestion(Name alias, Table<QuizQuestionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>quiz_question</code> table reference
     */
    public QuizQuestion(String alias) {
        this(DSL.name(alias), QUIZ_QUESTION);
    }

    /**
     * Create an aliased <code>quiz_question</code> table reference
     */
    public QuizQuestion(Name alias) {
        this(alias, QUIZ_QUESTION);
    }

    /**
     * Create a <code>quiz_question</code> table reference
     */
    public QuizQuestion() {
        this(DSL.name("quiz_question"), null);
    }

    public <O extends Record> QuizQuestion(Table<O> child, ForeignKey<O, QuizQuestionRecord> key) {
        super(child, key, QUIZ_QUESTION);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<QuizQuestionRecord, Integer> getIdentity() {
        return (Identity<QuizQuestionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<QuizQuestionRecord> getPrimaryKey() {
        return Keys.PK_QUIZ_QUESTION;
    }

    @Override
    public List<UniqueKey<QuizQuestionRecord>> getKeys() {
        return Arrays.<UniqueKey<QuizQuestionRecord>>asList(Keys.PK_QUIZ_QUESTION, Keys.SQLITE_AUTOINDEX_QUIZ_QUESTION_1);
    }

    @Override
    public List<ForeignKey<QuizQuestionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QuizQuestionRecord, ?>>asList(Keys.FK_QUIZ_QUESTION_QUESTION_TEMPLATE_1, Keys.FK_QUIZ_QUESTION_QUIZ_1);
    }

    private transient QuestionTemplate _questionTemplate;
    private transient Quiz _quiz;

    public QuestionTemplate questionTemplate() {
        if (_questionTemplate == null)
            _questionTemplate = new QuestionTemplate(this, Keys.FK_QUIZ_QUESTION_QUESTION_TEMPLATE_1);

        return _questionTemplate;
    }

    public Quiz quiz() {
        if (_quiz == null)
            _quiz = new Quiz(this, Keys.FK_QUIZ_QUESTION_QUIZ_1);

        return _quiz;
    }

    @Override
    public QuizQuestion as(String alias) {
        return new QuizQuestion(DSL.name(alias), this);
    }

    @Override
    public QuizQuestion as(Name alias) {
        return new QuizQuestion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QuizQuestion rename(String name) {
        return new QuizQuestion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QuizQuestion rename(Name name) {
        return new QuizQuestion(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, LocalDateTime, LocalDateTime, Integer, Integer, Integer, Integer, Boolean> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
