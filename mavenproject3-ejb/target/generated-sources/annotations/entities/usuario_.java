package entities;

import entities.rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-12T17:33:00")
@StaticMetamodel(usuario.class)
public class usuario_ { 

    public static volatile SingularAttribute<usuario, String> rut;
    public static volatile SingularAttribute<usuario, String> email_usuario;
    public static volatile SingularAttribute<usuario, String> apellido;
    public static volatile SingularAttribute<usuario, String> contrasena;
    public static volatile SingularAttribute<usuario, Long> id;
    public static volatile SingularAttribute<usuario, String> nombre;
    public static volatile SingularAttribute<usuario, rol> tipo_usuario;

}