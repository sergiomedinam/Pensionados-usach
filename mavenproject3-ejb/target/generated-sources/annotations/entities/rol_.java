package entities;

import entities.usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-11T23:18:39")
@StaticMetamodel(rol.class)
public class rol_ { 

    public static volatile SingularAttribute<rol, String> rol_nombre;
    public static volatile SetAttribute<rol, usuario> usersThatBelongsToThisGroup;
    public static volatile SingularAttribute<rol, Long> rol_id;

}