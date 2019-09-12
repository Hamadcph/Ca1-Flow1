/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.GroupMember;

/**
 *
 * @author hamad
 */
public class GroupMemberDTO {
    
    private String name;
    private int StudentID;
    private String color;
    
    public GroupMemberDTO() {}

    public GroupMemberDTO(GroupMember gmember) {
        this.name = gmember.getName();
        this.StudentID = gmember.getStudentId();
        this.color = gmember.getColor();
    }
    
    
    
}
