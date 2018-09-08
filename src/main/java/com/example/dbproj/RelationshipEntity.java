package com.example.dbproj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relationship")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RelationshipEntity {

    @Id
    Long id;
    Long child;
    Long parent;

    public interface Repo extends JpaRepository<RelationshipEntity, Long> {

    }
}
