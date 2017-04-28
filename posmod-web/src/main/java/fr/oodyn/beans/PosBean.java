package fr.oodyn.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import fr.oodyn.posinterface.domain.Positionnement;
import fr.oodyn.posinterface.services.gestion.positionnement.PositionnementServicesLocal;



@ManagedBean
@ViewScoped
public class PosBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	PositionnementServicesLocal local;
	Boolean form;

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
	
	private String datfeed;
	

	private String commercialeConcerne;
	
	private Positionnement protoPositionnement;
	private List<Positionnement> PositionnementsFiltred;
	private List<Positionnement> Positionnements=new ArrayList<Positionnement>();
	private Positionnement Positionnement=new Positionnement();
	
	


	
	@PostConstruct
	public void init() {
		System.out.println("enter initi");
		form=true;
		Positionnements = local.findAllPositionnement();


	}
	
	
	
	public String doUpdate(){
		local.updatePositionnement(Positionnement);
		return null;
	}
	
	public String doAddPositionnement(){
		System.out.println("enter doAddPositionnement Method from csBean");
		protoPositionnement=new Positionnement();
		System.out.println("after positionnement instanciation  csBean" +protoPositionnement.getPartenaireClient());
		protoPositionnement.setNom(nom);
		protoPositionnement.setPartenaireClient(partenaireClient);
		protoPositionnement.setInformation(information);
		protoPositionnement.setInformationPerConcerne(informationPerConcerne);
		protoPositionnement.setContenueTech(contenueTech);
		protoPositionnement.setZoneG(zoneG);
		protoPositionnement.setTjm(tjm);
		protoPositionnement.setStatut(statut);
		protoPositionnement.setCommentaire(commentaire);
		
		
	    protoPositionnement.setDateInsertion(datfeed);
		
	  
	   System.out.println("hanidatefeed"+datfeed);
		
		protoPositionnement.setCommercialeConcerne(commercialeConcerne);
		
		protoPositionnement.setCommentaire(commentaire);
		
		
		if(local.addPositionnement(protoPositionnement))
		{
			System.out.println("positionnement added");
			init();
		}
		else {
			System.out.println(" else , positionnement not added");
		}
		init();
		
		
		return "posview?faces-redirect=true";
		
	}
	public String doDeletePositionnement(Positionnement Order){
		System.out.println("entre dodeletpositionnement bus");
		local.deletePositionnement(Order);
		init();
		return "posview?faces-redirect=true";
	}
	

	public Positionnement getProtoPositionnement() {
		return protoPositionnement;
	}
	public void setProtoPositionnement(Positionnement protoPositionnement) {
		this.protoPositionnement = protoPositionnement;
	}
//Date
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
	
	
//End Date 
//Getter  Setter
		public Boolean getForm() {
			return form;
		}
		public void setForm(Boolean form) {
			this.form = form;
		}
		
		public List<Positionnement> getPositionnements() {
			return Positionnements;
		}
		public void setPositionnements(List<Positionnement> positionnements) {
			Positionnements = positionnements;
		}
		public Positionnement getPositionnement() {
			return Positionnement;
		}
		public void setPositionnement(Positionnement positionnement) {
			Positionnement = positionnement;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public List<Positionnement> getPositionnementsFiltred() {
			return PositionnementsFiltred;
		}
		public void setPositionnementsFiltred(List<Positionnement> positionnementsFiltred) {
			PositionnementsFiltred = positionnementsFiltred;
		}





		public Integer getId() {
			return id;
		}





		public void setId(Integer id) {
			this.id = id;
		}





		public String getNom() {
			return nom;
		}





		public void setNom(String nom) {
			this.nom = nom;
		}





		public String getPrenom() {
			return prenom;
		}





		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}





		public String getPartenaireClient() {
			return partenaireClient;
		}





		public void setPartenaireClient(String partenaireClient) {
			this.partenaireClient = partenaireClient;
		}





		public String getInformation() {
			return information;
		}





		public void setInformation(String information) {
			this.information = information;
		}





		public String getInformationPerConcerne() {
			return informationPerConcerne;
		}





		public void setInformationPerConcerne(String informationPerConcerne) {
			this.informationPerConcerne = informationPerConcerne;
		}





		public String getContenueTech() {
			return contenueTech;
		}





		public void setContenueTech(String contenueTech) {
			this.contenueTech = contenueTech;
		}





		public String getZoneG() {
			return zoneG;
		}





		public void setZoneG(String zoneG) {
			this.zoneG = zoneG;
		}





		public Integer getTjm() {
			return tjm;
		}





		public void setTjm(Integer tjm) {
			this.tjm = tjm;
		}





		public String getStatut() {
			return statut;
		}





		public void setStatut(String statut) {
			this.statut = statut;
		}





		public String getCommentaire() {
			return commentaire;
		}





		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}





		


		public String getCommercialeConcerne() {
			return commercialeConcerne;
		}





		public void setCommercialeConcerne(String commercialeConcerne) {
			this.commercialeConcerne = commercialeConcerne;
		}





	



		public String getDatfeed() {
			return datfeed;
		}





		public void setDatfeed(String datfeed) {
			this.datfeed = datfeed;
		}








		
	
	
	

}
