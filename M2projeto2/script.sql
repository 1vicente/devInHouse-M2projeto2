/* Endereços */
INSERT INTO ENDERECOS (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES ('Jacatanduba','88100-00','São José','Casa','Santa Catarina','Rua Dois','33','Campo de futebol');
INSERT INTO ENDERECOS (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES ('Esperança','88200-00','Forquilinha','AP 102','Santa Catarina','Rua Três','44','Ed. Jardins');
INSERT INTO ENDERECOS (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES ('Iguatinga','88300-00','Gov. Celso Ramos','Centro Comercial','Santa Catarina','Rua Quatro','55','Campo de Basebal');
INSERT INTO ENDERECOS (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES ('Ferrugem','88400-00','Florianópolis','Loja 3','Santa Catarina','Rua Cinco','66','Loja de esquina');

/* Pacientes */
INSERT INTO PACIENTES (cpf, data_nascimento, email, estado_civil, naturalidade, nome_completo, rg, telefone, convenio, contato_emergencia, lista_alergia, cuidados_especificos, numero_convenio, validade_convenio, endereco_id, genero) 
    VALUES ('09908562088', '23/01/1994','vicente@sql.com','Solteiro','Florianopolis','Vicente Paciente SQL Insert','1234567','(48) 99999-9999','Unimed','(48) 99999-9999','Pelo de gato','N/A','8888-888','23/11/2025',1,'Masculino');
INSERT INTO PACIENTES (cpf, data_nascimento, email, estado_civil, naturalidade, nome_completo, rg, telefone, convenio, contato_emergencia, lista_alergia, cuidados_especificos, numero_convenio, validade_convenio, endereco_id, genero) 
    VALUES ('52387177096', '23/01/1994','vicente2@sql.com','Solteiro','Florianopolis','Vicente Paciente2 SQL Insert','1234567','(48) 99999-9999','Unimed','(48) 99999-9999','Pelo de gato','N/A','8888-888','23/11/2025',2,'Masculino');

/* Medicos */
INSERT INTO MEDICOS (cpf, data_nascimento, email, estado_civil, naturalidade, nome_completo, rg, telefone, crm, especializacao_clinica, senha, genero) 
    VALUES ('52387177096', '23/01/1994','vicente@sql.com','Solteiro','Florianopolis','Vicente Medico SQL Insert','1234567','(48) 99999-9999','123123-123','Pediatria','SenhaSQL123','Masculino');
INSERT INTO MEDICOS (cpf, data_nascimento, email, estado_civil, naturalidade, nome_completo, rg, telefone, crm, especializacao_clinica, senha, genero) 
    VALUES ('32552050000', '23/01/1994','vicente2@sql.com','Solteiro','Florianopolis','Vicente Medico2 SQL Insert','1234567','(48) 99999-9999','123123-123','Dermatologia','SenhaSQL123','Masculino');

/* Exames */
INSERT INTO EXAMES (data, laboratorio, resultado, tipo, nome, url, id_medico_id, id_paciente_id) VALUES ('25/04/2023','Santa Luzia','Baixo teor de Ferro','Sangue','Exame de sangue','https://google.com',1,1);
INSERT INTO EXAMES (data, laboratorio, resultado, tipo, nome, url, id_medico_id, id_paciente_id) VALUES ('25/04/2023','Santa Rita','Desgaste no joelho','Imagem','Ressonância Magnética','https://google.com',1,2);
INSERT INTO EXAMES (data, laboratorio, resultado, tipo, nome, url, id_medico_id, id_paciente_id) VALUES ('26/04/2023','Clinica Sangue Fresco','Exame com resultados normais','Sangue','Exame de rotina','https://google.com',2,1);
INSERT INTO EXAMES (data, laboratorio, resultado, tipo, nome, url, id_medico_id, id_paciente_id) VALUES ('26/04/2023','Lab. Hercílio Luz','Alérgico a cacau','Teste Alérgico','Teste alérgico alimentar','https://google.com',2,2);

/* Consultas */
INSERT INTO CONSULTAS (data, descricao_problema, dosagens_precaucoes, medicacao_receitada, motivo, id_medico_id, id_paciente_id) VALUES ('25/04/2023','Palidez','1x por dia','Comer Feijão e Beterraba','Palidez',1,1);
INSERT INTO CONSULTAS (data, descricao_problema, dosagens_precaucoes, medicacao_receitada, motivo, id_medico_id, id_paciente_id) VALUES ('25/04/2023','Dores no Joelho','1x por dia','Omega3 300mg','Dores no Joelho',1,2);
INSERT INTO CONSULTAS (data, descricao_problema, dosagens_precaucoes, medicacao_receitada, motivo, id_medico_id, id_paciente_id) VALUES ('25/04/2023','Consulta de rotina','N/A','N/A','Consulta de Rotina sem queixas',2,1);
INSERT INTO CONSULTAS (data, descricao_problema, dosagens_precaucoes, medicacao_receitada, motivo, id_medico_id, id_paciente_id) VALUES ('25/04/2023','Pontos vermelho no corpo','1x por dia','Antialérgico','Pontos vermelho no corpo',2,2);
