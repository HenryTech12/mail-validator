package com.validator.test.dto;

import java.time.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Validator
{
	private boolean valid;
	private boolean block;
	private boolean disposable;
	private boolean email_forwarder;
	private String domain;
	private String text;
	private String reason;
	private int risk;
	private String mx_host;
	List<String> possible_typo;
	private String mx_ip;
	private String mx_info;
	private String last_changed_at;
	

	public void setValid(boolean valid)
	{
		this.valid = valid;
	}

	public boolean isValid()
	{
		return valid;
	}

	public void setBlock(boolean block)
	{
		this.block = block;
	}

	public boolean isBlock()
	{
		return block;
	}

	public void setDisposable(boolean disposable)
	{
		this.disposable = disposable;
	}

	public boolean isDisposable()
	{
		return disposable;
	}

	public void setEmail_forwarder(boolean email_forwarder)
	{
		this.email_forwarder = email_forwarder;
	}

	public boolean isEmail_forwarder()
	{
		return email_forwarder;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	public String getDomain()
	{
		return domain;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getText()
	{
		return text;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getReason()
	{
		return reason;
	}

	public void setRisk(int risk)
	{
		this.risk = risk;
	}

	public int getRisk()
	{
		return risk;
	}

	public void setMx_host(String mx_host)
	{
		this.mx_host = mx_host;
	}

	public String getMx_host()
	{
		return mx_host;
	}

	public void setPossible_typo(List<String> possible_typo)
	{
		this.possible_typo = possible_typo;
	}

	public List<String> getPossible_typo()
	{
		return possible_typo;
	}

	public void setMx_ip(String mx_ip)
	{
		this.mx_ip = mx_ip;
	}

	public String getMx_ip()
	{
		return mx_ip;
	}

	public void setMx_info(String mx_info)
	{
		this.mx_info = mx_info;
	}

	public String getMx_info()
	{
		return mx_info;
	}

	public void setLast_changed_at(String last_changed_at)
	{
		this.last_changed_at = last_changed_at;
	}

	public String getLast_changed_at()
	{
		return last_changed_at;
	}}
