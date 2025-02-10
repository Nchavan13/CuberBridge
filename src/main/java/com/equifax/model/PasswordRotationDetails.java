package com.equifax.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "password_rotation")
public class PasswordRotationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_name", nullable = false)
    private String applicationName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_expiry_date", nullable = false)
    private Date passwordExpiryDate;

    @Column(name = "last_modified_date", nullable = false)
    private Date lastModifiedDate;

    @Column(name = "status", nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getApplicationName() { return applicationName; }
    public void setApplicationName(String applicationName) { this.applicationName = applicationName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Date getPasswordExpiryDate() { return passwordExpiryDate; }
    public void setPasswordExpiryDate(Date passwordExpiryDate) { this.passwordExpiryDate = passwordExpiryDate; }
    public Date getLastModifiedDate() { return lastModifiedDate; }
    public void setLastModifiedDate(Date lastModifiedDate) { this.lastModifiedDate = lastModifiedDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}