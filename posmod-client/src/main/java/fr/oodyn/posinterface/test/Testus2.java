package fr.oodyn.posinterface.test;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.oodyn.posinterface.domain.User;
import fr.oodyn.posinterface.services.gestion.user.UserServicesLocal;
import fr.oodyn.posinterface.services.gestion.user.UserServicesRemote;

public class Testus2 {
	static UserServicesRemote remote;
	
	
	public static void main(String[] args) {
		try {
			Context context=new InitialContext();
			remote=(UserServicesRemote) context.lookup("posmod/UserServices!fr.oodyn.posinterface.services.gestion.user.UserServicesRemote");
			System.out.println("good");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	}

}
