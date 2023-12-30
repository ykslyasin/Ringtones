package com.example.Ringtones.entities.concretes;

import java.util.List;


import com.example.Ringtones.core.entities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int shoppingCartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usr_id")
	private User user;
	
	@NotNull
	@NotBlank
	@Column(name="cartContents")
	private List<Integer> cartContents;
	
}
