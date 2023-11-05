package mapper;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.BorrowList;
import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.BorrowListDTO;
import com.taha.booklibrary.repository.DTO.BorrowListResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-05T09:27:29+0330",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BorrowListMapperImpl implements BorrowListMapper {

    @Override
    public BorrowListDTO toDTO(BorrowList borrowList) {
        if ( borrowList == null ) {
            return null;
        }

        BorrowListDTO.BorrowListDTOBuilder borrowListDTO = BorrowListDTO.builder();

        borrowListDTO.id( borrowList.getId() );
        borrowListDTO.book( borrowList.getBook() );
        borrowListDTO.member( borrowList.getMember() );
        borrowListDTO.borrowDate( borrowList.getBorrowDate() );
        borrowListDTO.returnDate( borrowList.getReturnDate() );
        borrowListDTO.dueDate( borrowList.getDueDate() );
        borrowListDTO.description( borrowList.getDescription() );

        return borrowListDTO.build();
    }

    @Override
    public BorrowList toEntity(BorrowListDTO borrowListDTO) {
        if ( borrowListDTO == null ) {
            return null;
        }

        BorrowList.BorrowListBuilder borrowList = BorrowList.builder();

        borrowList.id( borrowListDTO.getId() );
        borrowList.book( borrowListDTO.getBook() );
        borrowList.member( borrowListDTO.getMember() );
        borrowList.borrowDate( borrowListDTO.getBorrowDate() );
        borrowList.returnDate( borrowListDTO.getReturnDate() );
        borrowList.dueDate( borrowListDTO.getDueDate() );
        borrowList.description( borrowListDTO.getDescription() );

        return borrowList.build();
    }

    @Override
    public BorrowListResponseDTO entityToResponse(BorrowList borrowList) {
        if ( borrowList == null ) {
            return null;
        }

        BorrowListResponseDTO.BorrowListResponseDTOBuilder borrowListResponseDTO = BorrowListResponseDTO.builder();

        borrowListResponseDTO.member( borrowListMemberFullName( borrowList ) );
        borrowListResponseDTO.book( borrowListBookName( borrowList ) );
        borrowListResponseDTO.id( borrowList.getId() );
        borrowListResponseDTO.borrowDate( borrowList.getBorrowDate() );
        borrowListResponseDTO.returnDate( borrowList.getReturnDate() );
        borrowListResponseDTO.dueDate( borrowList.getDueDate() );
        borrowListResponseDTO.description( borrowList.getDescription() );

        return borrowListResponseDTO.build();
    }

    private String borrowListMemberFullName(BorrowList borrowList) {
        if ( borrowList == null ) {
            return null;
        }
        Member member = borrowList.getMember();
        if ( member == null ) {
            return null;
        }
        String fullName = member.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private String borrowListBookName(BorrowList borrowList) {
        if ( borrowList == null ) {
            return null;
        }
        Book book = borrowList.getBook();
        if ( book == null ) {
            return null;
        }
        String name = book.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
