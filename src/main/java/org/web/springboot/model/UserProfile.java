package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@Getter
@NoArgsConstructor
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false, length = 256)
  private String organization;
  
  @Setter
  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

}
