package entities;

import entities.tipo_prestamo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-13T18:10:32")
@StaticMetamodel(prestamo.class)
public class prestamo_ { 

    public static volatile SingularAttribute<prestamo, String> interes_prestamo;
    public static volatile SingularAttribute<prestamo, String> nombre_prestamo;
    public static volatile SingularAttribute<prestamo, Long> id;
    public static volatile SingularAttribute<prestamo, String> cuotas_prestamo;
    public static volatile SingularAttribute<prestamo, tipo_prestamo> tipo_prestamo;
    public static volatile SingularAttribute<prestamo, String> total_prestamo;

}