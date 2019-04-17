/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicolaenastas
 */
@Entity
@DiscriminatorValue(value = "Student")
@XmlRootElement
public class Student extends Person{
    
}
