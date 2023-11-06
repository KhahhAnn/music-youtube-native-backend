package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import vn.khahhann.musicyoutubebackend.entity.Role;

import java.util.List;

@RepositoryRestResource(path = "role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public List<Role> findByRoleName(String roleName);
}

