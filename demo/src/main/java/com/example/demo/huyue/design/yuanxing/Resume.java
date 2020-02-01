package com.example.demo.huyue.design.yuanxing;

/**
 * @author huyue01@sinovatech.com 2019/10/6 14:20
 */
public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private WorkExperience workExperience;

    public Resume(String name) {
        this.name = name;
    }

    public Resume(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public void setAge(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public  void setWorkExperience(String workDate,String company){
        workExperience = new WorkExperience(workDate,company);
    }

    public void display(){
        System.out.println(name+" " +sex+" " +age);
        System.out.println(workExperience.getWorkDate()+" "+workExperience.getCompany());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume resume  = new Resume(this.workExperience);
        resume.name = this.name;
        resume.age = this.age;
        resume.sex = this.sex;
        return resume;
    }
}
