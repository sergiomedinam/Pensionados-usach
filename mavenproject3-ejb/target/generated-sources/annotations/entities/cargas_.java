package entities;

import entities.pensionado;
import entities.seguro;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-26T01:36:56")
@StaticMetamodel(cargas.class)
public class cargas_ { 

    public static volatile SingularAttribute<cargas, seguro> seguro;
    public static volatile SingularAttribute<cargas, Integer> otros;
    public static volatile SingularAttribute<cargas, pensionado> pensionado;
    public static volatile SingularAttribute<cargas, Integer> conyuge;
    public static volatile SingularAttribute<cargas, Integer> hijos;
    public static volatile SingularAttribute<cargas, Long> id;
    public static volatile SingularAttribute<cargas, Integer> titular;

}