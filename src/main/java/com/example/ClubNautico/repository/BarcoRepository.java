package com.example.ClubNautico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ClubNautico.entity.Barco;
import com.example.ClubNautico.entity.Socio;

import jakarta.transaction.Transactional;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Long>
{
	//INSERT se usa la función .save() en la clase de Test, no hace falta definirlo aquí
	
	//SELECT
	Optional<Barco> findById(Long idBarco); //select by del barco con el ID 
	List<Barco> findByCuotaGreaterThan(double cuota); //select by todos los barcos cuya cuota sea mayor al número pasado por parámetro
	
	//UPDATE
	@Transactional
	@Modifying
	@Query("UPDATE Barco b set b.numeroAmarre = ?1 where b.idBarco = ?2")
	void updateNumeroAmarreById(int numero, Long idBarco); // cambiar el número de amarre al barco con el ID que se pasa 
	@Transactional
	@Modifying
	@Query("UPDATE Barco b set b.cuota = ?1 where b.idBarco = ?2")
	void updateCuotaById(double cuota, Long idBarco); // cambiar la cuota al barco con el ID que se pasa 
	
	//DELETE
	@Transactional
	@Modifying
	@Query("DELETE from Barco b where b.idBarco = :idBarco")
	void deleteById(@Param("idBarco") Long idBarco); //borrar socio por matricula
}
