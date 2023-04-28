package ch.Nzinga.Carlos.TodoList;


import TodoList.user.Member;
import TodoList.user.MemberRepository;
import TodoList.user.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class VehicleServiceTests {

    private MemberService memberService;
    private final MemberRepository memberRepositoryMock = mock(MemberRepository.class);

    private final Member memberMock = mock(Member.class);

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepositoryMock);
    }

    @Test
    void createVehicle() {
        when(memberRepositoryMock.save(memberMock)).thenReturn(memberMock);
       memberService.insertMember(memberMock);
        verify(memberRepositoryMock, times(1)).save(any());
    }

    @Test
    void findVehicle() {
        when(memberRepositoryMock.findById(any())).thenReturn(Optional.ofNullable(memberMock));
        Member v = memberService.getMember(any());
        verify(memberRepositoryMock, times(1)).findById(any());
    }

    @Test
    void deleteVehicle() {
       memberService.deleteMember(any());
        verify(memberRepositoryMock, times(1)).deleteById(any());
    }
}