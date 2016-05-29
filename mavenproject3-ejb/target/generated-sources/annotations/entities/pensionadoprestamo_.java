package entities;

import entities.pensionado;
import entities.prestamo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-28T18:37:12")
@StaticMetamodel(pensionadoprestamo.class)
public class pensionadoprestamo_ { 

    public static volatile SingularAttribute<pensionadoprestamo, prestamo> prestamo;
    public static volatile SingularAttribute<pensionadoprestamo, String> fecha_pedido;
    public static volatile SingularAttribute<pensionadoprestamo, Integer> monto_total;
    public static volatile SingularAttribute<pensionadoprestamo, pensionado> pensionado;
    public static volatile SingularAttribute<pensionadoprestamo, String> fecha_termino;
    public static volatile SingularAttribute<pensionadoprestamo, Long> id;
    public static volatile SingularAttribute<pensionadoprestamo, Integer> cuotas;

}