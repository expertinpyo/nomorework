CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(30) NOT NULL,
    google_token VARCHAR(200) NULL,
    naver_token VARCHAR(200) NULL,
    show_hour BOOLEAN DEFAULT TRUE,
    show_income BOOLEAN DEFAULT TRUE,
    hourly_income INTEGER DEFAULT 0
)
