package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memoryMemberRepository;

    public MemberServiceImpl(MemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        memoryMemberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memoryMemberRepository.findById(id);
    }
}
