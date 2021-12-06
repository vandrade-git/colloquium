package org.vandrade.colloquium.repository

import org.jooq.lambda.tuple.Tuple
import org.springframework.transaction.annotation.Transactional

/**
 * Author: Vitor Andrade
 * Date: 12/3/21
 * Time: 12:41 PM
 */

interface IRepository<E, in ID, F> where F : Tuple {
    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be null.
     * @return the entity with the given id or null if none found
     */
    @Transactional(readOnly = true)
    fun findOne(id: ID): E?

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    @Transactional(readOnly = true)
    fun findAll(): Collection<E>

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids
     * @return
     */
    @Transactional(readOnly = true)
    fun findAll(ids: Collection<ID>): Collection<E>

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have
     * changed the entity instance completely.
     *
     * @param entity
     * @return the saved entity
     */
    @Transactional
    fun save(entity: E): E

    /**
     * Saves all given entities.
     *
     * @param entities
     * @return the saved entities
     */
    @Transactional
    fun save(entities: Collection<E>): Collection<E>

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be null.
     * @return true if an entity with the given id exists, false otherwise
     */
    @Transactional(readOnly = true)
    fun exists(id: ID): Boolean

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    @Transactional(readOnly = true)
    fun count(): Long

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be null.
     */
    @Transactional
    fun delete(id: ID): Int

    /**
     * Deletes the given entities.
     *
     * @param entities
     */
    @Transactional
    fun delete(entities: Collection<E>)
}