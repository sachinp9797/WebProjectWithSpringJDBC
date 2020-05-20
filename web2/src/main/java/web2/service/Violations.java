package web2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "", propOrder = { "parameters"})
@XmlRootElement(name = "Violations")
public class Violations {

	
    @XmlElement(name = "parameters")
    private Collection<Violation> violationsList = new ArrayList<>();


//    public Violations(Violation violation) {
//        violationsList.add(violation);
//    }
//
//    public Violations(Collection<Violation> violations) {
//        violationsList.addAll(violations);
//    }

//    public boolean add(Violation violation) {
//        return violationsList.add(violation);
//    }
//
//    public int size() {
//        return violationsList.size();
//    }
//
//    public boolean addAll(Collection<Violation> violations) {
//        return violationsList.addAll(violations);
//    }
//
//    public boolean isEmpty() {
//        return violationsList.isEmpty();
//    }
//
//    public boolean contains(Violation violation) {
//        return violationsList.contains(violation);
//    }
//
//    public boolean remove(Violation violation) {
//        return violationsList.remove(violation);
//    }
//
//    public void forEach(Consumer<? super Violation> consumer) {
//        violationsList.forEach(consumer);
//    }
    
    public Collection<Violation> getViolationsList() {
        return violationsList;
    }

    public void setViolationsList(Collection<Violation> violationsList) {
        this.violationsList = violationsList;
    }
}
