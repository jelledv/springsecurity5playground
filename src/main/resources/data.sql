INSERT INTO roles (id, name) VALUES (1, 'USER');
INSERT INTO roles (id, name) VALUES (2, 'ADMIN');
INSERT INTO users (id, username, email, role_id, password) VALUES (0, 'jelle', 'jelle.de.vleminck@gmail.com', 2, '{bcrypt}$2a$14$PAIbS/m0EJX8m2WBYWoNRu7q10zJAeOCD9QUn1e11Jz1B1W9nqxcq')