package entities;

import entities.beneficio;
import entities.contacto;
import entities.medicamento;
import entities.otros_datos;
import entities.patologia;
import entities.prestamo;
import entities.seguro;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-12T17:33:00")
@StaticMetamodel(pensionado.class)
public class pensionado_ { 

    public static volatile SingularAttribute<pensionado, String> apellido_m_pensionado;
    public static volatile SingularAttribute<pensionado, patologia> patologias;
    public static volatile SingularAttribute<pensionado, Long> telefono_fijo;
    public static volatile SingularAttribute<pensionado, String> rut_pensionado;
    public static volatile SingularAttribute<pensionado, String> email_alternativo;
    public static volatile SingularAttribute<pensionado, String> apellido_p_pensionado;
    public static volatile SingularAttribute<pensionado, String> fecha_nacimiento;
    public static volatile SingularAttribute<pensionado, String> estado_civil;
    public static volatile SingularAttribute<pensionado, String> direccion;
    public static volatile SingularAttribute<pensionado, otros_datos> otros_datos;
    public static volatile SingularAttribute<pensionado, prestamo> prestamos;
    public static volatile SingularAttribute<pensionado, medicamento> medicamentos;
    public static volatile SingularAttribute<pensionado, String> comuna;
    public static volatile SingularAttribute<pensionado, Long> celular;
    public static volatile SingularAttribute<pensionado, String> email_pensionado;
    public static volatile SingularAttribute<pensionado, contacto> contactos;
    public static volatile SingularAttribute<pensionado, Long> id;
    public static volatile SingularAttribute<pensionado, String> region;
    public static volatile SingularAttribute<pensionado, String> nombre_pensionado;
    public static volatile SingularAttribute<pensionado, seguro> seguros;
    public static volatile SingularAttribute<pensionado, beneficio> beneficios;

}