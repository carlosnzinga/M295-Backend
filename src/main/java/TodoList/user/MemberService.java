package TodoList.user;


import org.springframework.stereotype.Service;

import TodoList.storage.EntityNotFoundException;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> getMembers() {
        return repository.findByOrderByNameAsc();
    }

    public Member getMember(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Member.class));
    }

    public Member insertMember(Member Member) {
        return repository.save(Member);
    }

    public Member updateMember(Member Member, Long id) {
        return repository.findById(id)
                .map(MemberOrig -> {
                    MemberOrig.setName(Member.getName());
                    MemberOrig.setLastname(Member.getLastname());
                    MemberOrig.setAge(Member.getAge());
                    MemberOrig.setAddress(Member.getAddress());
                    MemberOrig.setTodo_Name(Member.getTodo_Name());
                    return repository.save(MemberOrig);
                })
                .orElseGet(() -> repository.save(Member));
    }

    public void deleteMember(Long id) {
        repository.deleteById(id);
    }
}
