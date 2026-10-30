create table unidade (
	id uuid not null,
	criado_em timestamp(6) with time zone not null,
	atualizado_em timestamp(6) with time zone not null,
	criado_por uuid,
	atualizado_por uuid,
	situacao varchar(40) not null,
	motivo_inativacao varchar(255),
	inativado_por uuid,
	inativado_em timestamp(6) with time zone,
	nome varchar(255) not null,
	cnes varchar(7) not null,
	endereco varchar(255) not null,
	horario_funcionamento varchar(255) not null,
	constraint pk_unidade primary key (id),
	constraint uk_unidade_cnes unique (cnes),
	constraint ck_unidade_situacao check (situacao in ('ATIVO', 'INATIVO', 'CANCELADO'))
);
