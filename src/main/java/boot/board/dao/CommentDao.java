package boot.board.dao;

import java.util.List;

import boot.board.domain.CommentBean;

public interface CommentDao {
	List<CommentBean> selectCommentAll(int boardId);
	CommentBean selectCommentById(int commentId);
	boolean insertComment(CommentBean bean);
	boolean updateComment(CommentBean bean);
	boolean deleteCommentById(int commentId);
	CommentBean lastNum();
}
