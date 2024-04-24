package com.example.ClubNautico.entity;

import java.util.Date;

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
@Table(name="salida")
@Data
@NoArgsConstructor
@Builder
public class Salida 
{
	@Id
	@SequenceGenerator(
		name = "salida_sequence", //nombre para referenciar la secuencia
		sequenceName = "salida_seq", //forma en que se va a crear en la BBDD
		allocationSize = 1 //forma en que se van a tomar los valores para generar IDs (te los "guarda" para que no tengas que hacer una llamada a la BBDD cada vez que quieres uno)
	)
	@GeneratedValue(
			generator = "salida_seq",
			strategy = GenerationType.SEQUENCE //hemos definido la secuencia y esta se aplica para generar el valor
	)
	private Long idSalida;
	private Date fecha;
	private String destino;
	@ManyToOne
	@JoinColumn
	(
			name = "DniPatronSocio",
			referencedColumnName = "personaId"
	)
	
	private Socio patronSocio;
	@ManyToOne
	@JoinColumn
	(
			name = "DniPatronNoSocio",
			referencedColumnName = "personaId"
	)
	
	private NoSocio patronNoSocio;
	public Salida(Long idSalida, Date fecha, String destino, Persona patron) {
		this.idSalida = idSalida;
		this.fecha = fecha;
		this.destino = destino;
		if(patron.isSocio())
		{
			this.patronSocio = (Socio) patron;
		}
		else
		{
			this.patronNoSocio = (NoSocio) patron;			
		}
	}
	
	public Salida(Long idSalida, Date fecha, String destino, Socio socio, NoSocio nosocio)
	{
		this.idSalida = idSalida;
		this.fecha = fecha;
		this.destino = destino;
		if(socio != null)
		{
			this.patronSocio = socio;
		}
		else if(nosocio != null)
		{
			this.patronNoSocio = nosocio;
		}
	}
	
}
