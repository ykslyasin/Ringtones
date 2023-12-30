package com.example.Ringtones.entities.concretes;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ringtones")
@AllArgsConstructor
@NoArgsConstructor
public class Ringtone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int ringtoneId;
	
	@NotNull
	@NotBlank
	@Column(name="name")
	private String ringtoneName;

	@NotNull
	@NotBlank
	@Column(name="length")
	private String ringtoneLength;
	
	@ManyToOne
    @JoinColumn(name="category_id")
    private Categories ringtoneCategory;
	
	@NotNull
	@NotBlank
	@Column(name="format_type")
	private String ringtoneFormat;
	
	@NotNull
	@NotBlank
	@Column(name="price")
	private double ringtonePrice;
	
	@NotNull
	@NotBlank
	@Column(name="ringtone_path")
	private String ringtonePath;
	
}
