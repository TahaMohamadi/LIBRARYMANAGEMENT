package mapper;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.repository.DTO.BookDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-05T09:27:29+0330",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.id( bookDTO.getId() );
        book.authors( bookDTO.getAuthors() );
        book.publisherFullName( bookDTO.getPublisherFullName() );
        book.count( bookDTO.getCount() );

        return book.build();
    }

    @Override
    public BookDTO toDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO.BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.id( book.getId() );
        bookDTO.authors( book.getAuthors() );
        bookDTO.publisherFullName( book.getPublisherFullName() );
        bookDTO.count( book.getCount() );

        return bookDTO.build();
    }
}
