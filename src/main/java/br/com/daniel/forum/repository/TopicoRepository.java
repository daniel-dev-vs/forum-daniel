package br.com.daniel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daniel.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

}
