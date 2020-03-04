package soporte.pac.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soporte.pac.model.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, String>{

}
