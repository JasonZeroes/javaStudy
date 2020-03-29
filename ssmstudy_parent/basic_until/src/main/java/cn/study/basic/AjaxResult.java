package cn.study.basic;

/**
 * Ajax请求的返回内容
 * success:成功与否
 * message:失败原因
 */
public class AjaxResult {
	private boolean success = true;
	private String message = "操作成功";

	public boolean isSuccess() {
		return success;
	}

	// 链式编程 设置完成,返回自己
	public AjaxResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public AjaxResult setMessage(String message) {
		this.message = message;
		return this;
	}

	// 默认成功
	public AjaxResult() {
	}

	public AjaxResult(String message) {
		this.success = false;
		this.message = message;
	}

	// 避免创建太多的对象
	public static AjaxResult me() {
		return new AjaxResult();
	}

	public static void main(String[] args) {
		AjaxResult.me().setSuccess(false).setMessage("XXX");
	}
}
