CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL,
  `fio` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DELIMITER $$
CREATE FUNCTION `get_fio_max_salary`() RETURNS varchar(255) CHARSET utf8
BEGIN
	DECLARE ret_fio VARCHAR(255);
	SELECT fio INTO ret_fio FROM employees ORDER BY salary DESC LIMIT 1;
	RETURN IFNULL(ret_fio, '');
END$$
DELIMITER ;