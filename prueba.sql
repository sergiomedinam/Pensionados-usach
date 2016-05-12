-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-05-2016 a las 05:56:54
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beneficio`
--

CREATE TABLE `beneficio` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE_BENEFICIO` varchar(255) DEFAULT NULL,
  `TIPO_BENEFICIO_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `ID` bigint(20) NOT NULL,
  `APELLIDO_CONTACTO` varchar(255) DEFAULT NULL,
  `NOMBRE_CONTACTO` varchar(255) DEFAULT NULL,
  `PARENTESCO` varchar(255) DEFAULT NULL,
  `TELEFONO_CONTACTO` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `designado_fallecimiento`
--

CREATE TABLE `designado_fallecimiento` (
  `ID` bigint(20) NOT NULL,
  `APELLIDO_DESIGNADO` varchar(255) DEFAULT NULL,
  `NOMBRE_DESIGNADO` varchar(255) DEFAULT NULL,
  `PARENTESCO` varchar(255) DEFAULT NULL,
  `RUT_DESIGNADO` bigint(20) DEFAULT NULL,
  `TELEFONO` bigint(20) DEFAULT NULL,
  `PENSIONADOS_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE_MEDICAMENTO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `otros_datos`
--

CREATE TABLE `otros_datos` (
  `ID` bigint(20) NOT NULL,
  `CAJA_COMPENSACION` varchar(255) DEFAULT NULL,
  `CUENTA_BANCO` varchar(255) DEFAULT NULL,
  `ESTAMENTO` varchar(255) DEFAULT NULL,
  `MONTO_PENSION` int(11) DEFAULT NULL,
  `NOMBRE_BANCO` varchar(255) DEFAULT NULL,
  `SISTEMA_PENSION` varchar(255) DEFAULT NULL,
  `SISTEMA_SALUD` varchar(255) DEFAULT NULL,
  `TIPO_PENSION` varchar(255) DEFAULT NULL,
  `ULTIMO_APORTE` varchar(255) DEFAULT NULL,
  `VALOR_CUOTA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patologia`
--

CREATE TABLE `patologia` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE_PATOLOGIA` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pensionado`
--

CREATE TABLE `pensionado` (
  `ID` bigint(20) NOT NULL,
  `APELLIDO_M_PENSIONADO` varchar(255) DEFAULT NULL,
  `APELLIDO_P_PENSIONADO` varchar(255) DEFAULT NULL,
  `CELULAR` bigint(20) DEFAULT NULL,
  `COMUNA` varchar(255) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `ESTADO_CIVIL` varchar(255) DEFAULT NULL,
  `FECHA_NACIMIENTO` varchar(255) DEFAULT NULL,
  `NOMBRE_PENSIONADO` varchar(255) DEFAULT NULL,
  `REGION` varchar(255) DEFAULT NULL,
  `RUT_PENSIONADO` varchar(255) DEFAULT NULL,
  `TELEFONO_FIJO` bigint(20) DEFAULT NULL,
  `BENEFICIOS_ID` bigint(20) DEFAULT NULL,
  `CONTACTOS_ID` bigint(20) DEFAULT NULL,
  `MEDICAMENTOS_ID` bigint(20) DEFAULT NULL,
  `PATOLOGIAS_ID` bigint(20) DEFAULT NULL,
  `PRESTAMOS_ID` bigint(20) DEFAULT NULL,
  `SEGUROS_ID` bigint(20) DEFAULT NULL,
  `OTROS_DATOS_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `ID` bigint(20) NOT NULL,
  `CUOTAS_PRESTAMO` varchar(255) DEFAULT NULL,
  `INTERES_PRESTAMO` varchar(255) DEFAULT NULL,
  `NOMBRE_PRESTAMO` varchar(255) DEFAULT NULL,
  `TOTAL_PRESTAMO` varchar(255) DEFAULT NULL,
  `TIPO_PRESTAMO_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ROL_ID` bigint(20) NOT NULL,
  `ROL_NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ROL_ID`, `ROL_NOMBRE`) VALUES
(1, 'admin'),
(2, 'usuario'),
(3, 'observador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguro`
--

CREATE TABLE `seguro` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE_SEGURO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_beneficio`
--

CREATE TABLE `tipo_beneficio` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE_T_BENEFICIO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_prestamo`
--

CREATE TABLE `tipo_prestamo` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE_T_PRESTAMO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_groups_map`
--

CREATE TABLE `users_groups_map` (
  `USUARIO_ID` bigint(20) NOT NULL,
  `ROL_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users_groups_map`
--

INSERT INTO `users_groups_map` (`USUARIO_ID`, `ROL_ID`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `USUARIO_ID` bigint(20) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CONTRASENA` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `RUT` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`USUARIO_ID`, `APELLIDO`, `CONTRASENA`, `NOMBRE`, `RUT`) VALUES
(1, 'jerez', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'nelson', '185401502'),
(2, 'cocio', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'jorge', '123456789');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_user_role`
--
CREATE TABLE `v_user_role` (
`RUT` varchar(255)
,`CONTRASENA` varchar(255)
,`ROL_NOMBRE` varchar(255)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `v_user_role`
--
DROP TABLE IF EXISTS `v_user_role`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user_role`  AS  select `u`.`RUT` AS `RUT`,`u`.`CONTRASENA` AS `CONTRASENA`,`g`.`ROL_NOMBRE` AS `ROL_NOMBRE` from ((`users_groups_map` `ug` join `usuario` `u` on((`u`.`USUARIO_ID` = `ug`.`USUARIO_ID`))) join `rol` `g` on((`g`.`ROL_ID` = `ug`.`ROL_ID`))) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `beneficio`
--
ALTER TABLE `beneficio`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_BENEFICIO_TIPO_BENEFICIO_ID` (`TIPO_BENEFICIO_ID`);

--
-- Indices de la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `designado_fallecimiento`
--
ALTER TABLE `designado_fallecimiento`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_DESIGNADO_FALLECIMIENTO_PENSIONADOS_ID` (`PENSIONADOS_ID`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `otros_datos`
--
ALTER TABLE `otros_datos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `patologia`
--
ALTER TABLE `patologia`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `pensionado`
--
ALTER TABLE `pensionado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PENSIONADO_OTROS_DATOS_ID` (`OTROS_DATOS_ID`),
  ADD KEY `FK_PENSIONADO_BENEFICIOS_ID` (`BENEFICIOS_ID`),
  ADD KEY `FK_PENSIONADO_MEDICAMENTOS_ID` (`MEDICAMENTOS_ID`),
  ADD KEY `FK_PENSIONADO_PATOLOGIAS_ID` (`PATOLOGIAS_ID`),
  ADD KEY `FK_PENSIONADO_SEGUROS_ID` (`SEGUROS_ID`),
  ADD KEY `FK_PENSIONADO_CONTACTOS_ID` (`CONTACTOS_ID`),
  ADD KEY `FK_PENSIONADO_PRESTAMOS_ID` (`PRESTAMOS_ID`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PRESTAMO_TIPO_PRESTAMO_ID` (`TIPO_PRESTAMO_ID`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ROL_ID`);

--
-- Indices de la tabla `seguro`
--
ALTER TABLE `seguro`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tipo_beneficio`
--
ALTER TABLE `tipo_beneficio`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tipo_prestamo`
--
ALTER TABLE `tipo_prestamo`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `users_groups_map`
--
ALTER TABLE `users_groups_map`
  ADD PRIMARY KEY (`USUARIO_ID`,`ROL_ID`),
  ADD KEY `FK_USERS_GROUPS_MAP_ROL_ID` (`ROL_ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`USUARIO_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `beneficio`
--
ALTER TABLE `beneficio`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `contacto`
--
ALTER TABLE `contacto`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `designado_fallecimiento`
--
ALTER TABLE `designado_fallecimiento`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `otros_datos`
--
ALTER TABLE `otros_datos`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `patologia`
--
ALTER TABLE `patologia`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pensionado`
--
ALTER TABLE `pensionado`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `ROL_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `seguro`
--
ALTER TABLE `seguro`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_beneficio`
--
ALTER TABLE `tipo_beneficio`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_prestamo`
--
ALTER TABLE `tipo_prestamo`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `USUARIO_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `beneficio`
--
ALTER TABLE `beneficio`
  ADD CONSTRAINT `FK_BENEFICIO_TIPO_BENEFICIO_ID` FOREIGN KEY (`TIPO_BENEFICIO_ID`) REFERENCES `tipo_beneficio` (`ID`);

--
-- Filtros para la tabla `designado_fallecimiento`
--
ALTER TABLE `designado_fallecimiento`
  ADD CONSTRAINT `FK_DESIGNADO_FALLECIMIENTO_PENSIONADOS_ID` FOREIGN KEY (`PENSIONADOS_ID`) REFERENCES `pensionado` (`ID`);

--
-- Filtros para la tabla `pensionado`
--
ALTER TABLE `pensionado`
  ADD CONSTRAINT `FK_PENSIONADO_BENEFICIOS_ID` FOREIGN KEY (`BENEFICIOS_ID`) REFERENCES `beneficio` (`ID`),
  ADD CONSTRAINT `FK_PENSIONADO_CONTACTOS_ID` FOREIGN KEY (`CONTACTOS_ID`) REFERENCES `contacto` (`ID`),
  ADD CONSTRAINT `FK_PENSIONADO_MEDICAMENTOS_ID` FOREIGN KEY (`MEDICAMENTOS_ID`) REFERENCES `medicamento` (`ID`),
  ADD CONSTRAINT `FK_PENSIONADO_OTROS_DATOS_ID` FOREIGN KEY (`OTROS_DATOS_ID`) REFERENCES `otros_datos` (`ID`),
  ADD CONSTRAINT `FK_PENSIONADO_PATOLOGIAS_ID` FOREIGN KEY (`PATOLOGIAS_ID`) REFERENCES `patologia` (`ID`),
  ADD CONSTRAINT `FK_PENSIONADO_PRESTAMOS_ID` FOREIGN KEY (`PRESTAMOS_ID`) REFERENCES `prestamo` (`ID`),
  ADD CONSTRAINT `FK_PENSIONADO_SEGUROS_ID` FOREIGN KEY (`SEGUROS_ID`) REFERENCES `seguro` (`ID`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `FK_PRESTAMO_TIPO_PRESTAMO_ID` FOREIGN KEY (`TIPO_PRESTAMO_ID`) REFERENCES `tipo_prestamo` (`ID`);

--
-- Filtros para la tabla `users_groups_map`
--
ALTER TABLE `users_groups_map`
  ADD CONSTRAINT `FK_USERS_GROUPS_MAP_ROL_ID` FOREIGN KEY (`ROL_ID`) REFERENCES `rol` (`ROL_ID`),
  ADD CONSTRAINT `FK_USERS_GROUPS_MAP_USUARIO_ID` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`USUARIO_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
