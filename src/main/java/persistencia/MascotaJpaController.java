package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Mascota;

public class MascotaJpaController {

    private EntityManagerFactory emf = null;

    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MascotaJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // CREATE
    public void create(Mascota mascota) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // EDIT
    public void edit(Mascota mascota) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            mascota = em.merge(mascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Integer id = mascota.getIdMascota();
            if (findMascota(id.intValue()) == null) {
                throw new Exception("La mascota con ID " + id + " no existe.");
            }
            throw ex;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // DESTROY
    public void destroy(int idMascota) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Mascota mascota;
            try {
                mascota = em.getReference(Mascota.class, idMascota);
                mascota.getIdMascota(); // fuerza la carga
            } catch (EntityNotFoundException enfe) {
                throw new Exception("La mascota con ID " + idMascota + " no existe.", enfe);
            }
            em.remove(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // FIND ONE
    public Mascota findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // FIND ALL
    public List<Mascota> findMascotaEntities() {
        return findMascotaEntities(true, -1, -1);
    }

    public List<Mascota> findMascotaEntities(int maxResults, int firstResult) {
        return findMascotaEntities(false, maxResults, firstResult);
    }

    private List<Mascota> findMascotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Mascota> cq = em.getCriteriaBuilder().createQuery(Mascota.class);
            cq.select(cq.from(Mascota.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // COUNT
    public int getMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Mascota> rt = cq.from(Mascota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}