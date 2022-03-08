insert into exercise (description, image, name, target_muscle_group, vid_link)
    values ('Penkki treeni', null, 'Pena', 'Rintalihakset', null),
           ('Hauis treeni', null, 'Haukka', 'Hauislihakset', null),
           ('Jalka treeni', null, 'Kyykky', 'Reisilihakset', null);

insert into set (exercise_repetitions, exercise_id)
    values (10, 1),
           (12, 1),
           (10, 2),
           (12, 2),
           (10, 3),
           (12, 3),
           (8, 1),
           (6, 2),
           (6, 3),
           (8, 2);

insert into workout (complete, name, type, set_id)
    values (false, 'Pena', 'Lihasmassa', 7),
           (false, 'Penaan alkulämmöt', 'Kestävyys', 2),
           (false, 'Haukkaan lämpöä', 'Kestävyys', 3),
           (false, 'Haukka alkulämmöt', 'Kestävyys', 4),
           (false, 'Jalkoihin lämpöä', 'Kestävyys', 5),
           (false, 'Kunnon haukka', 'Lihasmassa', 8),
           (false, 'Jalkapäivä', 'Lihasmassa', 9),
           (false, 'Pena lämpöö', 'Kestävyys', 1),
           (false, 'Haukka setti', 'Lihasmassa', 10);

