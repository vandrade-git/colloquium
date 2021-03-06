/*
 * This file is generated by jOOQ.
 */
package org.vandrade.colloquium.generated.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import org.vandrade.colloquium.generated.tables.Quiz;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuizRecord extends UpdatableRecordImpl<QuizRecord> implements Record4<Integer, LocalDateTime, LocalDateTime, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>quiz.id</code>.
     */
    public QuizRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>quiz.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>quiz.created_at</code>.
     */
    public QuizRecord setCreatedAt(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>quiz.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>quiz.updated_at</code>.
     */
    public QuizRecord setUpdatedAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>quiz.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>quiz.owner</code>.
     */
    public QuizRecord setOwner(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>quiz.owner</code>.
     */
    public String getOwner() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, LocalDateTime, LocalDateTime, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, LocalDateTime, LocalDateTime, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Quiz.QUIZ.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Quiz.QUIZ.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Quiz.QUIZ.UPDATED_AT;
    }

    @Override
    public Field<String> field4() {
        return Quiz.QUIZ.OWNER;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component3() {
        return getUpdatedAt();
    }

    @Override
    public String component4() {
        return getOwner();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value3() {
        return getUpdatedAt();
    }

    @Override
    public String value4() {
        return getOwner();
    }

    @Override
    public QuizRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public QuizRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public QuizRecord value3(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public QuizRecord value4(String value) {
        setOwner(value);
        return this;
    }

    @Override
    public QuizRecord values(Integer value1, LocalDateTime value2, LocalDateTime value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QuizRecord
     */
    public QuizRecord() {
        super(Quiz.QUIZ);
    }

    /**
     * Create a detached, initialised QuizRecord
     */
    public QuizRecord(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String owner) {
        super(Quiz.QUIZ);

        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setOwner(owner);
    }
}
