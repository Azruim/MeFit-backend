insert into address (address_line_1, address_line_2, address_line_3, city, country, postal_code)
values ('Keskuskatu 1', null, null, 'Helsinki', 'Finland', '00100'),
       ('Sunset Blvd 1', null, null, 'Los Angeles', 'USA', 'CA 90024');

insert into profile (profile_id, disabilities, height, medical_conditions, weight, address_id)
values ('test', 'None', 1.83, 'None', 91.3, 1),
       ('db97085a-067f-46b3-b87b-2725560977d1', 'When beneficial', 186.7, 'The one requiring medical weed', 101.6, 2);

insert into exercise (description, image, name, target_muscle_group, vid_link, profile_id)
    values ('Lift your arms', null, 'Bench Press', 'Chest', null, 'test'),
           ('Fold your arm', null, 'Bicep Curl', 'Biceps', null, 'test'),
           ('Stand up', null, 'Squat', 'Quads', null, 'test'),
           ('Pull yourself up to the bar with palms facing forward.', null, 'Pull-up', 'Biceps', null, 'test'),
           ('Rest on your hands and toes and lower yourself to the ground and push your weight back up.', null, 'Push-up', 'Chest', null, 'test'),
           ('Hang from a bar and raise your legs keeping them straight.', null, 'Leg raise', 'Abs', null, 'test'),
           ('Hang from a bar for 10 seconds. Increase intensity by adding weight.', null, '10-second dead hang', 'Forearms', null, 'test');

insert into set (exercise_repetitions, exercise_id)
    values (6, 1), (10, 1), (12, 1),
           (10, 2), (12, 2), (8, 2),
           (10, 3), (12, 3), (6, 3),
           (5, 4), (10, 5), (20, 6),
           (6, 7);

insert into workout (name, type, profile_id)
values ('Tough bench press', 'Brawn', 'test'),
       ('Bench press warm-up', 'Warm-up', 'test'),
       ('Bench press stamina', 'Stamina', 'test'),
       ('Hard bicep training', 'Brawn', 'test'),
       ('Bicep warm-up', 'Warm-up', 'test'),
       ('Bicep stamina training', 'Stamina', 'test'),
       ('Hard Squat training', 'Brawn', 'test'),
       ('Squat warm-up', 'Warm-up', 'test'),
       ('Squat Stamina', 'Stamina', 'test'),
       ('Beginner pull-ups', 'Beginner', 'test'),
       ('Beginner push-ups', 'Beginner', 'test'),
       ('Six-pack shortcut', 'Strength', 'test'),
       ('Upper body warm-up', 'Warm-up','test');

insert into workout_set (workout_id, set_id)
values (1, 1), (1, 1), (1, 1),
       (2, 2), (2, 2), (2, 3),
       (3, 3), (3, 2), (3, 1),
       (4, 6), (4, 6), (4, 6),
       (5, 5), (5, 5), (5, 4),
       (6, 5), (6, 4), (6, 6),
       (7, 9), (7, 9), (7, 9),
       (10, 10), (11, 11), (12, 12),
       (13, 13);

insert into program (category, name, profile_id)
    values ('Full body workout' ,'Henry´s sweatpants', 'test'),
           ('Bodyweight Workout', 'Leaner and meaner ab cleaner', 'test');

insert into program_workout (program_id, workout_id)
    values (1, 1),(1, 2),(1, 7),
            (2, 12), (2, 12), (2, 12);


insert into goal (achieved, end_date, profile_id, program_id)
    values (false, '2022-03-10', 'test', 1),
           (false, '2022-06-01', 'db97085a-067f-46b3-b87b-2725560977d1', 2);

insert into goal_workout (goal_id, workout_id, completed)
    values (1, 1, false),
            (1, 2, false);



