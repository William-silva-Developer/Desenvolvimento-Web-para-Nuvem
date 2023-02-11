/*===========CRIANDO FUNÇÕES(ROLE) PARA OS USUÁRIOS==================*/
INSERT INTO `db_academico`.`role`
(`role_id`,
`role_name`)
VALUES
('6be00c49-e36a-4318-a7af-e56488031dab',
'ROLE_ADMIN');

INSERT INTO `db_academico`.`role`
(`role_id`,
`role_name`)
VALUES
('4510f56b-e09c-474c-844b-059ea67de607',
'ROLE_PROFESSOR');

INSERT INTO `db_academico`.`role`
(`role_id`,
`role_name`)
VALUES
('d9479bc5-4c01-4537-ba07-b2f40753fc9',
'ROLE_ALUNO');







/*===========CRIANDO USUÁRIOS==================*/
INSERT INTO `db_academico`.`usuario`
(`cod_usuario`,
`nome`,
`senha`,
`sobre_nome`)
VALUES
('f4726d3e-4bee-4ccf-8164-c97e09984811',
'william',
'$2a$10$We.T/tTe1UGXuYoHCgBHQuAPtIfhZtMFxbAuZL1rFSCF0lTff9lzi',
'silva');


INSERT INTO `db_academico`.`usuario`
(`cod_usuario`,
`nome`,
`senha`,
`sobre_nome`)
VALUES
('c9e52873-4167-4297-958c-8de306740548',
'amanda',
'$2a$10$We.T/tTe1UGXuYoHCgBHQuAPtIfhZtMFxbAuZL1rFSCF0lTff9lzi',
'nunes');

INSERT INTO `db_academico`.`usuario`
(`cod_usuario`,
`nome`,
`senha`,
`sobre_nome`)
VALUES
('5ada3f5d-4c76-4846-baf3-873be635cca3',
'htrs',
'$2a$10$We.T/tTe1UGXuYoHCgBHQuAPtIfhZtMFxbAuZL1rFSCF0lTff9lzi',
'da silva');


/*===========ATRIBUINDO O ROLE OU FUNÇÃO AO USUÁRIO==================*/
INSERT INTO `db_academico`.`tb_usuario_role`
(`usuario_cod`,
`role_cod`)
VALUES
('f4726d3e-4bee-4ccf-8164-c97e09984811',
'6be00c49-e36a-4318-a7af-e56488031dab');

INSERT INTO `db_academico`.`tb_usuario_role`
(`usuario_cod`,
`role_cod`)
VALUES
('c9e52873-4167-4297-958c-8de306740548',
'4510f56b-e09c-474c-844b-059ea67de607');

INSERT INTO `db_academico`.`tb_usuario_role`
(`usuario_cod`,
`role_cod`)
VALUES
('5ada3f5d-4c76-4846-baf3-873be635cca3',
'd9479bc5-4c01-4537-ba07-b2f40753fc9');

/*=======================================================*/