/**
 * 
 */
package com.ss.sbank.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.ss.sbank.de.cards.Card;

/**
 * @author Parker W.
 *
 */
public class IDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		System.out.println("Generate id for object: " + object);
		/*
		 * This might not be the best approach, but it works. Id is created by the
		 * service using the account number and does all the logic by the time this is
		 * called, so just return the id that's already been made. This really just
		 * ensures that the id is not overwritten with a number that is not wanted.
		 */
		return ((Card) object).getId();
	}

}
