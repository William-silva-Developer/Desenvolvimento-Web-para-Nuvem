package com.br.academico.academico.domain.model;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails, Serializable {
	
	
	 	
	  
	
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID cod_usuario;
	  
	 	@Column(nullable = false, unique = true)
	    private String nome;
	 	
	 	@Column(nullable = false)
	 	private String sobre_nome;
	    
	    @Column(nullable = false)
	    private String senha;
	    
	    
	  
	    @ManyToMany
	    @JoinTable(name = "tb_usuario_role",
        joinColumns = @JoinColumn(name = "usuario_cod"),
        inverseJoinColumns = @JoinColumn(name = "role_cod"))
	    private List<Role> roles;



		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return this.roles;
		}



		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return this.senha;
		}



		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return this.nome;
		}



		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}



		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}



		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}



		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}



		public UUID getCod_usuario() {
			return cod_usuario;
		}



		public void setCod_usuario(UUID cod_usuario) {
			this.cod_usuario = cod_usuario;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}

/*

		public String getNome() {
			return nome;
		}

*/

		


/*
		public String getSenha() {
			return senha;
		}

*/

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

					  


}

