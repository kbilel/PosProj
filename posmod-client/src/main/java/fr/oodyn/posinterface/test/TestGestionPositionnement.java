package fr.oodyn.posinterface.test;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.oodyn.posinterface.domain.Positionnement;
import fr.oodyn.posinterface.domain.Positionnement;
import fr.oodyn.posinterface.services.gestion.positionnement.PositionnementServicesRemote;









public class TestGestionPositionnement {
	static PositionnementServicesRemote remote;
	
	
	public static void doAddPositionnement(PositionnementServicesRemote remote){

		Positionnement positionnement=new Positionnement();
		positionnement.setCommentaire("ksskd");
		positionnement.setNom("greg");

		

			if(remote.addPositionnement(positionnement)){
				System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");
		
	}
	public static void doUpdatePositionnement(PositionnementServicesRemote remote){

		Positionnement positionnement=remote.findPositionnementById(38);
		positionnement.setCommentaire("updt");
		if(remote.updatePositionnement(positionnement)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	
	public static void doFindPositionnementById(PositionnementServicesRemote remote){

		Positionnement positionnement=remote.findPositionnementById(6);
		System.out.println("positionnement found by id is up :"+ positionnement);
	
		

	}
	public static void doDeletePositionnement(PositionnementServicesRemote remote){

		Positionnement positionnement=remote.findPositionnementById(37);
		if (positionnement ==null)
System.out.println("positionnement null");
		if(remote.deletePositionnement(positionnement)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...delete");

	}
	

	
	
	public static void doFindAllPositionnement(PositionnementServicesRemote remote){
		List<Positionnement> positionnements=remote.findAllPositionnement();
		
System.out.println("before le if ");
		if(positionnements!=null){
			System.out.println("OK find"+positionnements);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(PositionnementServicesRemote) context.lookup("posmod/PositionnementServices!fr.oodyn.posinterface.services.gestion.positionnement.PositionnementServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
		
	    //doAddPositionnement(remote);	
		doUpdatePositionnement(remote);
		doFindAllPositionnement(remote);
		//dofindPositionnementById(remote);
	//dofindParticipateOrNot(remote);
//doFindAllPositionnement(remote);
	
	//doUpdatePositionnement(remote);
	//doDeletePositionnement(remote);
	//doAuthentifPositionnement(remote);
	
	//doCalculateNotif(remote);
	//doFindNumberpositionnementByStation(remote);
	//doFindNumberpositionnementByGender(remote);
	//doFindNumberpositionnementByAge(remote);
	//doFindNumberpositionnementByPositionnementType(remote);
	}
}
