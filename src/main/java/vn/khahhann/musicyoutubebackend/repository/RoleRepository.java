package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khahhann.musicyoutubebackend.entity.Role;

@RepositoryRestResource(path = "role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

