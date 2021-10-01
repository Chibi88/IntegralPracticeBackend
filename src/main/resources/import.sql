-- Creando roles de usuario y admin
INSERT INTO ROLES(ID, NAME) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USUARIO');

-- Creando usuarios correspondientes
INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (1, 'admin', 'admin'), (2, 'user', 'user');

-- Creando las relaciones
INSERT INTO USER_ROLES (ID_USER, ID_ROL) VALUES (1, 1), (1,2), (2, 2);