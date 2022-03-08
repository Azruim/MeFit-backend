insert into exercise (description, image, name, target_muscle_group, vid_link)
    values ('Lift your arms', null, 'Bench Press', 'Pectoral muscle', null),
           ('Fold your arm', null, 'Bicep Curl', 'Bicep', null),
           ('Stand up', null, 'Squat', 'Quad', null);

insert into set (exercise_repetitions, exercise_id)
    values (6, 1), (10, 1), (12, 1),
           (10, 2), (12, 2), (8, 2),
           (10, 3), (12, 3), (6, 3);

insert into workout (complete, name, type)
    values (false, 'Tough bench press', 'Brawn'),
           (false, 'Bench press warmup', 'Warm up'),
           (false, 'Bench press stamina', 'Stamina'),
           (false, 'Hard bicep training', 'Brawn'),
           (false, 'Bicep warmup', 'Warm Up'),
           (false, 'Bicep stamina training', 'Stamina'),
           (false, 'Hard Squat training', 'Brawn'),
           (false, 'Squat warmup', 'Warm up'),
           (false, 'Squat Stamina', 'Stamina');

insert into workout_set (workout_id, set_id)
    values (1, 1), (1, 1), (1, 1),
           (2, 2), (2, 2), (2, 3),
           (3, 3), (3, 2), (3, 1),
           (4, 6), (4, 6), (4, 6),
           (5, 5), (5, 5), (5, 4),
           (6, 5), (6, 4), (6, 6),
           (7, 9), (7, 9), (7, 9);

insert into program (category, name)
    values ('Full body workout' ,'Henry`s sweatpants');

insert into goal (achieved, end_date, program_id)
    values (false, '2022-03-10', 1);

insert into goal_workout (end_date, goal_id, workout_id)
    values ('2022-03-08', 1, 1),
           ('2022-03-09', 1, 2);

insert into program_workout (program_id, workout_id)
    values (1, 1),
           (1, 2),
           (1, 7);

insert into profile (disabilities, height, medical_conditions, weight, address_id, user_id)
    values ('None', 1.83, 'Diabetes', 91.3, null, null);