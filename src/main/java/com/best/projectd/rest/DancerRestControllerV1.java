package com.best.projectd.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.best.projectd.model.Dancer;

@RestController
@RequestMapping("/api/v1/Dancers")
public class DancerRestControllerV1 {

    private List<Dancer> Dancers = Stream.of(
            new Dancer(1L, "Jack", "Jackson"),
            new Dancer(2L, "John", "Johnson"),
            new Dancer(3L, "Don", "Donin")).collect(Collectors.toList());

    @GetMapping
    public List<Dancer> getAll() {
        return Dancers;
    }

    @GetMapping("/{id}")
    public Dancer getById(@PathVariable Long id) {

        return Dancers.stream().filter(Dancer -> Dancer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Dancer create(@RequestBody Dancer dancer) {
        this.Dancers.add(dancer);
        return dancer;
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Long id){
        this.Dancers.removeIf(dancer -> dancer.getId().equals(id));
    }
}
