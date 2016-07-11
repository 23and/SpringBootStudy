package boot.board.domain;

import java.sql.Date;

public class CommentBean {
	private int commentId;
	private String content;
	private String name;
	private Date writeDate;
	private int parent;
	private int indent;
	private int step;
	private int boardId;
	
	public CommentBean() { }

	public CommentBean(int commentId, String content, String name, Date writeDate, int parent, int indent, int step, int boardId) {
		this.commentId = commentId;
		this.content = content;
		this.name = name;
		this.writeDate = writeDate;
		this.parent = parent;
		this.indent = indent;
		this.step = step;
		this.boardId = boardId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentBean [commentId=");
		builder.append(commentId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", name=");
		builder.append(name);
		builder.append(", writeDate=");
		builder.append(writeDate);
		builder.append(", parent=");
		builder.append(parent);
		builder.append(", indent=");
		builder.append(indent);
		builder.append(", step=");
		builder.append(step);
		builder.append(", boardId=");
		builder.append(boardId);
		builder.append("]");
		return builder.toString();
	}
}
