INSERT INTO public.usua_rol(rol_id, rol_nombre, rol_sigla) VALUES (1, 'Administrador', 'ADMIN');
INSERT INTO public.usua_rol(rol_id, rol_nombre, rol_sigla) VALUES (2, 'Artista', 'ARTIS');
INSERT INTO public.usua_rol(rol_id, rol_nombre, rol_sigla) VALUES (3, 'Comprador', 'COMPR');

INSERT INTO public.usua_usuario(
	usua_id, usua_nombre, usua_clave, usua_apellidos, usua_nombres, usua_email, usua_telefono, usua_genero, usua_direccion, usua_estado, rol_id)
	VALUES (1, 'admin', 'admin', 'admin', 'admin', 'admin@itshirt.com', '111', 'M', 'Calle falsa 123', 'A', 1);
