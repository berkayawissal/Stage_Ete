package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "admins")
public class Admin extends Users{


}