package net.slowvic.fastjson;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Team
{
	private List<Member> members;
	private Map<String,Member> group;
	private Date buildDate;
	private boolean in;
	public List<Member> getMembers()
	{
		return members;
	}
	public void setMembers(List<Member> members)
	{
		this.members = members;
	}
	public void setGroup(Map<String,Member> group)
	{
		this.group = group;
	}
	public Map<String,Member> getGroup()
	{
		return group;
	}
	public Date getBuildDate()
	{
		return buildDate;
	}
	public void setBuildDate(Date buildDate)
	{
		this.buildDate = buildDate;
	}
	public boolean isIn()
	{
		return in;
	}
	public void setIn(boolean in)
	{
		this.in = in;
	}
}
