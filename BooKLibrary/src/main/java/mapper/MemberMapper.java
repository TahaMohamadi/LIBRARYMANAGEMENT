package mapper;

import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);
    MemberDTO toDTO(Member member);
    Member toEntity(MemberDTO memberDTO);
}
