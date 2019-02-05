package apple.core.service.bookshelf.phone.phones_bean;




import apple.core.service.bookshelf.auth.boundary_user_link.CurrentUser;
import apple.core.service.bookshelf.phone.model.PhoneEntity;
import lv.tsi.javacourses.bookshelf.auth.boundary.CurrentUser;
import lv.tsi.javacourses.bookshelf.books.model.BookEntity;
import lv.tsi.javacourses.bookshelf.books.model.ReservationEntity;
import lv.tsi.javacourses.bookshelf.books.model.ReservationStatus;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.io.Serializable;

@ViewScoped
@Named
public class BookBean implements Serializable {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private CurrentUser currentUser;
    private Long id;
    private PhoneEntity book;

    public void openPhone() {
        System.out.println("Opening book " + id);
        book = em.find(PhoneEntity.class, id);
    }

    @Transactional
    public void reserve(Long id) {
        System.out.println("Trying to reserve book " + id
                + " for user " + currentUser.getUser().getId());

        PhoneEntity book = em.find(PhoneEntity.class, id);

        ReservationEntity reservation = new ReservationEntity();
        reservation.setBook(book);
        reservation.setUser(currentUser.getUser());
        reservation.setStatus(ReservationStatus.ACTIVE);

        em.persist(reservation);
    }

    public BookEntity getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
