/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 * @author Parker W.
 *
 *         Class exists purely for the purposes of ensuring all DAOs include the
 *         CRUD operations. Not strictly needed as won't be involved in any APIs
 *         but it helps make sure no methods get forgotten so we'll keep it.
 *         Doesn't hurt anything really.
 */
@Repository
public abstract class AbstractDAO<T> implements ResultSetExtractor<List<T>> {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Enters the entity into the database and returns any auto-generated keys.
	 * 
	 * @param obj the entity to input into the database.
	 * @return the auto-generated key, null if there is a failure.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract Integer create(T obj) throws SQLException, ClassNotFoundException;

	/**
	 * Enters the object into the database, returning the status of the operation.
	 * Used primarily if the object is not expected to receive any auto-generated
	 * keys.
	 * 
	 * @param obj the object to enter into the database.
	 * @return true if the creation was successful, false otherwise.
	 */
	public abstract boolean createNoKey(T obj) throws SQLException, ClassNotFoundException;

	/**
	 * Takes a unique key and returns the object from the database that matches that
	 * key.
	 * 
	 * @param unique_key the unique key to search the table for.
	 * @return the entity with the unique key, null if it does not exist or on an
	 *         error.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract T read(Object unique_key) throws SQLException, ClassNotFoundException;

	/**
	 * Obtains all the entries in the table and provides them as a List.
	 * 
	 * @return the list of all entries in the table, null in the event of an error.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract List<T> readAll() throws SQLException, ClassNotFoundException;

	/**
	 * Finds the entity in the table that matches the unique modifier of the given
	 * replacement then updates the values to match the given object.
	 * 
	 * @param replacement the object that contains the new values to set.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract void update(T replacement) throws SQLException, ClassNotFoundException;

	/**
	 * Will look for the row in the table that matches any identifiers given in the
	 * target and removes them. Does not need to be a perfect match, will work of
	 * unique keys. If the target is not found the function will terminate without
	 * changing the table.
	 * 
	 * @param target the entry to remove from the table.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract void delete(T target) throws SQLException, ClassNotFoundException;


}
