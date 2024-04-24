package com.example.ClubNautico.entity;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoSocio extends Persona
{
	private boolean isSocio = false;
	
	@Builder
	public NoSocio(String DNI, String nombre, boolean isSocio, String matricula, List<Salida> salidas)
	{
		super(DNI, nombre, isSocio, salidas);
	}
}
