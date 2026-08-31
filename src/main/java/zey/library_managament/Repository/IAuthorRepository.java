package zey.library_managament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zey.library_managament.Entity.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {
}