package jpabook.jpashop.domain;

import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    // FK 가 있는 테이블에 JoinColumn을 넣어주고(주인), 다른쪽에 mappedBy를 넣어줌(Deilvery)
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    private String city;

    private String street;

    private String zipcode;

    private DeliveryStatus deliveryStatus;

}
