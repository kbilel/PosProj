package fr.oodyn.posinterface.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Postionnement
 *
 */
@Entity
@Table(name="t_positionnement")
public class Positionnement implements Serializable {

	
	private Integer id;
	private String nom;
	private String prenom;
	private String partenaireClient;
	private String information;
	private String informationPerConcerne;
	private String contenueTech;
	private String zoneG;
	private Integer tjm;
	private String statut;
	private String commentaire;
	private String dateInsertion;
	private String commercialeConcerne;
	private static final long serialVersionUID = 1L;

	public Positionnement() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getPartenaireClient() {
		return this.partenaireClient;
	}

	public void setPartenaireClient(String partenaireClient) {
		this.partenaireClient = partenaireClient;
	}   
	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}   
	public String getInformationPerConcerne() {
		return this.informationPerConcerne;
	}

	public void setInformationPerConcerne(String informationPerConcerne) {
		this.informationPerConcerne = informationPerConcerne;
	}   
	public String getContenueTech() {
		return this.contenueTech;
	}

	public void setContenueTech(String contenueTech) {
		this.contenueTech = contenueTech;
	}   
	public String getZoneG() {
		return this.zoneG;
	}

	public void setZoneG(String zoneG) {
		this.zoneG = zoneG;
	}   
	public Integer getTjm() {
		return this.tjm;
	}

	public void setTjm(Integer tjm) {
		this.tjm = tjm;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}   
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}   
	public String getDateInsertion() {
		return this.dateInsertion;
	}

	public void setDateInsertion(String dateInsertion) {
		this.dateInsertion = dateInsertion;
	}   
	public String getCommercialeConcerne() {
		return this.commercialeConcerne;
	}

	public void setCommercialeConcerne(String commercialeConcerne) {
		this.commercialeConcerne = commercialeConcerne;
	}
   
}
