drop table if exists team CASCADE 
CREATE TABLE IF NOT EXISTS `movie` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `movie_name` VARCHAR(40) DEFAULT NULL,
    `genre` VARCHAR(40) DEFAULT NULL,
    `year_released`INT(11) DEFAULT NULL,
    `available_on` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);