CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `credit_card_info` (
  `cc_id` int NOT NULL AUTO_INCREMENT,
  `cc_number` varchar(100) DEFAULT NULL,
  `cc_bank` varchar(100) DEFAULT NULL,
  `cc_name` varchar(100) DEFAULT NULL,
  `cc_type` varchar(45) DEFAULT NULL,
  `exp_date` varchar(45) DEFAULT NULL,
  `cvv` varchar(45) DEFAULT NULL,
  `name_on_card` varchar(100) DEFAULT NULL,
  `statement_date` varchar(45) DEFAULT NULL,
  `due_date` varchar(45) DEFAULT NULL,
  `cc_limit` varchar(45) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`cc_id`),
  KEY `cc_user_idx` (`user_id`),
  CONSTRAINT `cc_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `cc_due_details_info` (
  `cc_due_id` int NOT NULL AUTO_INCREMENT,
  `cc_id` int DEFAULT NULL,
  `due_amt` double DEFAULT NULL,
  `minimum_due` double DEFAULT NULL,
  `total_outstanding` varchar(45) DEFAULT NULL,
  `statement_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `is_paid` tinyint DEFAULT NULL,
  PRIMARY KEY (`cc_due_id`),
  KEY `due_cc_id_idx` (`cc_id`),
  CONSTRAINT `due_cc_id` FOREIGN KEY (`cc_id`) REFERENCES `credit_card_info` (`cc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;