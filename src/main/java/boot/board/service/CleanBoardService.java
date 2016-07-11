package boot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boot.board.dao.CleanBoardDao;
import boot.board.domain.CleanBoardBean;
import boot.board.dto.SearchDto;

@Service
@Transactional
public class CleanBoardService{
	
	final static int SIZE = 5;

	@Autowired
	private CleanBoardDao cleanBoardDao;

	public List<CleanBoardBean> selectCleanBoardAll(){
		List<CleanBoardBean> selectAll = cleanBoardDao.selectCleanBoardAll();
		return selectAll;
	}
	
	public List<CleanBoardBean> selectCleanBoardPage(int page){
		int start = (page-1) * SIZE;
		List<CleanBoardBean> selectPage = cleanBoardDao.selectCleanBoardPage(start);
		return selectPage;
	}
	
	@Cacheable(value="cleanCache", key="#id")
	public CleanBoardBean selectCleanBoardById(int id){
		updateCleanBoardViews(id);
		CleanBoardBean cleanBoardBean = cleanBoardDao.selectCleanBoardById(id);
		return cleanBoardBean;
	}

	public boolean insertCleanBoard(CleanBoardBean bean){
		return cleanBoardDao.insertCleanBoard(bean);
	}
	
	@CachePut(value="cleanCache", key="#bean.boardId")
	public boolean updateCleanBoard(CleanBoardBean bean){
		return cleanBoardDao.updateCleanBoard(bean);
	}

	@CacheEvict(value="cleanCache", key="#id")
	public boolean deleteCleanBoardById(int id){
		return cleanBoardDao.deleteCleanBoardById(id);
	}

	public List<CleanBoardBean> searchCleanBoard(SearchDto dto){
		List<CleanBoardBean> cleanBoardBean = cleanBoardDao.searchCleanBoard(dto);
		return cleanBoardBean;
	}

	public boolean updateCleanBoardViews(int id){
		return cleanBoardDao.updateCleanBoardViews(id);
	}
	
	public int countCleanBoardAll(){
		return (cleanBoardDao.countCleanBoardAll()/5) + 1;
	}
}
