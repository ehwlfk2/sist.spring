package sample.book;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service //이 주석은 @Component의 전문화 역할을 하여 구현 클래스가 클래스 경로 검색을 통해 자동으로 검색되도록 합니다.
public class BookService {
	
	private BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;		
	}

}
