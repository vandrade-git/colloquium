/*
 * This file is generated by jOOQ.
 */
package org.vandrade.colloquium.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String        owner;

    public Quiz() {}

    public Quiz(Quiz value) {
        this.id = value.id;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
        this.owner = value.owner;
    }

    public Quiz(
        Integer       id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String        owner
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
    }

    /**
     * Getter for <code>quiz.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>quiz.id</code>.
     */
    public Quiz setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>quiz.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>quiz.created_at</code>.
     */
    public Quiz setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>quiz.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>quiz.updated_at</code>.
     */
    public Quiz setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Getter for <code>quiz.owner</code>.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Setter for <code>quiz.owner</code>.
     */
    public Quiz setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Quiz (");

        sb.append(id);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);
        sb.append(", ").append(owner);

        sb.append(")");
        return sb.toString();
    }
}
