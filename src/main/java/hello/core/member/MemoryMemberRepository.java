package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    // 원래는 동시성 이슈의 문제 때문에 ConcurrentHashMap을 써야 한다.
    private static Map<Long, Member> store = new HashMap<>(); // 임시 메모리 스토어

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
