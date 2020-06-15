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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author mikke
 */

@Entity 
@NamedQuery(name = "YogaClass.deleteAllRows", query = "DELETE from YogaClass")
public class YogaClass {
 private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate; 
    private String Price; 
    
    @ManyToMany(cascade = {CascadeType.ALL})
    private Instructor Instructor; 
    
    
    @ManyToOne(cascade = {CascadeType.ALL})
    private Course Course; 
    
    
    
    @OneToMany(cascade = {CascadeType.ALL})
    private SignedUp SignedUp; 
    
}
