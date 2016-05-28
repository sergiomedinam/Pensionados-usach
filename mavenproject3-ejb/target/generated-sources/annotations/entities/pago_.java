package entities;

import entities.pagodetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T16:47:54")
@StaticMetamodel(pago.class)
public class pago_ { 

    public static volatile SingularAttribute<pago, Long> id;
    public static volatile SingularAttribute<pago, pagodetalle> pagodetalles;
    public static volatile SingularAttribute<pago, Integer> pago;

}