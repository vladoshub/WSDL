package ru.mmtr.jaxrs.daoimpl;

import ru.mmtr.jaxrs.api.HumanDao;
import ru.mmtr.jaxrs.model.Human;
import ru.mmtr.jaxrs.model.Human_;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class HumanDaoImpl implements HumanDao {

    @PersistenceContext(unitName = "Human")
    private EntityManager em;
    public List<Human> getHumans() {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Human> query = builder.createQuery(Human.class);
            Root<Human> root = query.from(Human.class);
            query.select(root);
            return em.createQuery(query).getResultList();
        } catch (Exception e) {
          return null;
        }
    }


    public void addHuman(Human human){
            try {
                if(human.getId()==null) {
                    em.persist(human);
                }
                else {
                    em.merge(human);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public List<Human> getHumansByParams(SearchCriteria searchCriteria) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Human> query = builder.createQuery(Human.class);
            Root<Human> root = query.from(Human.class);
            query.select(root).where(getPredicate(searchCriteria,builder,root));
            return em.createQuery(query).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Predicate getPredicate(SearchCriteria searchCriteria,CriteriaBuilder builder,Root<Human> root){
        Predicate where = builder.conjunction();
        int a=4;
        if(searchCriteria.getName()!=null) {
            where = builder.and(where,builder.like(root.<String>get(Human_.NAME), searchCriteria.getName() + "%"));
        }
        if(searchCriteria.getAge()!=null) {
           where = builder.and(where,builder.equal(root.<Integer>get(Human_.AGE),searchCriteria.getAge()));
        }
        if(searchCriteria.getGrowth()!=null) {
            where = builder.and(where,builder.equal(root.<Integer>get(Human_.GROWTH),searchCriteria.getGrowth()));
        }
        return  where;

    }




}