package com.greenbite.bff.controller;

import com.greenbite.bff.client.InventarioClient;
import com.greenbite.bff.dto.ProductoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bff")
@CrossOrigin(origins = "*") // Permite peticiones desde el localhost:3000 del Frontend
public class BffController {

    private final InventarioClient inventarioClient;

    public BffController(InventarioClient inventarioClient) {
        this.inventarioClient = inventarioClient;
    }

    @GetMapping("/catalogo/buscar")
    public List<ProductoDTO> buscarEnCatalogo(@RequestParam String nombre) {
        // El BFF delega la tarea al cliente que creamos
        return inventarioClient.buscarProducto(nombre);
    }
}