package com.example.ClubNautico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ClubNautico.entity.Salida;

import jakarta.transaction.Transactional;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long>
{
	//UPDATE
	@Transactional
	@Modifying
	@Query("UPDATE Salida s set s.destino = ?1 where s.idSalida = ?2")
	void updateDestino(String destino, Long idSalida); 
	
	//DELETE
	@Transactional
	@Modifying
	@Query("DELETE from Salida s where s.idSalida = :idSalida")
	void deleteById(@Param("idSalida") Long idSalida);
}
