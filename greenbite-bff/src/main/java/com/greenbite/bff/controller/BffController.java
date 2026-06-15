package com.greenbite.bff.controller;

import com.greenbite.bff.client.InventarioClient;
import com.greenbite.bff.client.AuthClient;
import com.greenbite.bff.dto.ProductoDTO;
import com.greenbite.bff.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bff")
@CrossOrigin(origins = "*")
public class BffController {

    private final InventarioClient inventarioClient;
    private final AuthClient authClient;

    public BffController(InventarioClient inventarioClient, AuthClient authClient) {
        this.inventarioClient = inventarioClient;
        this.authClient = authClient;
    }

    @GetMapping("/catalogo/buscar")
    public List<ProductoDTO> buscarEnCatalogo(@RequestParam String nombre) {
        return inventarioClient.buscarProducto(nombre);
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestBody UsuarioDTO usuarioDto) {
        return authClient.registrar(usuarioDto);
    }

    @PostMapping("/login")
    public String loginUsuario(@RequestParam String email, @RequestParam String password) {
        return authClient.login(email, password);
    }
}