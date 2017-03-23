/*
 * 文件名：User.java
 * 版权：深圳柚安米科技有限公司版权所有
 * 修改人：laishaoqiang
 * 修改时间：2017年1月13日
 * 修改内容：新增
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