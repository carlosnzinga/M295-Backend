package ch.Nzinga.Carlos.TodoList;
import TodoList.user.Member;
import TodoList.user.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class DBTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insertMember() {

        Member obj1 = this.memberRepository.save(new Member("carlos", "nzinga", 19, "Test", "MZZ"));
        Assertions.assertNotNull(obj1.getTodo_Name());
        Member obj2 = this.memberRepository.save(new Member("carlos", "nzinga", 19, "Test","MZZ"));
        Assertions.assertNotNull(obj2.getTodo_Name());
    }
}
