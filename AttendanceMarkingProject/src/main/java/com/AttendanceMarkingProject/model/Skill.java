package com.AttendanceMarkingProject.model;

public class Skill {

	private int skillId;
	private String skillType;
	private String skillDesc;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public Skill(int skillId, String skillType, String skillDesc) {
		super();
		this.skillId = skillId;
		this.skillType = skillType;
		this.skillDesc = skillDesc;
	}
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillType=" + skillType + ", skillDesc=" + skillDesc + "]";
	}
	
	
	
}
