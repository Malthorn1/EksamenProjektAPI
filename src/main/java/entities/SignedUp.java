/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author mikke
 */
@Entity
@NamedQuery(name = "SignedUp.deleteAllRows", query = "DELETE from SignedUp")
public class SignedUp {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean payed; 
    private String datePayed; 
    
    @ManyToOne(cascade = {CascadeType.ALL})
    private Student Student; 
    
    

}
