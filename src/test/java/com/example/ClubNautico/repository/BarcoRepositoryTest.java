package com.example.ClubNautico.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ClubNautico.entity.Barco;
import com.example.ClubNautico.entity.NoSocio;
import com.example.ClubNautico.entity.Persona;
import com.example.ClubNautico.entity.Socio;

@SpringBootTest
class BarcoRepositoryTest 
{
	@Autowired
	private BarcoRepository barcoRepository;
	@Autowired
	private SocioRepository socioRepository;
	
	@Test
	public void saveBarco() //guarda un barco en bbdd
	{
//		Socio socio = Socio.builder()
//				.DNI("0866920T")
//				.nombre("Andrés Mata")
//				.matricula("0965TTR")
//				.build();
//		socioRepository.save(socio);
//		Optional<Persona> persona = socioRepository.findByDNI("61231163B");
//		Socio socio = (Socio) persona.get();
//		
//		Barco barco = Barco.builder()
//				.numeroAmarre(32)
//				.cuota(320.0)
//				.socio(socio)
//				.build();
//		barcoRepository.save(barco);
		
		Socio socio = Socio.builder()
				.DNI("098432K")
				.nombre("Santiago Rivera")
				.matricula("5420")
				.build();
		socioRepository.save(socio);
		
		Barco barco = Barco.builder()
				.cuota(100)
				.socio(socio)
				.numeroAmarre(54)
				.build();
		barcoRepository.save(barco);
	}
	
	@Test
	public void findAllBarcos() //encontrar todos los barcos guardados
	{
		List<Barco> barcos = barcoRepository.findAll();
		System.out.println("Barcos list: " + barcos);
	}
	
	@Test
	public void findByCuotaGreaterThan()
	{
		System.out.println("calculando...");
		List<Barco> barcos = barcoRepository.findByCuotaGreaterThan(100);
		System.out.println("Resultado: ");
		System.out.println(barcos.size());
		System.out.println("Lista de barcos 100: " + barcos);
		System.out.println("bye");
	}
	
	@Test
	public void findById()
	{
		Optional<Barco> bOptional = barcoRepository.findById(2L);
		if(bOptional.isPresent())
		{
			Barco barco = bOptional.get();			
			System.out.println("Barco: " + barco);
		}
		else
		{
			System.out.println("no hay ningún barco con ese ID");
		}
	}
	
	@Test
	public void updateNumeroAmarreById()
	{
		barcoRepository.updateNumeroAmarreById(333, 2L); //cambia a 333 el amarre del barco con ID 1
	}
	
	@Test void deleteBarco()
	{
		barcoRepository.deleteById(2L);
	}
}
