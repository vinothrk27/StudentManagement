package com.fastfire.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fastfire.model.Student;
import com.fastfire.utils.HibernateSessionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudents() {
		Session session = HibernateSessionFactory.openSession();
		Transaction txt;
		List<Student> students = new ArrayList<Student>();
		
		try {
			txt = session.getTransaction();
			txt.begin();
			/*Query query = session.createQuery("from Student order by 1 desc");
			students = (List<Student>) query.list();*/
			Criteria crit = session.createCriteria(Student.class);
			students = crit.list();
			
			txt.commit();
			return students;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = HibernateSessionFactory.openSession();
		Transaction txt;
		Student student;
		
		try {
			txt = session.beginTransaction();
			txt.begin();
			Criteria ctr = session.createCriteria(Student.class);
			ctr.add(Restrictions.eq("id",id));
			student = (Student) ctr.uniqueResult();
			txt.commit();
			return student;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addStudent(Student student) {
		Session session = HibernateSessionFactory.openSession();
		Transaction txt = null;
		
		try {
			txt = session.beginTransaction();
			txt.begin();
			int result = (Integer)session.save(student); 
			txt.commit();
			if(result!=0)
				return true;
			else
				return false;
		} catch (HibernateException e) {
			if(txt != null) {
				txt.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		Session session = HibernateSessionFactory.openSession();
		Transaction tran = null;
		
		try {
			tran = session.beginTransaction();
			tran.begin();
			session.saveOrUpdate(student);
			tran.commit();
		} catch (HibernateException e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		Session session = HibernateSessionFactory.openSession();
		Transaction tran = null;
		
		try {
			tran = session.beginTransaction();
			tran.begin();
			session.delete(student);
			tran.commit();
		} catch (HibernateException e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return false;
	}

}
