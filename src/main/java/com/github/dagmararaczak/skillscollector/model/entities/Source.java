package com.github.dagmararaczak.skillscollector.model.entities;



import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "knownSources")

public class Source {


    @ManyToMany
            @JoinTable(name = "sources_attached_skills", joinColumns = @JoinColumn(name = "source_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
      Set<Skill> attachedSkills = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(unique = true,nullable = false)
    private String name;


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Skill> getAttachedSkills() {
        return attachedSkills;
    }

    public void setAttachedSkills(Set<Skill> attachedSkills) {
        this.attachedSkills = attachedSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(id, source.id) &&
                Objects.equals(description, source.description) &&
                Objects.equals(name, source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, name);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
