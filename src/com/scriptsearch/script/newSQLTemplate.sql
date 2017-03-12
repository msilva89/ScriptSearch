/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  murilo.silva
 * Created: 03/03/2017
 */

create table script
(
   id_script bigserial primary key, ds_descricao varchar(150), ds_query text
);


create table usuario(
	id_usuario bigserial primary key,
	nm_usuario varchar(15) not null,
	nm_login varchar(50) not null,
	ds_senha varchar(150) not null,
        fl_admin boolean
);
