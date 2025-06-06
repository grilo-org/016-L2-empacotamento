package com.empacotamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empacotamento.model.pedido.entrada.PedidosEntradaWrapper;
import com.empacotamento.model.pedido.saida.PedidosSaidaWrapper;
import com.empacotamento.service.ProcessarPedidosEntrada;

import jakarta.validation.Valid;

@RestController
public class EmpacotamentoController implements EmpacotamentoApi {

	public ResponseEntity<?> receberPedidos(@RequestBody @Valid PedidosEntradaWrapper pedidosWrapper) {

		PedidosSaidaWrapper pedidosSaidaWrapper = new ProcessarPedidosEntrada().processar(pedidosWrapper);

		return ResponseEntity.ok(pedidosSaidaWrapper);
	}

}
