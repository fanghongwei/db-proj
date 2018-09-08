package com.example.dbproj;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MyService {
    RelationshipEntity.Repo repo;

    public List<Long> getChildren() {

        List<RelationshipEntity> allEntities = repo.findAll();

        for (RelationshipEntity e: allEntities) {
            if (e.parent == null) {
                System.out.println(e.child + " " + null);
            } else {
                System.out.println(e.child + " " + findRoot(allEntities, e.child));
            }
        }

        return allEntities.stream().map(RelationshipEntity::getChild).collect(Collectors.toList());
    }

    private Long findRoot(List<RelationshipEntity> allEntities, Long child) {
        Long parent = allEntities.stream().filter(e -> e.child.equals(child))
                .findFirst()
                .orElse(RelationshipEntity.builder().build())
                .getParent();
        if (parent == null) {
            return child;
        } else {
            return findRoot(allEntities, parent);
        }
    }
}
