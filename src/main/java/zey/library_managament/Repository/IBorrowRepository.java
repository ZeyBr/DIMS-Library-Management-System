package zey.library_managament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zey.library_managament.Entity.Borrow;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow, Long> {
}