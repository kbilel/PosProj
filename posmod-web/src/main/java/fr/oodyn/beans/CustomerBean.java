package fr.oodyn.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.oodyn.posinterface.domain.User;
import fr.oodyn.posinterface.services.gestion.user.UserServicesLocal;


@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UserServicesLocal local;
	Boolean form;
	private User protoUser;
	private List<User> UsersFiltred;
	
	private List<User> Users=new ArrayList<User>();
	private User User=new User();
	
	
	public Boolean getForm() {
		return form;
	}
	public void setForm(Boolean form) {
		this.form = form;
	}
	
	public List<User> getUsers() {
		return Users;
	}
	public void setUsers(List<User> users) {
		Users = users;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<User> getUsersFiltred() {
		return UsersFiltred;
	}
	public void setUsersFiltred(List<User> usersFiltred) {
		UsersFiltred = usersFiltred;
	}
	
	
	@PostConstruct
	public void init(){
		User protoUser =new User();
		protoUser.setId(666);
         protoUser.setAdress("mer");
         local.addUser(protoUser);
		form=true;
		Users=local.findAllUsers();
		
	}
	
	public String doUpdate(){
		local.updateUser(User);
		return null;
	}
	
	public String doAddUser(){
		System.out.println("enter doAddUser Method");
		
		protoUser.setAdress("Paris 14");
		protoUser.setAge(80);
		protoUser.setFullName("Jack");
		local.addUser(protoUser);
		return "userTemp?faces-redirect=true";
		
	}
	public String doDeleteUser(User Order){
		System.out.println("entre dodeletuser bus");
		local.deleteUser(Order);
		init();
		return null;
	}
	
	public String initialiser(){
		
		User =new User();
		return null;
	}
	public User getProtoUser() {
		return protoUser;
	}
	public void setProtoUser(User protoUser) {
		this.protoUser = protoUser;
	}


	
	
	

}
