package entities;

import entities.pensionado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-28T16:19:03")
@StaticMetamodel(designado_fallecimiento.class)
public class designado_fallecimiento_ { 

    public static volatile SingularAttribute<designado_fallecimiento, Long> id;
    public static volatile SingularAttribute<designado_fallecimiento, pensionado> pensionados;
    public static volatile SingularAttribute<designado_fallecimiento, String> parentesco;
    public static volatile SingularAttribute<designado_fallecimiento, String> nombre_designado;
    public static volatile SingularAttribute<designado_fallecimiento, Long> telefono;
    public static volatile SingularAttribute<designado_fallecimiento, String> apellido_designado;
    public static volatile SingularAttribute<designado_fallecimiento, Long> rut_designado;

}