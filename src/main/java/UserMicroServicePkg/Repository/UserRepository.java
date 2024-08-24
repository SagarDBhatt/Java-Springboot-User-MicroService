package UserMicroServicePkg.Repository;

import UserMicroServicePkg.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Transactional
    @Query(value = "Select * From usermicroservice where userid=?1", nativeQuery = true)
    Optional<User> findUserByUserId(UUID userId);
}
