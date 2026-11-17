package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private String firstName;

  @Setter
  @Column(nullable = false)
  private String lastName;

  // TBD: Investigate using @Size for form validation

  @Setter
  @Column(nullable = false, unique = true, length = 256)
  private String emailAddress;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  // TBD: Need to add enabled/disabled, last login, etc. fields

  @Setter
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "profile_id", unique = true, nullable = false)
  private UserProfile userProfile;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private final Set<Role> roles = new HashSet<>();

  public LocalDate getCreatedDate() {
    return createdAt == null ? null : createdAt.atOffset(ZoneOffset.UTC).toLocalDate();
  }

  @Override
  public String toString () {
    // TBD: Roles is a set, not a list; so for the purpose of
    // printing, we won't necessarily be able to get a specific item
    // by index without first converting to a list and sorting first.
    return "User{id=%d, first=%s, last=%s, email=%s}".formatted(id, firstName, lastName, emailAddress);
  }

}
