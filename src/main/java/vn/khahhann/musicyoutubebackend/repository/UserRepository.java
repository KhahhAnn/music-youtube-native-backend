package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import vn.khahhann.musicyoutubebackend.entity.User;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    public boolean existsByEmail(String email);

    public User findByEmailAndPassword(String email, String password);

}

