package com.lgcns.icst.lecture.servletjsp.lec6.model.biz;

import com.lgcns.icst.lecture.servletjsp.lec6.model.dao.FreeBoardDAO;
import com.lgcns.icst.lecture.servletjsp.lec6.model.dto.FreeBoardDTO;
import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.FreeBoardEntity;
import com.lgcns.icst.lecture.servletjsp.lec6.util.JdbcUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardBiz {

    public List<FreeBoardDTO> findAll() throws Exception {
        List<FreeBoardDTO> list = new ArrayList<>();
        FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            List<FreeBoardEntity> freeBoardEntities = freeBoardDAO.findAllFreeBoards(connection);
            for (FreeBoardEntity freeBoardEntity : freeBoardEntities) {
                FreeBoardDTO freeBoardDTO = new FreeBoardDTO(freeBoardEntity);
                list.add(freeBoardDTO);
            }
            return list;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void save(String content, String memberName) throws Exception {
        FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            boolean result = freeBoardDAO.insertFreeBoard(connection, content, memberName);
            if (result) {
                JdbcUtil.commit(connection);
            } else {
                throw new Exception("게시글 작성을 실패 했습니다.");
            }
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public FreeBoardDTO findById(Long id) throws Exception {
        FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            FreeBoardEntity freeBoardEntity = freeBoardDAO.findFreeBoardById(connection, id);
            return new FreeBoardDTO(freeBoardEntity);
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void update(Long id, String content) throws Exception {
        FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            boolean result = freeBoardDAO.updateFreeBoard(connection, id, content);
            if (result) {
                JdbcUtil.commit(connection);
            } else {
                throw new Exception("게시글이 변경 되지 않았습니다.");
            }
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void delete(Long id) throws Exception {
        FreeBoardDAO freeBoardDAO = new FreeBoardDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            boolean result = freeBoardDAO.deleteFreeBoardById(connection, id);
            if (result) {
                JdbcUtil.commit(connection);
            } else {
                throw new Exception("게시글 삭제를 실패 했습니다.");
            }
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }
}
