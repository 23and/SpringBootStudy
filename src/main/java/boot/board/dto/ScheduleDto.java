package boot.board.dto;

public class ScheduleDto {
	private String title;

	public ScheduleDto() { }

	public ScheduleDto(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleDto [title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}
}
