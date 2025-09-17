package tenzor.soft.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tenzor.soft.test.entity.Project;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {

    Page<Project> findAll(Pageable pageable);

}
