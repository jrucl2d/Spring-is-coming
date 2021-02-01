package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 다형성에 의해서 적절한 repository가 선택된다.
    private final MemberRepository memberRepository;

    @Autowired // 의존관계 주입을 자동으로 해줌(생성자 DI) -> ac.getBean(MemberRepository.class)처럼
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
