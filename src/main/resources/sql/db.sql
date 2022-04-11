/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  tharindu
 * Created: Apr 12, 2022
 */

CREATE TABLE `players` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`email` VARCHAR(100) NOT NULL,
	`password` VARCHAR(500) NOT NULL,
	UNIQUE KEY `name_unq` (`name`) USING HASH,
        UNIQUE KEY `email_unq` (`email`) USING HASH,
	PRIMARY KEY (`id`)
);

insert into players(name, email, password) values ('tharu', 'tat', 'ttt');

select * from players;

CREATE TABLE `matches` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `end_date_time` TIMESTAMP NOT NULL,
    `score` INT NOT NULL,
    `player_id` INT NOT NULL,
    FOREIGN KEY (`player_id`) REFERENCES `players`(`id`),
    PRIMARY KEY (`id`)
    
);

insert into matches( end_date_time, score, player_id) values ('2021-01-12 12:00:00', 45, 1);

select * from players p inner join matches m on p.id = m.player_id;

