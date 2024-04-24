package com.example.ClubNautico.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ClubNautico.entity.Persona;
import com.example.ClubNautico.entity.Socio;

@SpringBootTest
class SocioRepositoryTest
{
	@Autowired
	private SocioRepository socioRepository;
	
	@Test
	public void saveSocio()
	{
		//Socio socio = new Socio("61231163B", "Delia Khan", true, "6h32", null, null);
		Socio socio = new Socio("5070888J", "César López", true, "89PL", null, null);
//		Socio socio = Socio.builder()
//				.isSocio(true)
//				.DNI("50809334J")
//				.nombre("Cesar Lopez")
//				.matricula("699J")
//				.build();
		System.out.println("socio: " + socio);
		socioRepository.save(socio);
	}
	@Test
	public void findAllSocios()
	{
		List<Socio> socioList = socioRepository.findAll();
		System.out.println("Members list: " + socioList);
	}
	
	@Test
	public void findByNombreContaining()
	{
		List<Persona> socios = socioRepository.findByNombreContaining("ez");
		System.out.println("Socios containing 'ez': " + socios);
	}
	
	@Test
	public void deleteSocioById()
	{
		socioRepository.deleteById(2L);
	}
	
	@Test void deleteSocioByMatricula()
	{
		socioRepository.deleteByMatricula("89PL");
	}
}
