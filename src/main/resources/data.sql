INSERT INTO `flight`(
    `id`, `airline_id`, `arrival_time`, `departure_time`, `duration`, `fare`, `flight_number`, `seat_capacity`, `arrival_id`, `departure_id`)
VALUES
    (1, (SELECT `id` FROM `airline` WHERE `name` = 'IndiGo'), '2024-02-10 12:00:00', '2024-02-10 09:30:00', 150, 5000, 101, 150, 1, 2),
    (2, (SELECT `id` FROM `airline` WHERE `name` = 'Air India'), '2024-02-10 15:30:00', '2024-02-10 12:30:00', 180, 6000, 102, 200, 1, 2),
    (3, (SELECT `id` FROM `airline` WHERE `name` = 'SpiceJet'), '2024-02-10 18:00:00', '2024-02-10 16:00:00', 120, 4500, 103, 180, 1, 2),
    (4, (SELECT `id` FROM `airline` WHERE `name` = 'Vistara'), '2024-02-10 21:00:00', '2024-02-10 18:45:00', 135, 5500, 104, 170, 1, 2),
    (5, (SELECT `id` FROM `airline` WHERE `name` = 'GoAir'), '2024-02-10 23:30:00', '2024-02-10 20:45:00', 165, 4800, 105, 160, 1, 2),
    (6, (SELECT `id` FROM `airline` WHERE `name` = 'IndiGo'), '2024-02-10 12:30:00', '2024-02-10 10:00:00', 150, 5200, 106, 160, 3, 4),
    (7, (SELECT `id` FROM `airline` WHERE `name` = 'Air India'), '2024-02-10 16:00:00', '2024-02-10 13:00:00', 180, 6000, 107, 180, 3, 4),
    (8, (SELECT `id` FROM `airline` WHERE `name` = 'SpiceJet'), '2024-02-10 19:30:00', '2024-02-10 17:30:00', 120, 4700, 108, 200, 3, 4),
    (9, (SELECT `id` FROM `airline` WHERE `name` = 'Vistara'), '2024-02-10 22:00:00', '2024-02-10 19:45:00', 135, 5400, 109, 170, 3, 4),
    (10, (SELECT `id` FROM `airline` WHERE `name` = 'GoAir'), '2024-02-10 23:45:00', '2024-02-10 21:00:00', 165, 4900, 110, 190, 3, 4),
    (11, (SELECT `id` FROM `airline` WHERE `name` = 'IndiGo'), '2024-02-10 08:30:00', '2024-02-10 07:10:00', 140, 5000, 121, 150, 5, 6),
    (12, (SELECT `id` FROM `airline` WHERE `name` = 'Air India'), '2024-02-10 10:45:00', '2024-02-10 09:25:00', 160, 6000, 122, 180, 5, 6),
    (13, (SELECT `id` FROM `airline` WHERE `name` = 'SpiceJet'), '2024-02-10 13:15:00', '2024-02-10 10:30:00', 125, 4500, 123, 160, 5, 6),
    (14, (SELECT `id` FROM `airline` WHERE `name` = 'Vistara'), '2024-02-10 15:00:00', '2024-02-10 12:05:00', 155, 5500, 124, 170, 5, 6),
    (15, (SELECT `id` FROM `airline` WHERE `name` = 'GoAir'), '2024-02-10 07:00:00', '2024-02-10 04:10:00', 130, 4800, 125, 160, 5, 6),
    (16, (SELECT `id` FROM `airline` WHERE `name` = 'IndiGo'), '2024-02-10 11:30:00', '2024-02-10 09:10:00', 140, 5200, 131, 160, 9, 10),
    (17, (SELECT `id` FROM `airline` WHERE `name` = 'Air India'), '2024-02-10 13:45:00', '2024-02-10 11:25:00', 160, 6000, 132, 180, 9, 10),
    (18, (SELECT `id` FROM `airline` WHERE `name` = 'SpiceJet'), '2024-02-10 16:15:00', '2024-02-10 13:30:00', 125, 4700, 133, 200, 9, 10),
    (19, (SELECT `id` FROM `airline` WHERE `name` = 'Vistara'), '2024-02-10 18:00:00', '2024-02-10 15:05:00', 155, 5400, 134, 170, 9, 10),
    (20, (SELECT `id` FROM `airline` WHERE `name` = 'GoAir'), '2024-02-10 10:00:00', '2024-02-10 07:10:00', 130, 4900, 135, 190, 9, 10),
    (21, (SELECT `id` FROM `airline` WHERE `name` = 'IndiGo'), '2024-02-11 11:30:00', '2024-02-11 09:10:00', 140, 5200, 141, 160, 1, 2),
    (22, (SELECT `id` FROM `airline` WHERE `name` = 'Air India'), '2024-02-11 13:45:00', '2024-02-11 11:25:00', 160, 6000, 142, 180, 1, 2),
    (23, (SELECT `id` FROM `airline` WHERE `name` = 'SpiceJet'), '2024-02-11 16:15:00', '2024-02-11 13:30:00', 125, 4700, 143, 200, 1, 2),
    (24, (SELECT `id` FROM `airline` WHERE `name` = 'Vistara'), '2024-02-11 18:00:00', '2024-02-11 15:05:00', 155, 5400, 144, 170, 1, 2),
    (25, (SELECT `id` FROM `airline` WHERE `name` = 'GoAir'), '2024-02-11 10:00:00', '2024-02-11 07:10:00', 130, 4900, 145, 190, 1, 2);

