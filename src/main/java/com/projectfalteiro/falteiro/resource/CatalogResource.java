package com.projectfalteiro.falteiro.resource;

import com.projectfalteiro.falteiro.entities.Catalog;
import com.projectfalteiro.falteiro.entities.Product;
import com.projectfalteiro.falteiro.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CatalogResource {

    @Autowired
    private CatalogService service;

    @GetMapping
    public ResponseEntity<List<Catalog>> findAll(){
        List<Catalog> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Catalog> findById(@PathVariable String id){
        Catalog obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Catalog> insert(@RequestBody Catalog obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
