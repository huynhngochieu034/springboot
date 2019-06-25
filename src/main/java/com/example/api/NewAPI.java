package com.example.api;

import com.example.dto.NewDTO;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/api/news" })
public class NewAPI {

    @Autowired
    private INewService newService;

    @GetMapping(produces = "application/json")
    public List<NewDTO> firstPage() {
            return newService.findAll();
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public NewDTO get(@PathVariable("id") long id) {
        return newService.findById(id);
    }

    @PostMapping
    public ResponseEntity<NewDTO> createNew(@RequestBody NewDTO newDTO) {
        return ResponseEntity.ok(newService.insert(newDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewDTO> updateNew(@RequestBody NewDTO newDTO, @PathVariable("id") long id) {
        return ResponseEntity.ok(newService.update(newDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNew(@RequestBody long[] ids) {
        if (ids.length > 0)
            newService.deleteNew(ids);
        return ResponseEntity.noContent().build();
    }
}
