package com.example.ClubNautico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="barco")
public class Barco 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBarco;
	private int numeroAmarre;
	private double cuota;
	
	@ManyToOne
	@JoinColumn
	(
			name = "PersonaId",
			referencedColumnName = "personaId"
	)
	private Socio socio;
	
	@Override
	public String toString()
	{
		return "Boat id: " + this.idBarco + ", numeroAmarre: " + this.numeroAmarre;
	}
}
