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
import org.jooq.Row4;
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
import org.vandrade.colloquium.generated.tables.records.LifelineTemplateRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LifelineTemplate extends TableImpl<LifelineTemplateRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>lifeline_template</code>
     */
    public static final LifelineTemplate LIFELINE_TEMPLATE = new LifelineTemplate();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LifelineTemplateRecord> getRecordType() {
        return LifelineTemplateRecord.class;
    }

    /**
     * The column <code>lifeline_template.id</code>.
     */
    public final TableField<LifelineTemplateRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>lifeline_template.created_at</code>.
     */
    public final TableField<LifelineTemplateRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>lifeline_template.updated_at</code>.
     */
    public final TableField<LifelineTemplateRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>lifeline_template.name</code>.
     */
    public final TableField<LifelineTemplateRecord, String> NAME = createField(DSL.name("name"), SQLDataType.CLOB.nullable(false), this, "");

    private LifelineTemplate(Name alias, Table<LifelineTemplateRecord> aliased) {
        this(alias, aliased, null);
    }

    private LifelineTemplate(Name alias, Table<LifelineTemplateRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>lifeline_template</code> table reference
     */
    public LifelineTemplate(String alias) {
        this(DSL.name(alias), LIFELINE_TEMPLATE);
    }

    /**
     * Create an aliased <code>lifeline_template</code> table reference
     */
    public LifelineTemplate(Name alias) {
        this(alias, LIFELINE_TEMPLATE);
    }

    /**
     * Create a <code>lifeline_template</code> table reference
     */
    public LifelineTemplate() {
        this(DSL.name("lifeline_template"), null);
    }

    public <O extends Record> LifelineTemplate(Table<O> child, ForeignKey<O, LifelineTemplateRecord> key) {
        super(child, key, LIFELINE_TEMPLATE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<LifelineTemplateRecord, Integer> getIdentity() {
        return (Identity<LifelineTemplateRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<LifelineTemplateRecord> getPrimaryKey() {
        return Keys.PK_LIFELINE_TEMPLATE;
    }

    @Override
    public List<UniqueKey<LifelineTemplateRecord>> getKeys() {
        return Arrays.<UniqueKey<LifelineTemplateRecord>>asList(Keys.PK_LIFELINE_TEMPLATE);
    }

    @Override
    public LifelineTemplate as(String alias) {
        return new LifelineTemplate(DSL.name(alias), this);
    }

    @Override
    public LifelineTemplate as(Name alias) {
        return new LifelineTemplate(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LifelineTemplate rename(String name) {
        return new LifelineTemplate(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LifelineTemplate rename(Name name) {
        return new LifelineTemplate(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, LocalDateTime, LocalDateTime, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
