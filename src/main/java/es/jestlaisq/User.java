/*
 * �ļ�����User.java
 * ��Ȩ�������ְ��׿Ƽ����޹�˾��Ȩ����
 * �޸��ˣ�laishaoqiang
 * �޸�ʱ�䣺2017��1��13��
 * �޸����ݣ�����
 */
package es.jestlaisq;

import io.searchbox.annotations.JestId;

public class User {
    @JestId
    private Long id;
    private String name;
    private int age;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
}