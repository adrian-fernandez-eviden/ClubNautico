package com.example.ClubNautico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ClubNautico.entity.NoSocio;
import com.example.ClubNautico.entity.Persona;

import jakarta.transaction.Transactional;

@Repository
public interface NoSocioRepository extends JpaRepository<NoSocio, Long>
{
	//INSERT se usa la función .save() en la clase de Test, no hace falta definirlo aquí
	
	//SELECT
	Optional<Persona> findByDNI(String DNI); //select by de la persona con el DNI que se le pase
	List<Persona> findByNombreContaining(String substrNombre); //select by de las personas cuyo nombre contenga la cadena pasada
	//List<Socio> findByBarcosNotNull(); //select by todos los socios cuya lista de barcos no esté vacía
	
	//UPDATE
	@Transactional
	@Modifying
	@Query(
			value = "UPDATE persona p set p.nombre = :nombre where p.dni = :dni",
			nativeQuery = true
	)
	void updateNombreByMatricula(@Param("nombre") String nombre, @Param("dni") String DNI);
	//DELETE
	@Transactional
	@Modifying
	@Query(
			value = "DELETE FROM persona p where p.matricula = :matricula",
			nativeQuery = true
	)
	void deleteByMatricula(@Param("matricula") String matricula); //borrar socio por matricula
}
