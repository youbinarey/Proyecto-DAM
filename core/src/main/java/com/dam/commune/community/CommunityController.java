package com.dam.commune.community;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public ResponseEntity <List<Community>> getAll() {
        return ResponseEntity.ok(communityService.findAll());
    }

     @GetMapping("/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        return communityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Community> create(@RequestBody Community community) {
        return ResponseEntity.ok(communityService.save(community));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Community> update(@PathVariable Long id, @RequestBody Community updated) {
        return communityService.findById(id)
                .map(existing -> {
                    updated.setId(existing.getId());
                    return ResponseEntity.ok(communityService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
            if (!communityService.deleteIfExists(id)) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();    
    }
   

}
