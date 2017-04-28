package fr.oodyn.posinterface.services.gestion.positionnement;

import java.util.List;

import javax.ejb.Local;

import fr.oodyn.posinterface.domain.Positionnement;

@Local
public interface PositionnementServicesLocal {
	Boolean addPositionnement(Positionnement positionnement );
	Boolean updatePositionnement(Positionnement positionnement);
	Boolean deletePositionnement(Positionnement positionnement);
	Positionnement findPositionnementById(Integer idPositionnement);
	List<Positionnement>findAllPositionnement();
}
