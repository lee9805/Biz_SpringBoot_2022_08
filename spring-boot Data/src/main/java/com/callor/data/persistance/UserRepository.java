package com.callor.data.persistance;
/*
 자동 import 하기
 빨간색으로 나타는 클래스, method 에 커서를 두고 ALT+ ENter
 import 최적화 : Ctrl + Alt + O(영문자 오)
*/
import com.callor.data.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Spring-data(JPA) 에서는 JpaRepository 를 Generic 방식으로
상속받아 사용
*/
public interface UserRepository extends JpaRepository<UserVO, Long> {

    // Ctrl + o


}
