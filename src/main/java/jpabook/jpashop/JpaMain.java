package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

//            Order order = new Order();
            // 양방향 관계 데이터 넣어준다
//            order.addOrderItem(new OrderItem());
            // 양방향을 넣지 않아도 개발하는데 아무문제 없다.
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//
//            em.persist(orderItem);

            // 상속관계 매핑
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("JPA AUTHOR");

            em.persist(book);

            System.out.println("book = " + book.getAuthor());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
