package apple.core.service.bookshelf.phone.phones_bean;


import apple.core.service.bookshelf.auth.model.PhoneEntity;


import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContextö
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.io.Serializable;
import java.io.Serializable;
import java.util.List;
import java.util.List;


@Named
@Named
@SessionScoped
@SessionScoped
public class BookBean implements Serializable {	public class BookBean implements Serializable {
    @PersistenceContext	    @PersistenceContext
    private EntityManager em;	    private EntityManager em;


    public List<Book> getBooks() {	    public List<PhoneEntity> getBooks() {
        return em.createQuery("select b from Book b", Book.class)
                .getResultList();
        return em.createQuery("select b from Book b", PhoneEntity.class)
                .getResultList();
    }	    }


}	}