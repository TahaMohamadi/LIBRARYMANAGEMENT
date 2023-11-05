package mapper;

import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.MemberDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-05T09:27:29+0330",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO toDTO(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO.MemberDTOBuilder memberDTO = MemberDTO.builder();

        memberDTO.id( member.getId() );
        memberDTO.fullName( member.getFullName() );
        memberDTO.mobileNumber( member.getMobileNumber() );

        return memberDTO.build();
    }

    @Override
    public Member toEntity(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.id( memberDTO.getId() );
        member.fullName( memberDTO.getFullName() );
        member.mobileNumber( memberDTO.getMobileNumber() );

        return member.build();
    }
}
