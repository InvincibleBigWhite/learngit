package com.blog.bean;

public class Text {
	private int id;//文章ID
	private String title;//文章标题
	private String text;//文章内容
	public Text(){
		
	}
	public Text(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
