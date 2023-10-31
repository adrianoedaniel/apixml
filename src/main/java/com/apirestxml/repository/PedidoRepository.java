package com.apirestxml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestxml.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
