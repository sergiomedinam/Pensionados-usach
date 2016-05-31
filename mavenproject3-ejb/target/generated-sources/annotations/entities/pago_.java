package entities;

import entities.pagodetalle;
import entities.pensionado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-31T02:45:41")
@StaticMetamodel(pago.class)
public class pago_ { 

    public static volatile SingularAttribute<pago, String> ano;
    public static volatile SingularAttribute<pago, pensionado> pensionado;
    public static volatile SingularAttribute<pago, Boolean> completo;
    public static volatile SingularAttribute<pago, pagodetalle> pagodetalles;
    public static volatile SingularAttribute<pago, String> mes;
    public static volatile SingularAttribute<pago, Long> id;
    public static volatile SingularAttribute<pago, Integer> pago;

}