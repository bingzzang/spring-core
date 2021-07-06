package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {  //역할
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {    //역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();    //구현 클래스
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();        //구현 클래스
    }
}
