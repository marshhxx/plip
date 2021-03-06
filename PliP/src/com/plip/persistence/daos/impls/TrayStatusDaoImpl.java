package com.plip.persistence.daos.impls;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.plip.exceptions.persistence.TrayStatusNotFoundException;
import com.plip.persistence.daos.interfaces.TrayStatusDao;
import com.plip.persistence.managers.DaoManager;
import com.plip.persistence.model.Tray;
import com.plip.persistence.model.TrayStatus;

public class TrayStatusDaoImpl implements TrayStatusDao {

	public TrayStatusDaoImpl() {
		super();		
	}

	@Override
	public Long addTrayStatus(TrayStatus trayStatus) {
		SessionFactory factory = DaoManager.createSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Long trayStatusID = null;
		try {
			tx = session.beginTransaction();
			if(trayStatus.validate()){
			trayStatusID = (Long) session.save(trayStatus);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return trayStatusID;
	}

	@Override
	public List<Tray> getTraysByStatus(long idStatus) throws TrayStatusNotFoundException {
		SessionFactory factory = DaoManager.createSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List trayList = null;
		try {
			tx = session.beginTransaction();
			Query query = session
					.createQuery("FROM TrayStatus where idStatus = :id");
			query.setParameter("id", idStatus);
			if(query.list().size()!=0){
			trayList = query.list();
			}else{
				throw new TrayStatusNotFoundException();
			}
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return trayList;
	}

	@Override
	public List<TrayStatus> getStatusByTray(long idTray) throws TrayStatusNotFoundException {
		SessionFactory factory = DaoManager.createSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List statusList = null;
		try {
			tx = session.beginTransaction();
			Query query = session
					.createQuery("FROM TrayStatus where id_tray = :id");
			query.setParameter("id", idTray);
			if(query.list().size() > 0){
			statusList = query.list();
			}else{
				throw new TrayStatusNotFoundException();
			}
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return statusList;
	}

	@Override
	public void updateTrayStatus(TrayStatus trayStatus) throws TrayStatusNotFoundException {
		SessionFactory factory = DaoManager.createSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TrayStatus trayStat = (TrayStatus) session.get(TrayStatus.class,
					trayStatus.getIdTrayStatus());
			if(trayStat != null){
			trayStat.setDate(trayStatus.getDate());
			trayStat.setQuantity(trayStatus.getQuantity());
			trayStat.setProduct(trayStatus.getProduct());
			session.update(trayStat);
			}else{
				throw new TrayStatusNotFoundException();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteTrayStatus(long trayStatusId) {
		SessionFactory factory = DaoManager.createSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TrayStatus trayStatus = (TrayStatus) session.get(TrayStatus.class,
					trayStatusId);
			if(trayStatus!=null){
			session.delete(trayStatus);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
