package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-02T16:14:14")
@StaticMetamodel(auditoria.class)
public class auditoria_ { 

    public static volatile SingularAttribute<auditoria, String> valor_antiguo;
    public static volatile SingularAttribute<auditoria, Long> id_registro;
    public static volatile SingularAttribute<auditoria, String> nombre_tabla;
    public static volatile SingularAttribute<auditoria, Long> id;
    public static volatile SingularAttribute<auditoria, String> valor_nuevo;
    public static volatile SingularAttribute<auditoria, Date> fechayhora;
    public static volatile SingularAttribute<auditoria, String> nombre_usuario;
    public static volatile SingularAttribute<auditoria, String> nombre_columna;

}