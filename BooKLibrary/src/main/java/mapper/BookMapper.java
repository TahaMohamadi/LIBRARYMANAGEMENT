package mapper;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.repository.DTO.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    Book toEntity(BookDTO bookDTO);
    BookDTO toDTO(Book book);
}
