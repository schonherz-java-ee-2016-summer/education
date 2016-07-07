package com.schonherz.education.oop.design.principles.clazz.solid.dip.authentication.good;

/**
 * The example low level class, which would provide implementation of
 * authentication by LDAP
 * 
 * @author Janos Pelsoczi
 *
 */
public class LDAPAuthenticator implements Authenticator {

	@Override
	public boolean authenticate(User user) {
		// logic - LDAP
		return true;
	}

}
