package boot.board.dto;

public class SearchDto {
	private String scope;
	private String keyword;

	public SearchDto(String scope, String keyword) {
		this.scope = scope;
		this.keyword = keyword;
	}

	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchBean [scope=");
		builder.append(scope);
		builder.append(", keyword=");
		builder.append(keyword);
		builder.append("]");
		return builder.toString();
	}
}
