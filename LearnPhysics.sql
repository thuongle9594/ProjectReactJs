DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;
DROP TABLE IF EXISTS Course;
CREATE TABLE Course (
    CourseID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CourseName NVARCHAR(30) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
    AccountID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
    Username VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName NVARCHAR(50) NOT NULL,
    CourseID TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CourseID)
        REFERENCES Course (CourseID)
    
);

INSERT INTO Course(CourseName)
VALUES
(N'THCS' ),
(N'THPT' ),
(N'Đại học' ),
(N'Cao học' ),
(N'Bổ túc toán' );

INSERT INTO `Account`(Email , Username, FullName , CourseID , CreateDate)
VALUES 
('Email1@gmail.com' ,'Username1' ,'Fullname1' , '1','2020-03-05'),
('Email2@gmail.com' ,'Username2' ,'Fullname2' , '2','2020-03-05'),
('Email3@gmail.com' , 'Username3' ,'Fullname3', '2' ,'2020-03-07'),
('Email4@gmail.com' , 'Username4' ,'Fullname4', '4' ,'2020-03-08'),
('Email5@gmail.com' , 'Username5' ,'Fullname5', '5' ,'2020-03-10'),
('Email6@gmail.com' , 'Username6' ,'Fullname6', '3' ,'2020-04-05'),
('Email7@gmail.com' , 'Username7' ,'Fullname7', '2' , NULL ),
('Email8@gmail.com' , 'Username8' ,'Fullname8', '1' ,'2020-04-07'),
('Email9@gmail.com' , 'Username9' ,'Fullname9', '2' ,'2020-04-07'),
('Email10@gmail.com' , 'Username10' ,'Fullname10', '5' ,'2020-04-09'),
('Email11@gmail.com' , 'Username11' ,'Fullname11', '1' , DEFAULT),
('Email12@gmail.com' , 'Username12','Fullname12' , '1' , DEFAULT);