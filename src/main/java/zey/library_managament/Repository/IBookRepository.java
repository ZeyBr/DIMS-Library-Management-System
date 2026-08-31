package zey.library_managament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zey.library_managament.Entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}