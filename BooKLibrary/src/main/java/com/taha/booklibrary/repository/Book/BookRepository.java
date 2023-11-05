package com.taha.booklibrary.repository.Book;

import com.taha.booklibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    @Query("update Book b set b.Name = ?1, b.authors = ?2, b.publisherFullName = ?3, b.count = ?4 where b.id = ?5")
    int updateNameAndAuthorsAndPublisherFullNameAndCountById(String Name, String authors, String publisherFullName, int count, Long id);

    @Override
    void deleteById(Long aLong);
}
