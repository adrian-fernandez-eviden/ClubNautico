package com.example.ClubNautico.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ClubNautico.entity.NoSocio;
import com.example.ClubNautico.entity.Persona;
import com.example.ClubNautico.entity.Salida;
import com.example.ClubNautico.entity.Socio;

@SpringBootTest
class SalidaRepositoryTest 
{
	@Autowired
	SalidaRepository salidaRepository;
	@Autowired
	NoSocioRepository noSocioRepository;
	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	public void saveSalida()
	{
//		Socio patron = Socio.socioBuilder()
//				.DNI("012345678J")
//				.nombre("Patron de la Barca")
//				.isSocio(false)
//				.matricula("A16232")
//				.build();
//		socioRepository.save(patron);
		
		
		
		NoSocio patron = new NoSocio();
		patron.setDNI("00887H");
		patron.setNombre("Rafa Martínez");
		personaRepository.save(patron);
		
		Date fecha = new Date(2024, 4, 20, 10, 18, 0); //Date(int year, int month, int date, int hrs, int min, int sec)
		Salida salida = Salida.builder()
				.fecha(fecha)
				.patronNoSocio(patron)
				.destino("Puerto de Gandía")
				.build();
		
		salidaRepository.save(salida);
		
//		NoSocio patron = NoSocio.builder()
//				.DNI("88664435H")
//				.nombre("Aitor Pérez")
//				.build();
//		noSocioRepository.save(patron);
//		
//		Date fecha = new Date();
//		Salida salida = Salida.builder()
//				.destino("Gandía")
//				.patronNoSocio(patron)
//				.fecha(fecha)
//				.build();
//		salidaRepository.save(salida);
	}
	
	@Test
	void findAllSalidas()
	{
		List<Salida> salidaList = salidaRepository.findAll();
		System.out.println("Salidas list: " + salidaList);
	}
	
	@Test
	void updateDestino()
	{
		salidaRepository.updateDestino("Cádiz", 1L);
	}
	
	@Test
	void deleteSalidaById()
	{
		salidaRepository.deleteById(2L);
	}
}
