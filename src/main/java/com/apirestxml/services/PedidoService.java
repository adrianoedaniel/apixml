package com.apirestxml.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestxml.entities.Pedido;
import com.apirestxml.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;

		@Autowired
		public PedidoService(PedidoRepository pedidoRepository) {
			this.pedidoRepository = pedidoRepository;
		}
		
		public List<Pedido> buscaTodosPedidos(){
			return pedidoRepository.findAll();
		}
		//Verificar
		public Pedido buscaPedidoId(Long id) {
			Optional <Pedido> existePedido = pedidoRepository.findById(id);
			return existePedido.orElse(null);
		}
		public Pedido salvaPedido(Pedido pedido) {
			return pedidoRepository.save(pedido);		
		}
		public Pedido alterarPedido(Long id, Pedido alterarP) {
			Optional <Pedido> existePedido = pedidoRepository.findById(id);
			if (existePedido.isPresent()) {
				alterarP.setId(id);
				return pedidoRepository.save(alterarP);
			}
			return null;
		}
		public boolean apagarPedido(Long id) {
			Optional <Pedido> existePedido = pedidoRepository.findById(id);
			if (existePedido.isPresent()) {
				pedidoRepository.deleteById(id);
				return true;
			}
			return false;
		}

}
