/*
 * package cgmgl.springmvc.app.persistence.dao;
 * 
 * import java.io.Serializable; import java.lang.reflect.ParameterizedType;
 * import javax.persistence.criteria.CriteriaQuery; import
 * org.hibernate.query.Query; import org.hibernate.Session; import
 * org.hibernate.SessionFactory; import
 * org.springframework.beans.factory.annotation.Autowired;
 * 
 *//**
    * Class AbstractDao for common DAO function. Get CRUD functions by extending
    * this class.
    *
    * @param <K> Entity identity
    * @param <E> Entity class
    */
/*
 * public abstract class AbstractDao<K extends Serializable, E> {
 * 
 *//** persistent class */
/*
 * private final Class<E> persistentClass;
 * 
 *//**
    * Instantiates a new abstract DAO.
    */
/*
 * @SuppressWarnings("unchecked") public AbstractDao() { this.persistentClass =
 * (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
 * .getActualTypeArguments()[1]; }
 * 
 *//** session factory */
/*
 * @Autowired private SessionFactory sessionFactory;
 * 
 * protected Session getSession() { return sessionFactory.getCurrentSession(); }
 * 
 *//**
    * Gets Entity object by id.
    *
    * @param key the key
    * @return entity
    */
/*
 * protected E getById(K key) { return getSession().get(persistentClass, key); }
 * 
 *//**
    * Creates.
    *
    * @param entity
    */
/*
 * protected void create(E entity) { getSession().save(entity); }
 * 
 *//**
    * Update.
    *
    * @param entity
    */
/*
 * protected void update(E entity) { getSession().update(entity); }
 * 
 *//**
    * Delete.
    *
    * @param entity
    */
/*
 * protected void delete(E entity) { getSession().delete(entity); }
 * 
 *//**
    * Delete by id.
    *
    * @param key the key
    */
/*
 * protected void deleteById(K key) { getSession().delete(getById(key)); }
 * 
 *//**
    * Creates the entity criteria.
    *
    * @return criteria
    */
/*
 * protected CriteriaQuery<E> getCriteriaQuery() { return
 * getSession().getCriteriaBuilder().createQuery(persistentClass); }
 * 
 *//**
    * Creates the entity query.
    *
    * @param query the query
    * @return query
    *//*
       * @SuppressWarnings("unchecked") protected Query<E> createQuery(String query) {
       * return getSession().createQuery(query); } }
       */