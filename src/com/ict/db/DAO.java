package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import oracle.jdbc.OracleConnection.CommitOption;

// DB 처리 클래스
public class DAO {

	// MyBatis 는 SqlSession 클래스를 사용
	private static SqlSession ss;
	
	// Singleton 패턴
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			// [Auto commit X]
			//	> Transaction 처리 시 개발자가 수동으로 commit 
			// ss = DBService.getFactory().openSession(false);
			ss = DBService.getFactory().openSession();
			
			// [Auto commit O]
			// ss = DBService.getFactory().openSession(true);
			
			// SELECT 쿼리는 commit 이 필요 없음
			// INSERT, UPDATE, DELETE 는 commit 필요
		}
		return ss;
	}
	
// ↓↓↓ SqlSession 을 이용하여 DB 처리 ↓↓↓
	
// list - SELECT
	public static List<VO> getList() {
		List<VO> list = null;
		list = getSession().selectList("list");
		return list;
	}
	
// write - INSERT
	public static int getWrite(VO vo) {
		int result = 0;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result;
	}
	
// onelist - SELECT
	public static VO getOnelist(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
// update - UPDATE
	public static int getUpdate(VO vo) {
		int result = 0;
		result = getSession().update("update", vo);
		ss.commit();
		return result;
	}

// delete - DELETE
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("delete", idx);
		ss.commit();
		return result;
	}
	
}
