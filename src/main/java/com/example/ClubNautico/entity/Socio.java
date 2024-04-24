package com.example.ClubNautico.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
public class Socio extends Persona 
{
	private String matricula;
	private boolean isSocio = true;
	
	@OneToMany(
			fetch = FetchType.EAGER,
			mappedBy = "socio",
			cascade = CascadeType.ALL
	)
	private List<Barco> barcos;

	public Socio(String DNI, String nombre, boolean isSocio, List<Salida> salidas) 
	{
		super(DNI, nombre, isSocio, salidas);
	}
	@Builder
	public Socio(String DNI, String nombre, boolean isSocio, String matricula, List<Barco> barcos, List<Salida> salidas)
	{
		super(DNI, nombre, isSocio, salidas);
		this.barcos = barcos;
		this.matricula = matricula;
	}
	@Override
	public String toString()
	{
		return "Socio(DNI=" + this.getDNI() + ", nombre=" + this.getNombre() + ", isSocio=" + this.isSocio() +", matricula="+ this.getMatricula() + ", barcos=" + this.getBarcos() + ", salidas=" + this.getSalidas();
	}
}
