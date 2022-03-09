insert into exercise (description, image, name, target_muscle_group, vid_link)
    values ('Lift your arms', null, 'Bench Press', 'Chest', null),
           ('Fold your arm', null, 'Bicep Curl', 'Biceps', null),
           ('Stand up', null, 'Squat', 'Quads', null),
           ('Pull yourself up to the bar with palms facing forward.', null, 'Pull-up', 'Biceps', null ),
           ('Rest on your hands and toes and lower yourself to the ground and push your weight back up.', null, 'Push-up', 'Chest', null),
           ('Hang from a bar and raise your legs keeping them straight.', null, 'Leg raise', 'Abs', null),
           ('Hang from a bar for 10 seconds. Increase intensity by adding weight.', null, '10-second dead hang', 'Forearms', null);

insert into set (exercise_repetitions, exercise_id)
    values (6, 1), (10, 1), (12, 1),
           (10, 2), (12, 2), (8, 2),
           (10, 3), (12, 3), (6, 3),
           (5, 4), (10, 5), (20, 6),
           (6, 7);

insert into workout (complete, name, type)
    values (false, 'Tough bench press', 'Brawn'),
           (false, 'Bench press warm-up', 'Warm-up'),
           (false, 'Bench press stamina', 'Stamina'),
           (false, 'Hard bicep training', 'Brawn'),
           (false, 'Bicep warm-up', 'Warm-up'),
           (false, 'Bicep stamina training', 'Stamina'),
           (false, 'Hard Squat training', 'Brawn'),
           (false, 'Squat warm-up', 'Warm-up'),
           (false, 'Squat Stamina', 'Stamina'),
           (false, 'Beginner pull-ups', 'Beginner'),
           (false, 'Beginner push-ups', 'Beginner'),
           (false, 'Six-pack shortcut', 'Strength'),
           (false, 'Upper body warm-up', 'Warm-up');

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

insert into program (category, name)
    values ('Full body workout' ,'Henry´s sweatpants'),
           ('Bodyweight Workout', 'Leaner and meaner ab cleaner');

insert into program_workout (program_id, workout_id)
    values (1, 1),(1, 2),(1, 7),
            (2, 12), (2, 12), (2, 12);

insert into "user" (first_name, is_admin, is_contributor, last_name, password)
    values ('Pete', true, true, 'Hyrrä', 'admin'),
           ('Will', false, false, 'Smite', 'Summerbody22');

insert into address (address_line_1, address_line_2, address_line_3, city, country, postal_code)
    values ('Keskuskatu 1', null, null, 'Helsinki', 'Finland', '00100'),
           ('Sunset Blvd 1', null, null, 'Los Angeles', 'USA', 'CA 90024');

insert into profile (disabilities, height, medical_conditions, weight, address_id, user_id)
    values ('None', 1.83, 'None', 91.3, 1, 1),
           ('When beneficial', 186.7, 'The one requiring medical weed', 101.6, 2, 2);

insert into goal (achieved, end_date, profile_id, program_id)
    values (false, '2022-03-10', 1, 1),
           (false, '2022-06-01', 2, 2);

insert into goal_workout (end_date, goal_id, workout_id)
    values ('2022-03-08', 1, 1),
            ('2022-03-09', 1, 2);

insert into profile_workout (profile_id, workout_id)
    values (1, 6), (2, 10), (2, 11),
           (2, 12), (2, 13);


