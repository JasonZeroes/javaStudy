package cn.study.basic.query;

public class BaseQuery {
	// 当前页
	private Long page = 1L;

	// 每页显示多少条
	private Long pageSize = 10L;

	// 获取起始页
	public Long getStart() {
		return (this.page - 1) * pageSize;
	}

	// 每个高级查询都有key-words
	private String keywords;


	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}


	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
