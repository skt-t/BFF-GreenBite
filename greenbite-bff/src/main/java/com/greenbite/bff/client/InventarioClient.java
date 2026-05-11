package com.greenbite.bff.client;

import com.greenbite.bff.dto.ProductoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class InventarioClient {

    // Instanciamos el cliente HTTP
    private final RestTemplate restTemplate = new RestTemplate();
    
    // La URL de tu microservicio que ya está corriendo
    private final String INVENTARIO_URL = "http://localhost:8081/api/productos";

    public List<ProductoDTO> buscarProducto(String nombre) {
        // Armamos la URL exacta: http://localhost:8081/api/productos/buscar?nombre=tomate
        String url = INVENTARIO_URL + "/buscar?nombre=" + nombre;
        
        // Hacemos la petición GET y mapeamos la respuesta al DTO
        ProductoDTO[] respuesta = restTemplate.getForObject(url, ProductoDTO[].class);
        
        return Arrays.asList(respuesta);
    }
}