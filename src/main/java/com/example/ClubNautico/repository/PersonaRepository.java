package com.example.ClubNautico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ClubNautico.entity.Barco;
import com.example.ClubNautico.entity.Persona;

import jakarta.transaction.Transactional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>
{
	//INSERT se usa la función .save() en la clase de Test, no hace falta definirlo aquí
	
	//SELECT
	
	
	//UPDATE
	@Transactional
	@Modifying
	@Query(
			value = "UPDATE persona p set p.nombre = :nombre where p.dni = :dni",
			nativeQuery = true
	)
	void updateNombreByDNI(@Param("nombre") String nombre, @Param("dni") String DNI); //cambiar el nombre por el que se pasa en la persona con el DNI que se pasa
	
	//DELETE
	
	  @Transactional
	  @Modifying
	  @Query(
				value = "DELETE FROM persona p where p.DNI = :DNI",
				nativeQuery = true
		)
	  void deleteByDNI(@Param("DNI") String DNI); //borrar la persona con el DNI que se  pasa
	 	
	  @Transactional
	  @Modifying
	  @Query(
				value = "DELETE FROM persona p where p.nombre = :nombre",
				nativeQuery = true
		)
	  void deleteByNombre(@Param("nombre") String nombre); //borrar persona(s) por  nombre
	 	
}
