package com.callor.book.service.impl;

import com.callor.book.model.BookVO;
import com.callor.book.persistence.BookDao;
import com.callor.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImplV1 implements BookService {

    private final BookDao bookDao;

    public BookServiceImplV1(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookVO> selectAll() {

        // 조건에 관계없이 데이터르 모두 Select하기
        List<BookVO> bookList = bookDao.findAll();
        return bookList;
    }

    @Override
    public BookVO findById(String isbn) {
        return null;
    }

    @Override
    public int insert(BookVO bookVO) {
        log.debug("서비스 Insert {}", bookVO);
        /*
        mybatis 에서는 insert 를 수행한 후 int 값을 return 한다
        이때 return 하는 값은 몇개의 데이터가 추가되었는지를 알려주는 지표이다
        
        하지만 Spring-data(JPA) 에서는 Save 를 실행한후
        다시 자기 자신을 (save 를 실행한 데이터)를 return 한다
        
        spring-data 에서는 CRUD에서 INSERT와 Update를 별도로 구분하지 않는다
        save() method에 VO 를 전달하면
        1. 먼저 PK 를 기준으로  데이터를 SELECT 하여 테이블에 데이터가 있는지 검사한다
        2. 만약 테이블에 PK 에 해당하는 데이터가 없으면 INSERT를 수행한다
        3. 또, 테이블에 PK 에 해당하는 데이터가 있으면 UPDATE를 수행한다
         */
        BookVO result = bookDao.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        return 0;
    }

    @Override
    public int delete(BookVO bookVO) {
        return 0;
    }

    @Override
    public List<BookVO> findByTitle(String title) {
        return null;
    }

    @Override
    public List<BookVO> findByComp(String comp) {
        return null;
    }

    @Override
    public List<BookVO> findByAuthor(String author) {
        return null;
    }
}
