package boot.board.dao;

import java.util.List;

import boot.board.domain.CleanBoardBean;
import boot.board.dto.SearchDto;

public interface CleanBoardDao {
	List<CleanBoardBean> selectCleanBoardAll();
	List<CleanBoardBean> selectCleanBoardPage(int id);
	CleanBoardBean selectCleanBoardById(int id);
	boolean insertCleanBoard(CleanBoardBean bean);
	boolean updateCleanBoard(CleanBoardBean bean);
	boolean deleteCleanBoardById(int id);
	List<CleanBoardBean> searchCleanBoard(SearchDto dto);
	boolean updateCleanBoardViews(int id);
	int countCleanBoardAll();
}
