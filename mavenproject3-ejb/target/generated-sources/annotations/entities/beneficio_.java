package entities;

import entities.tipo_beneficio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-12T16:41:42")
@StaticMetamodel(beneficio.class)
public class beneficio_ { 

    public static volatile SingularAttribute<beneficio, Long> id;
    public static volatile SingularAttribute<beneficio, String> nombre_beneficio;
    public static volatile SingularAttribute<beneficio, tipo_beneficio> tipo_beneficio;

}