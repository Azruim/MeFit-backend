package fi.experis.mefit.models;


import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(length = 20)
    private String password;

    @Column(length = 20, name = "first_name")
    private String firstName;

    @Column(length = 20,name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private String userName;

    @Column(name = "is_contributor")
    private boolean isContributor;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public User() {
        super();
    }

    public User(Long userId, String password, String firstName, String lastName, String email, String userName, boolean isContributor, boolean isAdmin) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.isContributor = isContributor;
        this.isAdmin = isAdmin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isContributor() {
        return isContributor;
    }

    public void setContributor(boolean contributor) {
        isContributor = contributor;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isContributor=" + isContributor +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
