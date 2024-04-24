package com.example.ClubNautico.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(
		name="persona", 
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = "DNI") 
				}
		)
public class Persona 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personaId;

	private String DNI;
	private String nombre;
	
	@Column(name = "is_socio")
	private boolean isSocio;

	@OneToMany( 
			mappedBy = "idSalida",
			fetch = FetchType.EAGER 
	)
	private List<Salida> salidas;

	public Persona(String DNI, String nombre, boolean isSocio, List<Salida> salidas) 
	{
		this.DNI = DNI;
		this.nombre = nombre;
		this.isSocio = isSocio;
		this.salidas = salidas;
	}
	public Persona(Long personaId, String DNI, String nombre, boolean isSocio, List<Salida> salidas)
	{
		this.personaId = personaId;
		this.DNI = DNI;
		this.nombre = nombre;
		this.isSocio = isSocio;
		this.salidas = salidas;
	}
}
