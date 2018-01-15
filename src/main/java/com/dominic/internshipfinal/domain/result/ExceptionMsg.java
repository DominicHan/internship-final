
package com.dominic.internshipfinal.domain.result;

public enum ExceptionMsg {
	SUCCESS("000000", "操作成功"),
	FAILED("999999","操作失败"),
    ParamError("000001", "参数错误！"),
    PassWordEmpty("000002", "密码为空！"),
    NickEmpty("000003", "昵称为空！"),
    AccountEmpty("000004", "账号为空！"),
    GesturesPasswordError("000005", "手势密码有误！"),
    GesturesPasswordEmpty("000006", "未设置手势密码"),
    MineInfoEmpty("000007", "此条消息不存在"),
    AccountInfoEmpty("000008", "此账号不存在"),
    AccountAlreadyPraise("000009", "此账号不能重复点赞"),
    LoginNameOrPassWordError("000100", "用户名或者密码错误！"),
    AccountUsed("000101","该账号已被注册"),
    UserNameUsed("000102","该登录名称已存在"),
    EmailNotRegister("000103","该邮箱地址未注册"),
    PassWordError("000105","密码输入错误"),
    UserNameLengthLimit("000106","用户名长度超限"),
    LoginNameNotExists("000107","该用户未注册"),
    UserNameSame("000108","新用户名与原用户名一致"),
    TooManyGoods("000109","购物车中商品太多啦!!!"),
    FileEmpty("000400","上传文件为空"),
    LimitPictureSize("000401","图片大小必须小于2M"),
    LimitPictureType("000402","图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'")
    ;
   private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}


}

