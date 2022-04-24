package com.best.projectd.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.best.projectd.model.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.best.projectd.model.Dancer;

@RestController
@RequestMapping("/api/v1/Dancers")
public class DancerRestControllerV1 {

    private List<Dancer> Dancers = Stream.of(
            new Dancer(1L, "Jack", "Jackson", Style.bachata),
            new Dancer(2L, "John", "Johnson", Style.kizomba),
            new Dancer(4L, "Mike", "Milekson", Style.kizomba),
            new Dancer(3L, "Don", "Donin", Style.salsa)).collect(Collectors.toList());

    @GetMapping
    public List<Dancer> getAll() {
        return Dancers;
    }

    @GetMapping("/id/{id}")
    public Dancer getById(@PathVariable Long id) {

        return Dancers.stream().filter(dancer -> dancer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/style/{style}")
    public List<Dancer> getByStyle(@PathVariable String style) {
        return Dancers.stream().filter(dancer -> dancer.getStyle().equals(Style.valueOf(style)))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Dancer create(@RequestBody Dancer dancer) {
        this.Dancers.add(dancer);
        return dancer;
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Long id) {
        this.Dancers.removeIf(dancer -> dancer.getId().equals(id));
    }
}
