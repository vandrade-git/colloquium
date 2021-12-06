/*
 * This file is generated by jOOQ.
 */
package org.vandrade.colloquium.generated.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.vandrade.colloquium.generated.tables.Statistics;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StatisticsRecord extends UpdatableRecordImpl<StatisticsRecord> implements Record5<Integer, LocalDateTime, LocalDateTime, Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>statistics.id</code>.
     */
    public StatisticsRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>statistics.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>statistics.created_at</code>.
     */
    public StatisticsRecord setCreatedAt(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>statistics.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>statistics.updated_at</code>.
     */
    public StatisticsRecord setUpdatedAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>statistics.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>statistics.quiz_id</code>.
     */
    public StatisticsRecord setQuizId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>statistics.quiz_id</code>.
     */
    public Integer getQuizId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>statistics.data</code>.
     */
    public StatisticsRecord setData(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>statistics.data</code>.
     */
    public String getData() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, LocalDateTime, LocalDateTime, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, LocalDateTime, LocalDateTime, Integer, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Statistics.STATISTICS.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Statistics.STATISTICS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Statistics.STATISTICS.UPDATED_AT;
    }

    @Override
    public Field<Integer> field4() {
        return Statistics.STATISTICS.QUIZ_ID;
    }

    @Override
    public Field<String> field5() {
        return Statistics.STATISTICS.DATA;
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
    public Integer component4() {
        return getQuizId();
    }

    @Override
    public String component5() {
        return getData();
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
    public Integer value4() {
        return getQuizId();
    }

    @Override
    public String value5() {
        return getData();
    }

    @Override
    public StatisticsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public StatisticsRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public StatisticsRecord value3(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public StatisticsRecord value4(Integer value) {
        setQuizId(value);
        return this;
    }

    @Override
    public StatisticsRecord value5(String value) {
        setData(value);
        return this;
    }

    @Override
    public StatisticsRecord values(Integer value1, LocalDateTime value2, LocalDateTime value3, Integer value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StatisticsRecord
     */
    public StatisticsRecord() {
        super(Statistics.STATISTICS);
    }

    /**
     * Create a detached, initialised StatisticsRecord
     */
    public StatisticsRecord(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, Integer quizId, String data) {
        super(Statistics.STATISTICS);

        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setQuizId(quizId);
        setData(data);
    }
}