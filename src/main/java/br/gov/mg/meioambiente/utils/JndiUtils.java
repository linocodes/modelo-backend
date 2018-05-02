package br.gov.mg.meioambiente.utils;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiUtils implements Serializable {

	private static final long serialVersionUID = 8880994773856478201L;

	public static String getValorJndi(String chave) throws NamingException {
		ResourceBundle bundle = ResourceBundle.getBundle("jndi-names");
		return InitialContext.doLookup(bundle.getString(chave));
	}

}
