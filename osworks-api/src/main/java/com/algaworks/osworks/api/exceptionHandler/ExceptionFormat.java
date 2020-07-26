package com.algaworks.osworks.api.exceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ExceptionFormat {
	private int status;
	private OffsetDateTime date;
	private String msg;
	private List<Field> field;
	
	public List<Field> getField() {
		return field;
	}
	public void setField(List field) {
		this.field = field;
	}
	public static class Field {
		String nome;
		String msg;

		public Field(String nome, String msg) {
			super();
			this.nome = nome;
			this.msg = msg;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public OffsetDateTime getDate() {
		return date;
	}
	public void setDate(OffsetDateTime date) {
		this.date = date;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
