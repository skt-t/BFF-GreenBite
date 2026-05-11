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

    public List<ProductoDTO> obtenerCatalogoCompleto() {
        // Llama a http://localhost:8081/api/productos para traer todo el arreglo
        ProductoDTO[] respuesta = restTemplate.getForObject(INVENTARIO_URL, ProductoDTO[].class);
        return Arrays.asList(respuesta);
    }
}