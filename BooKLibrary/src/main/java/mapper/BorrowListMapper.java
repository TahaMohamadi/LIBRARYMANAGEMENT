package mapper;

import com.taha.booklibrary.entity.BorrowList;
import com.taha.booklibrary.repository.DTO.BorrowListDTO;
import com.taha.booklibrary.repository.DTO.BorrowListResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowListMapper {
    BorrowListMapper INSTANCE = Mappers.getMapper(BorrowListMapper.class);
    BorrowListDTO toDTO(BorrowList borrowList);
    BorrowList toEntity(BorrowListDTO borrowListDTO);
    @Mapping(target = "member" , source = "borrowList.member.fullName")
    @Mapping(target = "book" , source = "borrowList.book.name")
    BorrowListResponseDTO entityToResponse(BorrowList borrowList);


}
