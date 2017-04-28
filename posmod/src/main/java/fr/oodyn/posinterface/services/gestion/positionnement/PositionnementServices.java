package fr.oodyn.posinterface.services.gestion.positionnement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.oodyn.posinterface.domain.Positionnement;


/**
 * Session Bean implementation class PositionnementServices
 */
@Stateless
public class PositionnementServices implements PositionnementServicesRemote, PositionnementServicesLocal {

	@PersistenceContext(unitName="posmod")
	EntityManager entityManager;
	
	
    public PositionnementServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addPositionnement(Positionnement positionnement) {
		System.out.println("enter addPositionnement sessionBean");
		try {
			entityManager.persist(positionnement);
			System.out.println("ok ejb positionnement added");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updatePositionnement(Positionnement positionnement) {
		try {
			entityManager.merge(positionnement);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update user");
			return false;
		}
	}

	@Override
	public Boolean deletePositionnement(Positionnement positionnement) {
try {
			
			
			entityManager.remove(entityManager.merge(positionnement));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Positionnement findPositionnementById(Integer idPositionnement) {
		Positionnement positionnement=null;
		try {
			positionnement=entityManager.find(Positionnement.class, idPositionnement);
		
		} catch (Exception e) {
			
		}
		return  positionnement;
	}

	@Override
	public List<Positionnement> findAllPositionnement() {
		System.out.println("enter findallPositionnement  sessionBean");
		Query query=entityManager.createQuery("select p from Positionnement p ");
		return query.getResultList();
	}

}
