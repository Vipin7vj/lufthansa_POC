INSERT INTO lufthansa.flight (arrival_time,departure_time,duration,fare,flight_number,seat_capacity,airline_id,arrival_id,departure_id) VALUES
	 ('2024-02-10 12:00:00','2024-02-10 09:30:00',150,5000,101,147,1,1,2),
	 ('2024-02-10 15:30:00','2024-02-10 12:30:00',180,6000,102,200,3,1,2),
	 ('2024-02-10 18:00:00','2024-02-10 16:00:00',120,4500,103,174,2,1,2),
	 ('2024-02-10 21:00:00','2024-02-10 18:45:00',135,5500,104,170,5,1,2),
	 ('2024-02-10 23:30:00','2024-02-10 20:45:00',165,4800,105,160,4,1,2),
	 ('2024-02-10 12:30:00','2024-02-10 10:00:00',150,5200,106,160,1,3,4),
	 ('2024-02-10 16:00:00','2024-02-10 13:00:00',180,6000,107,180,3,3,4),
	 ('2024-02-10 19:30:00','2024-02-10 17:30:00',120,4700,108,200,2,3,4),
	 ('2024-02-10 22:00:00','2024-02-10 19:45:00',135,5400,109,170,5,3,4),
	 ('2024-02-10 23:45:00','2024-02-10 21:00:00',165,4900,110,190,4,3,4);
INSERT INTO lufthansa.flight (arrival_time,departure_time,duration,fare,flight_number,seat_capacity,airline_id,arrival_id,departure_id) VALUES
	 ('2024-02-10 08:30:00','2024-02-10 07:10:00',140,5000,121,150,1,5,6),
	 ('2024-02-10 10:45:00','2024-02-10 09:25:00',160,6000,122,180,3,5,6),
	 ('2024-02-10 13:15:00','2024-02-10 10:30:00',125,4500,123,160,2,5,6),
	 ('2024-02-10 15:00:00','2024-02-10 12:05:00',155,5500,124,170,5,5,6),
	 ('2024-02-10 07:00:00','2024-02-10 04:10:00',130,4800,125,160,4,5,6),
	 ('2024-02-10 11:30:00','2024-02-10 09:10:00',140,5200,131,160,1,9,10),
	 ('2024-02-10 13:45:00','2024-02-10 11:25:00',160,6000,132,180,3,9,10),
	 ('2024-02-10 16:15:00','2024-02-10 13:30:00',125,4700,133,200,2,9,10),
	 ('2024-02-10 18:00:00','2024-02-10 15:05:00',155,5400,134,170,5,9,10),
	 ('2024-02-10 10:00:00','2024-02-10 07:10:00',130,4900,135,190,4,9,10);
INSERT INTO lufthansa.flight (arrival_time,departure_time,duration,fare,flight_number,seat_capacity,airline_id,arrival_id,departure_id) VALUES
	 ('2024-02-11 11:30:00','2024-02-11 09:10:00',140,5200,141,160,1,1,2),
	 ('2024-02-11 13:45:00','2024-02-11 11:25:00',160,6000,142,180,3,1,2),
	 ('2024-02-11 16:15:00','2024-02-11 13:30:00',125,4700,143,200,2,1,2),
	 ('2024-02-11 18:00:00','2024-02-11 15:05:00',155,5400,144,170,5,1,2),
	 ('2024-02-11 10:00:00','2024-02-11 07:10:00',130,4900,145,190,4,1,2);

INSERT INTO lufthansa.airline (code,name) VALUES
	 ('6E','IndiGo'),
	 ('SG','SpiceJet'),
	 ('AI','Air India'),
	 ('G8','GoAir'),
	 ('UK','Vistara'),
	 ('I5','AirAsia India'),
	 ('9W','Jet Airways'),
	 ('IX','Air India Express'),
	 ('UKI','Air Vistara'),
	 ('AIC','Air India (Regional)');

INSERT INTO lufthansa.airport (city,country,name) VALUES
	 ('Mumbai','India','Chhatrapati Shivaji Maharaj International Airport'),
	 ('Delhi','India','Indira Gandhi International Airport'),
	 ('Bangalore','India','Kempegowda International Airport'),
	 ('Chennai','India','Chennai International Airport'),
	 ('Hyderabad','India','Rajiv Gandhi International Airport'),
	 ('Kolkata','India','Netaji Subhas Chandra Bose International Airport'),
	 ('Ahmedabad','India','Sardar Vallabhbhai Patel International Airport'),
	 ('Pune','India','Pune Airport'),
	 ('Jaipur','India','Jaipur International Airport'),
	 ('Lucknow','India','Chaudhary Charan Singh International Airport');


INSERT INTO lufthansa.booking (flight_id,user_id,traveller_name,booking_status) VALUES
	 (1,20,NULL,NULL),
	 (1,20,NULL,NULL),
	 (3,4,'John Doe',NULL),
	 (3,4,'Jane Doe',NULL),
	 (3,4,'Alice',NULL),
	 (3,1,'Viyaan','Confirmed'),
	 (3,1,'Yashi','Confirmed'),
	 (3,1,'Vipin','Confirmed'),
	 (3,1,'VArsha','Cancelled'),
	 (3,1,'Basant','Cancelled');

INSERT INTO lufthansa.`user` (address,contact_no,email_id,gender,name) VALUES
	 ('456 Park Avenue, Delhi','+91 8765432109','aisha.patel@example.com',1,'Aisha Patel'),
	 ('789 Oak Lane, Bangalore','+91 7654321098','aditya.singh@example.com',0,'Aditya Singh'),
	 ('101 Pine Road, Chennai','+91 6543210987','ananya.sharma@example.com',1,'Ananya Sharma'),
	 ('202 Cedar Drive, Hyderabad','+91 5432109876','arjun.gupta@example.com',0,'Arjun Gupta'),
	 ('303 Birch Street, Kolkata','+91 4321098765','avni.joshi@example.com',1,'Avni Joshi'),
	 ('404 Elm Court, Ahmedabad','+91 3210987654','aryan.khanna@example.com',0,'Aryan Khanna'),
	 ('505 Maple Avenue, Pune','+91 2109876543','amara.desai@example.com',1,'Amara Desai'),
	 ('606 Walnut Lane, Jaipur','+91 1098765432','advait.trivedi@example.com',0,'Advait Trivedi'),
	 ('707 Pineapple Road, Lucknow','+91 0987654321','anika.mehta@example.com',1,'Anika Mehta'),
	 ('123 Main St, City','1234567890','john.doe@example.com',0,'John Doe');

