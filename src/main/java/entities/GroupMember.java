package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

@Entity
@NamedQueries({
    @NamedQuery(name = "GroupMember.deleteAllRows", query = "DELETE from GroupMember"),
    @NamedQuery(name = "GroupMember.getAll", query = "SELECT m FROM GroupMember m"),
    @NamedQuery(name = "GroupMember.getByName", query = "SELECT m FROM GroupMember m WHERE m.name LIKE :name")
})

public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int StudentId;
    private String color;

    public GroupMember() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupMember(String name, int StudentId, String color) {
        this.name = name;
        this.StudentId = StudentId;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 61 * hash + Objects.hashCode(this.id);
//        hash = 61 * hash + Objects.hashCode(this.name);
//        hash = 61 * hash + this.StudentId;
//        hash = 61 * hash + Objects.hashCode(this.color);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final GroupMember other = (GroupMember) obj;
//        if (this.StudentId != other.StudentId) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.color, other.color)) {
//            return false;
//        }
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
    


}
