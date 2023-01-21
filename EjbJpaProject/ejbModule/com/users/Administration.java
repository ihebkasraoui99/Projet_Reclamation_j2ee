package com.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;




@Entity
@DiscriminatorValue("admin")// le discriminitateur pour identifier l'admin dans la table utilisateur
public class Administration extends Utilisateur{
	
	
			
	public Administration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administration(String email,String password, boolean active) {
		super(email,password,active);
		
	}


}
