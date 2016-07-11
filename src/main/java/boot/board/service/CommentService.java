package boot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boot.board.dao.CommentDao;
import boot.board.domain.CommentBean;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	public List<CommentBean> selectCommentAll(int boardId){
		List<CommentBean> selectAll = commentDao.selectCommentAll(boardId);
		return selectAll;
	}
	
	public CommentBean selectCommentById(int commentId){
		CommentBean bean = commentDao.selectCommentById(commentId);
		return bean;
	}
	
	public boolean insertComment(CommentBean bean){	
		CommentBean comment = new CommentBean();
		comment = selectCommentById(bean.getParent());

		if(comment == null){
			return commentDao.insertComment(bean);
		}else{
			bean.setParent(comment.getParent());		
			commentDao.updateComment(bean);
			return commentDao.insertComment(bean);
		}
	}
	
	public boolean updateComment(CommentBean bean){
		return commentDao.updateComment(bean);	
	}
	
	public boolean deleteCommentById(int commentId){
		return commentDao.deleteCommentById(commentId);	
	}
	
	public int lastNum(){
		if(commentDao.lastNum() == null){
			return 0;
		}else{
			return commentDao.lastNum().getCommentId() + 1;
		}
	}
}
