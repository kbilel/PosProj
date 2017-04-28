package fr.oodyn.posinterface.services.gestion.positionnement;

import java.util.List;

import javax.ejb.Remote;

import fr.oodyn.posinterface.domain.Positionnement;



@Remote
public interface PositionnementServicesRemote {
	
	Boolean addPositionnement(Positionnement positionnement );
	Boolean updatePositionnement(Positionnement positionnement);
	Boolean deletePositionnement(Positionnement positionnement);
	Positionnement findPositionnementById(Integer idPositionnement);
	List<Positionnement>findAllPositionnement();
//	User findUserByUsername(String name);
//	User authentificate(String login,String pwd);
//	Boolean exist(String login);
//	Boolean existEmail(String email);
//	List<User> findParticipateOrNot(String participate);//retourn elite user by gender
//	
//	Integer    findNumberUserByStation(String station);  //ok
//	Integer    findNumberUserByGender(String gender);    //ok
//	Integer    findNumberUserByAge(Integer age);           //ok
//	Integer    findNumberUserByUserType(String userType); //ok
//	Integer     findNumberUserByAgeRange(Integer starAge,Integer endAge);
//	Integer     CalculateNumberNotif(User user);
//	
//	
//	
//	Integer findUserByLevel(String age);  //byage
//	List<User> findUsersByStation(String station);

}
