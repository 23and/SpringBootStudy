package boot.board.domain;

import java.sql.Date;

public class CleanBoardBean {
	private int boardId;
	private String title;
	private String content;
	private String name;
	private Date writeDate;
	private int views;
	
	public CleanBoardBean() { }

	public CleanBoardBean(int boardId, String title, String content, String name, Date writeDate, int views) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.name = name;
		this.writeDate = writeDate;
		this.views = views;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CleanBoardBean [boardId=");
		builder.append(boardId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", name=");
		builder.append(name);
		builder.append(", writeDate=");
		builder.append(writeDate);
		builder.append(", views=");
		builder.append(views);
		builder.append("]");
		return builder.toString();
	}
}